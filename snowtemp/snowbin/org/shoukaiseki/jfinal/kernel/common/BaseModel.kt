package org.shoukaiseki.jfinal.kernel.common

import com.alibaba.fastjson.JSONObject
import com.alibaba.fastjson.annotation.JSONField
import com.alibaba.fastjson.serializer.SerializerFeature
import com.google.common.base.Optional
import com.google.common.base.Preconditions
import com.google.common.collect.Maps
import com.jfinal.plugin.activerecord.Db
import com.jfinal.plugin.activerecord.Record
import org.apache.commons.collections4.map.CaseInsensitiveMap
import org.apache.log4j.Logger
import org.shoukaiseki.jfinal.kernel.SnowConfig
import org.shoukaiseki.jfinal.kernel.SnowDB
import org.shoukaiseki.jfinal.kernel.WebClient
import org.shoukaiseki.jfinal.kernel.exception.SnowException
import org.shoukaiseki.jfinal.kernel.logger.SnowLogger
import org.shoukaiseki.jfinal.kernel.login.model.User
import org.shoukaiseki.jfinal.kernel.maximo.utils.MaximoDB
import org.shoukaiseki.jfinal.kernel.plugin.SqlReadConfig
import org.shoukaiseki.jfinal.kernel.utils.*
import java.lang.reflect.Field
import java.lang.reflect.Method
import java.lang.reflect.Modifier
import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*
import kotlin.collections.HashMap


/**
 * org.shoukaiseki.jfinal.kernel.common.BaseModel

 * @param <M>
 * *
 * *
 * @author 蒋カイセキ Japan-Tokyo  2017年3月29日 ブログ http://shoukaiseki.blog.163.com/ E-メール jiang28555@Gmail.com
</M> */
//@SnowTable(maxObjecxtName = "MULTIASSETLOCCI")
abstract class BaseModel {

    @SnowField(isPersistent = false)
    @JSONField(serialize = false)
    var parentbasemodel:BaseModel?=null

    @SnowField(isPersistent = false)
    @JSONField(serialize = false)
    var snowDb: SnowDB? = null

    @SnowField(isPersistent = false)
    @JSONField(serialize = false)
    var basemodelUser: User? = null

    @SnowField(isPersistent = false)
    @JSONField(serialize = false)
    var maxDB: MaximoDB? = null

    @SnowField(isPersistent = false)
    open var snow_rn: Int? = null

    /**
     * 删除标识,只限于子表,子表某行需要删除时设置该字段为 true
     */
    @SnowField(isPersistent = false)
    open var ms_tobedelete = false

    /**
     * app端唯一 id ,用于在新建时返回 该 id 对应的实际 oracle 主键信息
     */
    @SnowField(isPersistent = false)
    open var ms_id: String? = null

    /**
     * 修改标识,如果修改,则进行 update 操作,否则不处理
     */
    @SnowField(isPersistent = false)
    open var ms_tobemodify: Boolean = false

    /**
     * 新增标识,如果新增,则进行 add 操作,否则不处理
     */
    @SnowField(isPersistent = false)
    open var ms_toadd: Boolean = false

    @SnowField(isInsertIgnore = true, isUpdateIgnore = true)
    open var rowstamp: Long? = null


    @SnowField(isUpdateIgnore = true)
    open var orgid: String? = null

    @SnowField(isUpdateIgnore = true)
    open var siteid: String? = null

    @SnowField(isPersistent = false)
    open var status: String? = null

    /** 格式化成10位字符,不足前面补零
     * @return
     */
    fun formatSnow_rn(): String {
        return snow_rnDF.format(this.snow_rn)
    }

    fun <T> copyChildrenToMe(source: BaseModel): T? {
        var fields: List<Field> = ClassUtils.getFieldsAndToSuperStop(source.javaClass, BaseModel::class.java)
        for (fi in fields) {
            //非容器类变量(map,list等)忽略
            if (!source.isCollectionField(fi)) {
                continue
            }
            //final 终态修饰的变量不处理
            if (Modifier.isFinal(fi.modifiers)) {
                continue
            }

            //static 静态修饰的变量不处理
            if (Modifier.isStatic(fi.modifiers)) {
                continue
            }

            // 设置些属性是可以访问的
            fi.isAccessible = true
            val name = fi.name
            var valueObj: Any?
            try {
                valueObj = fi.get(source)
            } catch (e: Exception) {
                valueObj = null
                log.error("name=" + name + "|" + e.toString())
                e.printStackTrace()
            }

            var method: Method? = null
            // 将属性的首字符大写，方便构造get，set方法
            val attr = name.substring(0, 1).toUpperCase() + name.substring(1)
            try {
                method = source.javaClass.getMethod("set" + attr,
                        fi.type)
                method!!.invoke(this, valueObj)

            } catch (e: Exception) {
                log.error(" Exception : " + e.toString())
                e.printStackTrace()
                throw SnowException(10000, e)
            }

        }


        return null
    }

    /** 在执行 recordTo 之后 执行该方法,该方法用于个别 model
     * <br></br> 比如 Relatedrecord 表有个 class 字段名,java 中不允许采用这种命名方式
     * <br></br> 在java中用 sourceclass 字段代替数据库中的 class 字段
     * <br></br> 所有增加该方法,用于手动设置值,在该方法中写 setSourceclass(re.getStr("CLASS"))
     * @param re
     */
    open fun recordToAfter(re: Record) {

    }


    fun toObjectMap(): Map<String, Any> {
        return toObjectMap(BaseModel::class.java)
    }

    private fun toObjectMap(endclazz: Class<BaseModel>): Map<String, Any> {
        // TODO Auto-generated method stub
        val map = CaseInsensitiveMap<String, Any>()

        var fields: List<Field> = arrayListOf()

        fields = ClassUtils.getFieldsAndToSuperStop(this.javaClass, endclazz)

        var name: String
        var valueObj: Any?
        var type: String
        var value = ""

        //用于存放已经使用过的字段名,如果子类拥有字段,则忽略父类声明的字段描述
        val tempattname = ArrayList<String>()
        // 遍历所有属性
        for (fi in fields) {
            //			//主键字段 则不处理
            //			if (AnnotationUtils.isPrimary(fi)
            //					) {
            //				continue;
            //			}

            name = fi.name
            if (tempattname.contains(name)) {
                continue
            } else {
                tempattname.add(name)
            }

            //虚拟字段 则不处理
            if (!AnnotationUtils.isPersistent(fi)) {
                continue
            }
            //如果插入时忽略则不处理
            if (AnnotationUtils.isInsertIgnore(fi)) {
                continue
            }
            //final 终态修饰的变量不处理
            if (Modifier.isFinal(fi.modifiers)) {
                continue
            }

            //static 静态修饰的变量不处理
            if (Modifier.isStatic(fi.modifiers)) {
                continue
            }

            // 设置些属性是可以访问的
            fi.isAccessible = true
            name = fi.name
            try {
                valueObj = fi.get(this)
            } catch (e: Exception) {
                valueObj = ""
                log.error("name=" + name + "|" + e.toString())
                e.printStackTrace()
            }

            //字段大小写转换
            name = name.toLowerCase()

            type = fi.type.toString().toLowerCase()
            val typeName = fi.type.name
            if (isCollectionField(fi)) {
                log.debug("忽略类型:$typeName 字段名:$name")
                continue
            }

            if (valueObj == null) {
                //log.debug("map:" + name + "|" + type + "|" + val);
                map.put(name, "")
                continue
            }
            if (StringExpand.binarySearch(
                    arrayOf("java.util.Boolean", "boolean"), typeName)) {
                value = if (valueObj as Boolean) "1" else "0"
            } else if (type.indexOf("int") > 0 || type.indexOf("double") > 0
                    || type.indexOf("bigdecimal") > 0
                    || type.indexOf("long") > 0 || type.indexOf("float") > 0) {
                value = StringUtils.numberFormat(valueObj)
            } else if (type.indexOf("date") > 0) {
                value = "to_date('" + StringUtils.sdf.format(valueObj) + "','yyyy-mm-dd hh24:mi:ss')"
            } else if (type.indexOf("boolean") > 0) {
                value = if (valueObj.toString() == "true") "1" else "0"
            } else {
                value = "'$valueObj'"
            }
            log.error("name=$name,value=$value")
            map.put(name, value)
        }

        toInsertMapAfter(map)


        return map
    }

    fun toInsertMap(endclazz: Class<*>): Map<String, Any> {
        return toInsertMap(1, endclazz)
    }

    /**
     * 将对象本身按insert sql的格式组装出属性名 和 值

     * @param casei  字段大小写转换,为 0  表示转换为小写 , 为 1 则表示转换为大写,其它则表示不做转换
     * *
     * @param endclazz 搜索字段时到该对象结束,包括该对象
     * *
     * @return
     * *
     * @Description:
     */
    @JvmOverloads fun toInsertMap(casei: Int = 1, endclazz: Class<*> = BaseModel::class.java): Map<String, Any> {
        val map = CaseInsensitiveMap<String, Any>()

        var fields: List<Field> = ArrayList()

        fields = ClassUtils.getFieldsAndToSuperStop(this.javaClass, endclazz)

        var name: String
        var valueObj: Any?
        var type: String
        var value: Any? = null

        //用于存放已经使用过的字段名,如果子类拥有字段,则忽略父类声明的字段描述
        val tempattname = ArrayList<String>()
        // 遍历所有属性
        for (fi in fields) {
            //			//主键字段 则不处理
            //			if (AnnotationUtils.isPrimary(fi)
            //					) {
            //				continue;
            //			}

            name = fi.name
            if (tempattname.contains(name)) {
                continue
            } else {
                tempattname.add(name)
            }

            //虚拟字段 则不处理
            if (!AnnotationUtils.isPersistent(fi)) {
                continue
            }
            //如果插入时忽略则不处理
            if (AnnotationUtils.isInsertIgnore(fi)) {
                continue
            }
            //final 终态修饰的变量不处理
            if (Modifier.isFinal(fi.modifiers)) {
                continue
            }

            //static 静态修饰的变量不处理
            if (Modifier.isStatic(fi.modifiers)) {
                continue
            }

            // 设置些属性是可以访问的
            fi.isAccessible = true
            name = fi.name
            try {
                valueObj = fi.get(this)
            } catch (e: Exception) {
                valueObj = ""
                log.error("name=" + name + "|" + e.toString())
                e.printStackTrace()
            }

            //字段大小写转换
            when (casei) {
                0 -> name = name.toLowerCase()
                1 -> name = name.toUpperCase()
                else -> {
                }
            }

            type = fi.type.toString().toLowerCase()
            val typeName = fi.type.name
            if (isCollectionField(fi)) {
                log.debug("忽略类型:$typeName 字段名:$name")
                continue
            }
            //			log.debug("类型:"+typeName+" 字段名:"+name);

            if (valueObj == null) {
                //log.debug("map:" + name + "|" + type + "|" + val);
                map.put(name, null)
                continue
            }
            if (StringExpand.binarySearch(
                    arrayOf("java.util.Boolean", "boolean"), typeName)) {
                value = if (valueObj as Boolean) 1 else 0
            } else if (type.indexOf("int") > 0 || type.indexOf("double") > 0
                    || type.indexOf("bigdecimal") > 0
                    || type.indexOf("long") > 0 || type.indexOf("float") > 0) {
                value = StringUtils.numberFormat(valueObj)
            } else if (type.indexOf("date") > 0) {
                value = java.sql.Timestamp((valueObj as Date).time)

            } else if (type.indexOf("boolean") > 0) {
                value = if (valueObj.toString() == "true") 1 else 0
            } else {
                value = valueObj
            }
            log.error("name=$name,value=$value")
            map.put(name, value)
        }

        toInsertMapAfter(map)

        return map
    }

    /** 类似于 recordToAfter
     * [BaseModel.recordToAfter]
     * @param map
     */
    open fun toInsertMapAfter(map: MutableMap<String, Any>) {
        // TODO Auto-generated method stub

    }

    /**
     * 生成删除该条记录的sql语句

     * @return the string
     */
    fun toDeleteString(): String {
        // TODO Auto-generated method stub
        val tablename = AnnotationUtils.getMaxEntityName(javaClass)
        val uniqueIDName = showMaxUniqueIDName()
        val uniqueIDValue = showMaxUniqueIDValueToString()
        val sb = StringBuffer("delete from ").append(tablename)
                .append(" where ").append(uniqueIDName).append("=").append(uniqueIDValue)
        return sb.toString()
    }

    /** 验证数据是否可更新
     * @param obj
     * *
     * @throws SnowException
     */
    @Throws(SnowException::class)
    fun modifyVerification() {
        // TODO Auto-generated method stub
        val tablename = AnnotationUtils.getMaxEntityName(javaClass)
        val uniqueIDName = showMaxUniqueIDName()
        val uniqueIDValue = showMaxUniqueIDValueToString()

        val sb = StringBuffer("select * from ").append(tablename)
                .append(" where ").append(uniqueIDName).append("=").append(uniqueIDValue)
        log.debug("sql=" + sb.toString())
        val record = Db.findFirst(sb.toString()) ?: throw SnowException(3001)
                .setParams(*arrayOf<Any>(tablename, uniqueIDName, uniqueIDValue))
        val rowtemp = TypeConversionUtils.longByObject(record.get<Any>("ROWSTAMP"))
        if (rowtemp != rowstamp) {
            throw SnowException(3002)
                    .setParams(*arrayOf<Any>(tablename, uniqueIDName, uniqueIDValue, rowstamp as Any, rowtemp))
        }
    }

    open fun showMaxSequenceName():String{
        val st=AnnotationUtils.getSnowTable(this.javaClass)
        var name:String=st.maxSequenceName
        if(!StringUtils.isBlank(name)){
            return name
        }
        Preconditions.checkNotNull(null,"${javaClass.getName()} 类的 SnowTable 注释信息 未设置  maxSequenceName 信息")
        return ""
    }

    /** 返回数据库对应的表名
     * @return 表名
     */
    open fun showMaxTableName(): String {
        val st=AnnotationUtils.getSnowTable(this.javaClass)
        var name:String=st.maxObjecxtName
        if(!StringUtils.isBlank(name)){
            return name
        }
        Preconditions.checkNotNull(null,"${javaClass.getName()} 类的 SnowTable 注释信息 未设置  maxObjecxtName 信息")
        return ""
    }

    /** 返回数据库表名称
     * @return 表名
     */
    fun showMaxEntityName(): String {
        val st=AnnotationUtils.getSnowTable(this.javaClass)
        var name:String=st.maxEntityName
        if(!StringUtils.isBlank(name)){
            return name
        }
        name=st.maxObjecxtName
        if(!StringUtils.isBlank(name)){
            return name
        }
        Preconditions.checkNotNull(null,"${javaClass.getName()} 类的 SnowTable 注释信息 未设置 maxEntityName 或 maxObjecxtName 信息");
        return ""
    }


    /** 返回流程中使用的表名
     * @return 表名
     */
    fun showMaxWFTableName(): String {
        val st=AnnotationUtils.getSnowTable(this.javaClass)
        var name:String=st.maxWFTableName
        if(!StringUtils.isBlank(name)){
            return name
        }
        name=st.maxObjecxtName
        if(!StringUtils.isBlank(name)){
            return name
        }
        Preconditions.checkNotNull(null,"${javaClass.getName()} 类的 SnowTable 注释信息 未设置 maxWFTableName 或 maxObjecxtName 信息");
        return ""
    }

    /** 返回该表的主键id的String值
     * @return 主键id
     */
    fun showMaxUniqueIDValueToString(): String {
        return StringUtils.numberFormat(showMaxUniqueIDValue())
    }

    fun putMaxUniqueIDValue(id: Long=DBUtils.nextSequenceValue(showMaxSequenceName())) {
        val errorSB=StringBuilder()
        try {
            var unName=showMaxUniqueIDName()
            val methodName="set${unName.substring(0,1).toUpperCase()}${unName.substring(1).toLowerCase()}"
            log.debug("methodName=$methodName")
            errorSB.append("methodName=$methodName")
            log.debug("value=$id")
            log.debug("javaClass=$javaClass")
            var method=javaClass.getMethod(methodName,java.lang.Long::class.java)
            method.invoke(this,id )

        }catch (e:Exception){
            e.printStackTrace()
            log.error("${errorSB.toString()}",e)
            throw NullPointerException(javaClass.name + " 类SnowTable 注释信息 未设置 maxUniqueIDName 信息 或者 没有重写  putMaxUniqueIDValue 方法,无法获取有效地值")
        }
    }

    /** 返回该表的主键id
     * @return 主键id
     */
    open fun showMaxUniqueIDValue(): Long? {
        val errorSB=StringBuilder()
        try {
            var unName=showMaxUniqueIDName()
            val methodName="get${unName.substring(0,1).toUpperCase()}${unName.substring(1).toLowerCase()}"
            log.debug("methodName=$methodName")
            errorSB.append("methodName=$methodName")
            var value:Long? = javaClass.getMethod(methodName).invoke(this) as Long
            log.debug("value=$value")
            errorSB.append(",value=$value")
            return value

        }catch (e:Exception){
            e.printStackTrace()
            log.error("${errorSB.toString()}",e)
            throw NullPointerException(javaClass.name + " 类SnowTable 注释信息 未设置 maxUniqueIDName 信息 或者 没有重写  showMaxUniqueIDValue 方法,无法获取有效地值")
        }
    }

    /** 返回该表的主键名
     * @return 主键名
     */
    open fun showMaxUniqueIDName(): String {
        val st=AnnotationUtils.getSnowTable(this.javaClass)
        var name:String=st.maxUniqueIDName
        if(!StringUtils.isBlank(name)){
            return name
        }
        Preconditions.checkNotNull(null,"${javaClass.getName()} 类的 SnowTable 注释信息 未设置 maxUniqueIDName 信息")
        return ""
    }

    open fun toUpdateMap(): Map<String, Any> {
        return toUpdateMap(-1, BaseModel::class.java)
    }

    fun toUpdateMap(endsuperclass: Class<*>): Map<String, Any> {
        return toUpdateMap(-1, endsuperclass)
    }

    /**
     * 将对象本身按insert sql的格式组装出属性名 和 值

     * @param casei  字段大小写转换,为 0  表示转换为小写 , 为 1 则表示转换为大写,其它则表示不做转换
     * *
     * @param endsuperclass 查询到该父类结束(包含该父类属性)
     * *
     * @return
     * *
     * @Description:
     */
    fun toUpdateMap(casei: Int, endsuperclass: Class<*>): Map<String, Any> {
        val map = CaseInsensitiveMap<String, Any>()

        var fields: List<Field> = arrayListOf()

        fields = ClassUtils.getFieldsAndToSuperStop(this.javaClass, endsuperclass)

        var name: String
        var valueObj: Any?
        var type: String
        var value: Any?
        //用于存放已经使用过的字段名,如果子类拥有字段,则忽略父类声明的字段描述
        val tempattname = ArrayList<String>()
        // 遍历所有属性
        for (fi in fields) {

            name = fi.name
            if (tempattname.contains(name)) {
                continue
            } else {
                tempattname.add(name)
            }

            //主键字段 则不处理
            if (AnnotationUtils.isPrimary(fi)) {
                continue
            }

            //虚拟字段 则不处理
            if (!AnnotationUtils.isPersistent(fi)) {
                continue
            }
            //如果插入时忽略则不处理
            if (AnnotationUtils.isUpdateIgnore(fi)) {
                continue
            }
            //final 终态修饰的变量不处理
            if (Modifier.isFinal(fi.modifiers)) {
                continue
            }

            //static 静态修饰的变量不处理
            if (Modifier.isStatic(fi.modifiers)) {
                continue
            }

            // 设置些属性是可以访问的
            fi.isAccessible = true
            name = fi.name
            try {
                valueObj = fi.get(this)
            } catch (e: Exception) {
                valueObj = null
                log.error("name=" + name + "|" + e.toString())
                e.printStackTrace()
            }

            //字段大小写转换
            when (casei) {
                0 -> name = name.toLowerCase()
                1 -> name = name.toUpperCase()
                else -> {
                }
            }

            type = fi.type.toString().toLowerCase()
            val typeName = fi.type.name
            if (isCollectionField(fi)) {
                log.debug("忽略类型:$typeName 字段名:$name")
                continue
            }
            log.debug("类型:$typeName 字段名:$name")

            if (valueObj == null) {
                //log.debug("map:" + name + "|" + type + "|" + val);
                map.put(name, null)
                continue
            }

            if (StringExpand.binarySearch(
                    arrayOf("java.util.Boolean", "boolean"), typeName)) {
                value = if (valueObj as Boolean) 1 else 0
            } else if (type.indexOf("int") > 0 || type.indexOf("double") > 0
                    || type.indexOf("bigdecimal") > 0
                    || type.indexOf("long") > 0 || type.indexOf("float") > 0) {
                value = StringUtils.numberFormat(valueObj)
            } else if (type.indexOf("date") > 0) {
                value = java.sql.Timestamp((valueObj as Date).time)

            } else if (type.indexOf("boolean") > 0) {
                value = if (valueObj.toString() == "true") 1 else 0
            } else {
                value = valueObj
            }

            log.error("name=$name,value=$value")
            map.put(name, value)
        }
        toUpdateMapAfter(map)
        return map
    }


    /** 类似于 recordToAfter
     * [BaseModel.recordToAfter]
     * @param map
     */
    fun toUpdateMapAfter(map: MutableMap<String, Any>) {
        // TODO Auto-generated method stub
        toInsertMapAfter(map)

    }

    private fun snowFieldMapPut(clazz: Class<*>, fieldname: String, sfp: SnowFieldProp) {
        var sfpMap: HashMap<String, SnowFieldProp>? = snowfieldMap[clazz.name]
        if (sfpMap == null) {
            sfpMap = HashMap<String, SnowFieldProp>()
            snowfieldMap.put(clazz.name, sfpMap)
        }
        sfpMap.put(fieldname, sfp)
    }

    private fun snowFieldMapPut(fieldname: String, sfp: SnowFieldProp) {
        snowFieldMapPut(this.javaClass, fieldname, sfp)
    }

    fun loadSnowFieldProp(fieldname: String): Optional<SnowFieldProp> {
        //		HashMap<String,SnowFieldProp> sfpMap=snowfieldMap.get(this.getClass().getName());
        //		if(sfpMap==null){
        //			return Optional.fromNullable(null);
        //		}
        //		SnowFieldProp sfp=null;
        //		sfp=sfpMap.get(fieldname);
        return loadSnowFieldProp(this.javaClass, fieldname)
    }


    fun init() {
        val bmname = this.javaClass.simpleName
        if (SnowConfig.snow_jfinal_devMode) {
            println("init  start " + bmname + "--------------------------------------" + this.javaClass.name)
        }
        var fields: List<Field> = ArrayList()
        //		fields=ClassUtils.getFieldsAndSuper(this.getClass());
        fields = ClassUtils.getFieldsAndToSuperStop(this.javaClass, BaseModel::class.java)
        for (field in fields) {
            //如果同字段名,则父类的不作处理
            if (loadSnowFieldProp(field.name).isPresent) {
                continue
            }
            //如果为终态修饰符 final 的变量则忽略
            if (Modifier.isFinal(field.modifiers)) {
                continue
            }
            //static 静态修饰的变量不处理
            if (Modifier.isStatic(field.modifiers)) {
                continue
            }
            //
            if (isCollectionField(field)) {
                continue
            }


            val sfp = SnowFieldProp(bmname, field.name)
            val persistent = AnnotationUtils.isPersistent(field)
            val primary = AnnotationUtils.isPrimary(field)
            val required = AnnotationUtils.isRequired(field)
            val insertIgnore = AnnotationUtils.isInsertIgnore(field)
            val updateIgnore = AnnotationUtils.isUpdateIgnore(field)
            val format = AnnotationUtils.format(field)
            sfp.isPersistent = persistent
            sfp.isPrimary = primary
            sfp.isRequired = required
            sfp.isInsertignore = insertIgnore
            sfp.isUpdateignore = updateIgnore
            sfp.format = format
            sfp.setField(field)
            snowFieldMapPut(this.javaClass, field.name, sfp)
            if (SnowConfig.snow_jfinal_devMode) {
                println("init " + bmname + " ----------------- name = " + field.name + ":" + JSONObject.toJSONString(sfp, SerializerFeature.WriteMapNullValue))
            }
        }
        val st = this.javaClass.getAnnotation(SnowTable::class.java)
        if (st == null) {
            println("init error ----------------- " + this.javaClass.name + "继承了BaseModel，但是没有 SnowTable 注解绑定信息 ！！！")
        } else {
            val maxObjecxtName = st.maxObjecxtName
            if (!maxObjecxtName.isEmpty()) {
                val maxattMap = MaximoDB().getMaxattributecfg(maxObjecxtName)
                for (attnamekey in maxattMap.keys) {
                    val maxatt = maxattMap[attnamekey]
                    var attname = attnamekey.toLowerCase()
                    val osfp = loadSnowFieldProp(this.javaClass, attname)
                    var sfp: SnowFieldProp?
                    if (osfp.isPresent) {
                        sfp = osfp.get() as SnowFieldProp?
                    } else {
                        sfp = SnowFieldProp(bmname, attname)
                        snowFieldMapPut(attname, sfp)
                    }
                    if (maxatt?.getRequired()!!) {
                        sfp!!.isRequired = true
                    }
                    sfp!!.setMaxatt(maxatt)
                }
            }
        }

        val defvalMap = ifNullDefaultValueMap()
        for (key in defvalMap.keys) {
            val sfpOp = loadSnowFieldProp(key.toLowerCase())
            if (!sfpOp.isPresent) {
                throw NullPointerException(key + "字段对应的 SnowFieldProp 不存在" + this.javaClass.name)
            }
            sfpOp.get().snowdefval = defvalMap[key]
        }

        if (SnowConfig.snow_jfinal_devMode) {
            println("init end " + bmname + " --------------------------------------" + this.javaClass.name)
        }


    }

    /** 含有动态设置,使用 BaseModelUtils.formatSnowValue 解析
     * @return 为空时的默认值
     */
    open fun ifNullDefaultValueMap(): java.util.HashMap<String, Any> {
        val defvalmap = Maps.newHashMap<String, Any>()
        return defvalmap
    }

    /** insert 时设置为空的字段默认值,该默认值有 ifNullDefaultValueMap 提供<br></br>
     * 与maximo设置的无关
     * @param insertMap
     * *
     * @param user
     * *
     * @throws SnowException
     */
    @Throws(SnowException::class)
    fun insertDefaultValueToNull(insertMap: Map<String, Any>, user: User) {
        val defvalmap = ifNullDefaultValueMap()
        val baseModelUtils = BaseModelUtils(insertMap)
        for (attname in defvalmap.keys) {
            baseModelUtils.setDefval(attname, defvalmap[attname], user)
        }

    }

    /** 该变量是否为集合对象,例如 list map set 之类的,则返回 true<br></br>
     * 因为数据库字段不支持这些集合
     * @param fi
     * *
     * @return
     */
    fun isCollectionField(fi: Field): Boolean {
        val typeName = fi.type.name
        if (StringExpand.binarySearch(
                arrayOf("java.util.List", "java.util.Map", "java.util.ArrayList", "java.util.HashMap"), typeName)) {
            return true
        }
        return false
    }


    /**
     * 验证是否拥有保存权限,主要体现在工作流过程中
     * <br></br>未发流程的新建的单据只有创建人才能保存
     * <br></br>流程中的只有任务分配人员才有权限保存
     */
    fun hasSavePermissions(): Boolean {
        // TODO Auto-generated method stub
        try {
            val ownertable = showMaxWFTableName()
            val ownerid = showMaxUniqueIDValueToString()
            val personid = WebClient.getWebClient().user.personid
            //超级管理员都有权限保存
            if (personid.equals("maxadmin", ignoreCase = true))
                return true

            if (hasNewSavePermissions(personid)) {
                return true
            }

            val para = Maps.newHashMap<String, String>()
            para.put("ownerid", ownerid)
            para.put("ownertable", ownertable)
            para.put("personid", personid)
            val sql = SqlReadConfig.getSql("common.workflow_has_task_assignment", para)
            val record = Db.findFirst(sql)
            if (record != null) {
                return true
            }
        } catch (e: Exception) {
            // TODO: handle exception
            e.printStackTrace()
            throw SnowException(3003, e)
        }

        throw SnowException(3004).setParams(noSavePermissionsMessage())

    }

    open fun noSavePermissionsMessage(): String {
        val sb = StringBuffer()
        sb.append("").append(showMaxTableName()).append(".")
        sb.append(showMaxUniqueIDName())
        sb.append("=").append(showMaxUniqueIDValueToString())
        sb.append(";")
        return sb.toString()
    }


    /** 是否拥有新建保存权限
     * @param personid
     * *
     * @return
     */
    open fun hasNewSavePermissions(personid: String): Boolean {
        val status = status
        return "新建" == status || "退回修改" == status || "等待核准" == status
    }


    companion object {
        val sqllogger = SnowLogger.SQLLogger

        //默认设置
        //@SnowField(isPersistent = true, isPrimary = false,isInsertIgnore=false,isUpdateIgnore=false,isRequired=false)

        val log = Logger.getLogger(BaseModel::class.java)

        /**
         * 属性配置存放
         * Map<model对象的class></model对象的class>, HashMap<小写字段名></小写字段名>, SnowFieldProp>>
         */
        private val snowfieldMap = HashMap<String, HashMap<String, SnowFieldProp>>()


        /**

         */
        private val serialVersionUID = 1L
        val snow_rnDF = DecimalFormat("0000000000")

        fun getBoolean(i: Int?): Boolean {
            // TODO Auto-generated method stub
            if (i == null) return false
            return if (i > 1) true else false
        }

        fun getBoolean(bd: BigDecimal?): Boolean {
            // TODO Auto-generated method stub
            if (bd == null) return false
            return if (bd.toInt() > 1) true else false
        }


        fun getDouble(bigDecimal: BigDecimal?): Double? {
            // TODO Auto-generated method stub
            if (bigDecimal == null) {
                return null
            } else {
                return bigDecimal.toDouble()
            }
        }

        /**
         * 一个通用的数据对象与Model对象转换类

         * @param rec
         * *
         * @param model
         * *
         * @return
         * *
         * @throws IllegalAccessException
         * *
         * @throws InstantiationException
         * *
         * @Description: 有异常不再抛出
         */
        fun <T:Any> recordTo(rec: Record, clazz: Class<T>): T? {
            log.info("recordTo...")
            var model: T
            try {
                model = clazz.newInstance()
            } catch (e1: InstantiationException) {
                // TODO Auto-generated catch block
                e1.printStackTrace()
                return null
            } catch (e1: IllegalAccessException) {
                e1.printStackTrace()
                return null
            }

            log.info("model=" + model!!)
            val field = model::class.java.getFields()
            val field2 = model::class.java.getDeclaredFields()
            var fields: MutableList<Field> = ArrayList()
            fields.addAll(Arrays.asList(*field))
            fields.addAll(Arrays.asList(*field2))

            fields = ClassUtils.getFieldsAndToSuperStop(clazz, BaseModel::class.java)
            // //获取该类中可以调用的方法
            // ArrayList<String> al=new ArrayList<String>();
            // Method[] methods = model.getClass().getMethods();
            // for (Method method2 : methods) {
            // al.add(method2.getName());
            // }
            var name: String
            var attr: String
            var method: Method? = null
            var type: String
            // 遍历所有属性
            val sb = StringBuffer()
            val map2 = HashMap<String, String>()
            for (fi in fields) {
                // 获取属性的名字
                name = fi.name

                if (map2[name] != null || name == "snowfieldMap") {
                    continue
                }
                map2.put(name, name)
                // 将属性的首字符大写，方便构造get，set方法
                attr = name.substring(0, 1).toUpperCase() + name.substring(1)

                // 获取属性的类型
                type = fi.genericType.toString()
                log.info("type=$type,name=$name")

                // //如果不存在该方法,则进行下次循环
                // //当然也可以通过 fi.getModifiers() 获取修饰符来判断是否为 FINAL 类型的进行过滤循环
                // if(al.indexOf("set"+attr)==-1){
                // continue;
                // }
                sb.append(name).append(":").append(type).append(" | ")
                // 判断修饰符,如果存在 final类型的则表示无对应的set方法,跳过此次循环
                if (Modifier.isFinal(fi.modifiers)) {
                    continue
                }

                // 按照变量类型获取相应set方法,为空时如果变量为boolean类型,会报错
                try {
                    method = model.javaClass.getMethod("set" + attr,
                            fi.type)
                } catch (e: SecurityException) {
                    log.error(" SecurityException : " + e.toString())
                    e.printStackTrace()
                } catch (e: NoSuchMethodException) {
                    log.error(" NoSuchMethodException : " + e.toString())
                    e.printStackTrace()
                }

                var `object`: Any? = null
                name = name.toUpperCase()
                try {
                    `object` = rec.get<Any>(name)
                } catch (e: Exception) {
                    log.error(" ERROR : " + name + "|" + e.message)
                    e.printStackTrace()
                }

                if (`object` == null) {
                    //log.warn("属性值为NULL？" + name);
                    continue
                }

                log.info("type=" + type + ";name=" + name + ";value=" + rec.get<Any>(name))
                val value = rec.get<Any>(name)
                log.info("valObj.class=" + value.javaClass.name)
                log.debug("valObj.class=" + value.javaClass.name)

                // 如果type是类类型，则前面包含"class "，后面跟类名
                try {
                    if (type == "class java.lang.String") {
                        method!!.invoke(model, rec.get<Any>(name).toString())
                    } else if (type == "class java.lang.Integer") {
                        method!!.invoke(model, Integer.parseInt(value.toString()))
                    } else if (type == "class java.lang.Short") {
                        method!!.invoke(model, rec.getInt(name))
                    } else if (type == "class java.lang.Double") {
                        method!!.invoke(model, TypeConversionUtils.doubleByObject(value))
                    } else if (type == "class java.math.BigDecimal") {
                        method!!.invoke(model, rec.getBigDecimal(name))
                    } else if (type == "class java.lang.Long") {
                        method!!.invoke(model, TypeConversionUtils.longByObject(value))
                    } else if (type == "class java.lang.Boolean") {
                        method!!.invoke(model, TypeConversionUtils.booleanByObject(value))
                    } else if (type == "class java.util.Date") {
                        method!!.invoke(model, rec.getDate(name))
                    } else if (type == "boolean") {
                        method!!.invoke(model, TypeConversionUtils.booleanByObject(value))
                    } else {
                        log.error("StringUtils.recordToObject 暂不支持转换的类型 : " + model.javaClass.getName() + "|" + name + "=" + rec.get<Any>(name).javaClass.name + "| type=" + type)
                    }
                } catch (e: Exception) {
                    log.error(" 错误转换 : type=" + type + ";name=" + name + ";value=" + rec.get<Any>(name) + "|" + e.toString())
                    e.printStackTrace()
                }

                //log.debug("recordToObject 设置值结束");
            }
            //		log.info("所有属性：" + sb.toString());
            if (model is BaseModel) {
                (model as BaseModel).recordToAfter(rec)
            }

            return model
        }


        fun loadSnowfieldMap(): Map<String, HashMap<String, SnowFieldProp>> {
            return snowfieldMap
        }

        /** 获取对象所有的字段的属性信息
         * 用 load 而 不用 get 是因为 Json 转换会根据 get set 前缀进行处理
         * @param clazz
         * *
         * @return
         */
        fun loadSnowFieldPropMap(clazz: Class<*>): Map<String, SnowFieldProp>? {
            return snowfieldMap[clazz.name]
        }


        /** 获取对象某个字段属性信息
         * 用 load 而 不用 get 是因为 Json 转换会根据 get set 前缀进行处理
         * @param clazz
         * *
         * @return
         */
        fun loadSnowFieldProp(clazz: Class<*>, fieldname: String): Optional<SnowFieldProp> {
            val sfpMap = loadSnowFieldPropMap(clazz) ?: return Optional.fromNullable(null)
            val sfp: SnowFieldProp?= sfpMap[fieldname]
            return Optional.fromNullable(sfp)
        }
    }

   open fun save():Long{
       return save( BaseModel::class.java)
   }

   open fun save( endclazz: Class<*> =BaseModel::class.java):Long {
        var objid=showMaxUniqueIDValue()
        val obj = this
        val sfpMap = BaseModel.loadSnowFieldPropMap(this.javaClass)
       log.debug("${javaClass}.save")
        if (obj.ms_tobedelete) {
            log.debug("${javaClass}.save.delete")
            delete()
        } else if (obj.ms_toadd) {
            log.debug("${javaClass}.save.add")
            objid=add()

        } else if (obj.ms_tobemodify) {
            log.debug("${javaClass}.save.update")
            update()
        }


        var fields: List<Field> = ClassUtils.getFieldsAndToSuperStop(this.javaClass, endclazz)


        //用于存放已经使用过的字段名,如果子类拥有字段,则忽略父类声明的字段描述
        val tempattname = ArrayList<String>()
        // 遍历所有属性
        for (fi in fields) {
            var name = fi.name
            //虚拟字段 则不处理
            if (!AnnotationUtils.isPersistent(fi)) {
                continue
            }
            //final 终态修饰的变量不处理
            if (Modifier.isFinal(fi.modifiers)) {
                continue
            }

            //static 静态修饰的变量不处理
            if (Modifier.isStatic(fi.modifiers)) {
                continue
            }
            val typeName = fi.type.name
            if (StringExpand.binarySearch(
                    arrayOf("java.util.ArrayList", "java.util.List"), typeName)) {

                fi.isAccessible = true
                name = fi.name
                var valueObj:Any?
                try {
                    valueObj = fi.get(this)
                } catch (e: Exception) {
                    valueObj = ""
                    log.error("name=" + name + "|" + e.toString())
                    e.printStackTrace()
                }
                if (valueObj == null) {
                    //log.debug("map:" + name + "|" + type + "|" + val);
                    continue
                }
                if(valueObj is BaseModel){
                    valueObj.parentbasemodel=this
                    log.debug("${showMaxTableName()}.$name.save")
                    valueObj.save()
                }
            }
        }
        return objid!!

    }


    open fun add( ):Long {
        val obj = this
        val sfpMap = BaseModel.loadSnowFieldPropMap(this.javaClass)
        val objid:Long
        if(showMaxUniqueIDValue()!=null){
            objid = DBUtils.nextSequenceValue(this.javaClass)
            obj.putMaxUniqueIDValue(objid)
        }else{
            objid=showMaxUniqueIDValue()!!
        }

        val insertMap = obj.toInsertMap(1)
        //设置默认值
        obj.insertDefaultValueToNull(insertMap, basemodelUser as User)

        log.debug("insertMap=" + JSONObject.toJSONString(insertMap, SerializerFeature.WriteMapNullValue))
        val maxdefMap = maxDB!!.getInsertDefaultValue(AnnotationUtils.getMaxObjectName(this.javaClass), basemodelUser)
        log.debug("maxdefMap=" + JSONObject.toJSONString(maxdefMap, SerializerFeature.WriteMapNullValue))
        val map = DBUtils.mergeInsertMap(insertMap, maxdefMap, sfpMap)
        log.debug(this.javaClass.toString() + "save.map=" + JSONObject.toJSONString(map, SerializerFeature.WriteMapNullValue))
        DBUtils.saveInsertByMap(snowDb, AnnotationUtils.getMaxEntityName(this.javaClass), map)
        return objid
    }

    open fun update( ) {
        val obj = this
        val sfpMap = BaseModel.loadSnowFieldPropMap(this.javaClass)
        obj.modifyVerification()
        val updateMap = obj.toUpdateMap()
        log.debug("updateMap=" + JSONObject.toJSONString(updateMap, SerializerFeature.WriteMapNullValue))
        DBUtils.saveUpdateByMap(snowDb, AnnotationUtils.getMaxEntityName(this.javaClass), updateMap, showMaxUniqueIDName() + "  = " + obj.showMaxUniqueIDValueToString())
    }

    open fun delete(){
        val obj = this
        val sql = obj.toDeleteString()
        snowDb!!.update(sql)
    }



    open fun showBaseModelByUniqueID(paras:Any=this):BaseModel?{
        val sql:String
        if(paras is BaseModel){
            sql="select * from ${paras.showMaxEntityName()} where ${paras.showMaxUniqueIDName()}=${paras.showMaxUniqueIDValueToString()}"
        }else{
            sql="select * from ${showMaxEntityName()} where ${showMaxUniqueIDName()}=${showMaxUniqueIDValueToString()}"
        }
        sqllogger.debug("sql=$sql")
        val record:Record = Db.findFirst(sql)
        return BaseModel.Companion.recordTo(record, javaClass)

    }

    /**
     * 复制数据库操作使用的对象
     */
    open fun copyDBObjects(source:BaseModel){
        this.snowDb=source.snowDb
        this.basemodelUser=source.basemodelUser
        this.maxDB=source.maxDB
        this.ms_toadd=source.ms_toadd
        this.ms_tobedelete=source.ms_tobedelete
        this.ms_tobemodify=source.ms_tobemodify
        if(this.parentbasemodel==null&&source.parentbasemodel!=null){
            this.parentbasemodel=source.parentbasemodel
        }
    }

    open fun copyDB(source:BaseModel){
        this.snowDb=source.snowDb
        this.basemodelUser=source.basemodelUser
        this.maxDB=source.maxDB
        this.parentbasemodel=source.parentbasemodel
    }

}

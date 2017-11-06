package com.app.jfinal.service.workorder.db

import com.alibaba.fastjson.JSONObject
import com.alibaba.fastjson.serializer.SerializerFeature
import com.google.common.collect.Lists
import com.google.common.collect.Maps
import com.jfinal.plugin.activerecord.Db
import org.shoukaiseki.jfinal.kernel.maximo.db.CommonDB
import org.shoukaiseki.jfinal.kernel.maximo.model.Multiassetlocci
import org.shoukaiseki.jfinal.kernel.maximo.utils.MaximoDB
import org.shoukaiseki.jfinal.kernel.login.model.User
import com.app.jfinal.service.workorder.model.*
import org.apache.log4j.Logger
import org.shoukaiseki.jfinal.kernel.SnowDB
import org.shoukaiseki.jfinal.kernel.common.AnnotationUtils
import org.shoukaiseki.jfinal.kernel.common.BaseModel
import org.shoukaiseki.jfinal.kernel.exception.SnowException
import org.shoukaiseki.jfinal.kernel.logger.SnowLogger
import org.shoukaiseki.jfinal.kernel.plugin.SqlReadConfig
import org.shoukaiseki.jfinal.kernel.utils.DBUtils
import org.shoukaiseki.jfinal.kernel.utils.StringUtils
import java.util.*

class WorkorderDB {

    internal var sfpMap = BaseModel.loadSnowFieldPropMap(Workorder::class.java)
    var snowDb: SnowDB? = null
    var user: User? = null

    protected var df = StringUtils.numberFormat
    protected var comDB = CommonDB()

    protected var maxDB = MaximoDB()

    internal var woDB = WODB()

    fun findwotrackbywoid(paras: Any): Workorder? {
        // TODO Auto-generated method stub
        val sql = SqlReadConfig.getSql("workorder.findwotrackbywoid", paras)
        val record = Db.findFirst(sql)
        var obj: Workorder? = null
        if (record != null) {
            obj = BaseModel.recordTo(record, Workorder::class.java)

            val paramap = Maps.newHashMap<String, Any>()
            paramap.put("recordkey", obj!!.wonum)
            paramap.put("class", obj.woclass)
            paramap.put("siteid", obj.siteid)
            paramap.put("wonum", obj.wonum)
            obj.wosafetylinks = findWosafetylinks(paramap)
            obj.showchildrens = findShowchildrens(paramap)
            obj.showtasks = findShowtasks(paramap)
            obj.showplanlabors = findShowplanlabors(paramap)
            obj.showplanmaterial = findShowplanmaterial(paramap)
            obj.showactuallabors = findShowactuallabors(paramap)
            obj.showactualmaterials = findShowactualmaterials(paramap)


            val map = HashMap<String, Any>()
            map.put("ownertable", "WORKORDER")
            map.put("ownerid", df.format(obj.workorderid))
            val dfs = comDB.findDocFile(map)
            obj.dfs = dfs
        }
        return obj
    }

    fun findShowactualmaterials(paramap: HashMap<String, Any>): List<Matusetrans> {
        val lists = Lists.newArrayList<Matusetrans>()
        val sql = SqlReadConfig.getSql("workorder.list_showactualmaterial", paramap)
        val list = Db.find(sql)
        var obj: Matusetrans? = null
        for (record in list) {
            obj = BaseModel.recordTo(record, Matusetrans::class.java)
            lists.add(obj)
        }
        return lists
    }

    fun findShowactuallabors(paramap: HashMap<String, Any>): List<Labtrans> {
        val lists = Lists.newArrayList<Labtrans>()
        val sql = SqlReadConfig.getSql("workorder.list_showactuallabor", paramap)
        val list = Db.find(sql)
        var obj: Labtrans? = null
        for (record in list) {
            obj = BaseModel.recordTo(record, Labtrans::class.java)
            lists.add(obj)
        }
        return lists
    }

    fun findShowplanmaterial(paras: HashMap<String, Any>): List<Wpitem> {
        val lists = Lists.newArrayList<Wpitem>()
        val sql = SqlReadConfig.getSql("workorder.list_showplanmaterial", paras)
        val list = Db.find(sql)
        var obj: Wpitem? = null
        for (record in list) {
            obj = BaseModel.recordTo(record, Wpitem::class.java)
            lists.add(obj)
        }
        return lists
    }

    fun findShowplanlabors(paras: Any): List<Wplabor> {
        val lists = Lists.newArrayList<Wplabor>()
        val sql = SqlReadConfig.getSql("workorder.list_showplanlabor", paras)
        val list = Db.find(sql)
        var obj: Wplabor? = null
        for (record in list) {
            obj = BaseModel.recordTo(record, Wplabor::class.java)
            lists.add(obj)
        }
        return lists
    }

    fun findShowtasks(paras: Any): ArrayList<Workorder> {
        val lists = Lists.newArrayList<Workorder>()
        val sql = SqlReadConfig.getSql("workorder.list_showtasks", paras)
        val list = Db.find(sql)
        var obj: Workorder? = null
        for (record in list) {
            obj = BaseModel.recordTo(record, Workorder::class.java)
            lists.add(obj)
        }
        return lists
    }

    fun findShowchildrens(paras: Any): ArrayList<Workorder> {
        val lists = Lists.newArrayList<Workorder>()
        val sql = SqlReadConfig.getSql("workorder.list_showchildren", paras)
        val list = Db.find(sql)
        var obj: Workorder? = null
        for (record in list) {
            obj = BaseModel.recordTo(record, Workorder::class.java)
            lists.add(obj)
        }
        return lists
    }

    fun findWosafetylinks(paras: Any): ArrayList<WosafetylinkView> {
        val lists = Lists.newArrayList<WosafetylinkView>()
        val sql = SqlReadConfig.getSql("workorder.list_woslhazprecenabled", paras)
        val list = Db.find(sql)
        var obj: WosafetylinkView? = null
        for (record in list) {
            obj = BaseModel.recordTo<WosafetylinkView>(record, WosafetylinkView::class.java)
            obj!!.wohazardprecViews = findWohazardprecs(obj)
            lists.add(obj)
        }
        return lists
    }

    fun findWohazardprecs(paras: Any?): ArrayList<WohazardprecView> {
        val lists = Lists.newArrayList<WohazardprecView>()
        val sql = SqlReadConfig.getSql("workorder.list_wohazardprec_by_wosafetylink", paras)
        val list = Db.find(sql)
        var obj: WohazardprecView? = null
        for (record in list) {
            obj = BaseModel.recordTo<WohazardprecView>(record, WohazardprecView::class.java)

            lists.add(obj)
        }
        return lists
    }


    /**
     * @param updateMap
     * @param maxdefMap
     * @param obj
     * 用于更新 FAILUREREPORT 表
     *
     * @return
     *
     * @throws SnowException
     */
    @Throws(SnowException::class)
    fun addWorkorder(updateMap: Map<String, Any>, maxdefMap: Map<String, Any>, obj: Workorder): Workorder? {
        val map = DBUtils.mergeInsertMap(updateMap, maxdefMap, sfpMap)
        logger.debug("addWorkorder.map=" + JSONObject.toJSONString(map))

        DBUtils.saveInsertByMap(snowDb, AnnotationUtils.getMaxEntityName(Workorder::class.java), map)

        obj.failurereport_gzwt = if (map["FAILUREREPORT_GZWT"] != null) map["FAILUREREPORT_GZWT"].toString() else ""
        obj.failurereport_gzyy = if (map["FAILUREREPORT_GZYY"] != null) map["FAILUREREPORT_GZYY"].toString() else ""
        obj.failurereport_bjcs = if (map["FAILUREREPORT_BJCS"] != null) map["FAILUREREPORT_BJCS"].toString() else ""
        obj.siteid = map["SITEID"].toString()
        obj.orgid = map["ORGID"].toString()
        obj.wonum = map["WONUM"].toString()
        updateFailurereport(obj)

        var wo: Workorder? = null
        val uniqueid = map["WORKORDERID"]

        val sql = "select * from workorder where WORKORDERID=" + uniqueid
        logger.debug("\naddWorkorder.findwo.sql=" + sql)
        val record = snowDb!!.findFirst(sql)
        if (record != null) {
            wo = BaseModel.recordTo<Workorder>(record, Workorder::class.java)
        }

        return wo
    }

    /**
     * @param insertMap
     * @param workorderid
     * @param obj
     * 用于更新 FAILUREREPORT 表
     *
     * @throws SnowException
     */
    @Throws(SnowException::class)
    fun updateWorkorder(insertMap: Map<String, Any>, workorderid: Long?, obj: Workorder) {
        // TODO Auto-generated method stub
        DBUtils.saveUpdateByMap(snowDb, AnnotationUtils.getMaxEntityName(Workorder::class.java), insertMap, " workorderid = " + StringUtils.numberFormat(workorderid))
        updateFailurereport(obj)

    }


    /**
     * 更新 workorder 的子表,根据状态进行 add delete modify 操作
     *
     * @param obj
     *
     * @throws SnowException
     */
    @Throws(SnowException::class)
    fun updateChildren(obj: Workorder) {
        // TODO Auto-generated method stub
        logger.debug("updateChildren")
        logger.debug("obj=${JSONObject.toJSONString(obj)}")
        for (wxs in obj.wosafetylinks){
            logger.debug("wxs=${JSONObject.toJSONString(wxs)}")
            logger.debug("${wxs.javaClass}")
            wxs.basemodelUser=user
            wxs.maxDB=maxDB
            wxs.snowDb=snowDb
            wxs.parentbasemodel=obj
            wxs.save()
        }
    }


    @Throws(SnowException::class)
    fun addMultiassetlocci(obj: Multiassetlocci) {
        if (obj.ms_tobedelete) {
            val sql = obj.toDeleteString()
            logger.debug("\nsql=" + sql)
            snowDb!!.update(sql)
        } else if (obj.ms_toadd) {
            val objid = DBUtils.nextSequenceValue(Multiassetlocci::class.java)
            obj.multiid = objid

            val insertMap = obj.toInsertMap(1)
            //设置默认值
            obj.insertDefaultValueToNull(insertMap, user!!)

            logger.debug("insertMap=" + JSONObject.toJSONString(insertMap, SerializerFeature.WriteMapNullValue))
            val maxdefMap = maxDB.getInsertDefaultValue(AnnotationUtils.getMaxObjectName(Multiassetlocci::class.java), user)
            logger.debug("maxdefMap=" + JSONObject.toJSONString(maxdefMap, SerializerFeature.WriteMapNullValue))
            val map = DBUtils.mergeInsertMap(insertMap, maxdefMap, sfpMap)
            logger.debug("addMultiassetlocci.map=" + JSONObject.toJSONString(map, SerializerFeature.WriteMapNullValue))
            DBUtils.saveInsertByMap(snowDb, AnnotationUtils.getMaxEntityName(Multiassetlocci::class.java), map)

        } else if (obj.ms_tobemodify) {
            obj.modifyVerification()
            val updateMap = obj.toUpdateMap()
            logger.debug("updateMap=" + JSONObject.toJSONString(updateMap, SerializerFeature.WriteMapNullValue))
            DBUtils.saveUpdateByMap(snowDb, AnnotationUtils.getMaxEntityName(Multiassetlocci::class.java), updateMap, " multiid = " + obj.showMaxUniqueIDValueToString())
        }

    }

    fun updateFailurereport(obj: Workorder) {
        // TODO Auto-generated method stub
        val sql: String

        val gzwt = obj.failurereport_gzwt
        val gzyy = obj.failurereport_gzyy
        val bjcs = obj.failurereport_bjcs
        val siteid = obj.siteid
        val orgid = obj.orgid
        val wonum = obj.wonum
        if (wonum == null || siteid == null || orgid == null) {
            return
        }

        sql = "delete from failurereport where siteid='$siteid' and wonum='$wonum'"
        logger.debug("gzwt=$gzwt,gzyy=$gzyy,bjcs=$bjcs")
        snowDb!!.update(sql)
        if (gzwt != null && !StringUtils.isBlank(gzwt)) {
            val gzwtFR = Failurereport()
            gzwtFR.type = "问题"
            gzwtFR.siteid=(siteid)
            gzwtFR.orgid=(orgid)
            gzwtFR.assetnum = obj.assetnum
            gzwtFR.failurecode = gzwt
            gzwtFR.wonum = wonum
            var failurecodeid = DBUtils.getFailurelist(gzwt, orgid)
            gzwtFR.linenum = failurecodeid
            gzwtFR.failurereportid = DBUtils.nextSequenceValue(Failurereport::class.java)
            DBUtils.saveInsertByMap(snowDb, AnnotationUtils.getMaxEntityName(Failurereport::class.java), gzwtFR.toInsertMap())

            if (gzyy != null && !StringUtils.isBlank(gzyy)) {
                val gzyyFR = Failurereport()
                gzyyFR.type = "原因"
                gzyyFR.siteid=(siteid)
                gzyyFR.orgid=(orgid)
                gzyyFR.assetnum = obj.assetnum
                gzyyFR.failurecode = gzyy
                gzyyFR.wonum = wonum
                failurecodeid = DBUtils.getFailurelist(gzyy, orgid)
                gzyyFR.linenum = failurecodeid
                gzyyFR.failurereportid = DBUtils.nextSequenceValue(Failurereport::class.java)
                DBUtils.saveInsertByMap(snowDb, AnnotationUtils.getMaxEntityName(Failurereport::class.java), gzyyFR.toInsertMap())
                if (bjcs != null && !StringUtils.isBlank(bjcs)) {
                    val bjcsFR = Failurereport()
                    bjcsFR.type = "补救措施"
                    bjcsFR.siteid=siteid
                    bjcsFR.orgid=orgid
                    bjcsFR.assetnum = obj.assetnum
                    bjcsFR.failurecode = bjcs
                    bjcsFR.wonum = wonum
                    failurecodeid = DBUtils.getFailurelist(bjcs, orgid)
                    bjcsFR.linenum = failurecodeid
                    bjcsFR.failurereportid = DBUtils.nextSequenceValue(Failurereport::class.java)
                    DBUtils.saveInsertByMap(snowDb, AnnotationUtils.getMaxEntityName(Failurereport::class.java), bjcsFR.toInsertMap())

                }

            }
        }


    }

    companion object {

        val logger = Logger.getLogger(WorkorderDB::class.java)

        val sqllogger = SnowLogger.SQLLogger
    }

}

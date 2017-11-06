package com.app.jfinal.service.workorder

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.google.common.collect.Lists
import com.google.common.collect.Maps
import com.jfinal.plugin.activerecord.Db
import org.shoukaiseki.jfinal.kernel.login.model.User
import com.app.jfinal.service.workorder.db.WODB
import com.app.jfinal.service.workorder.db.WorkorderDB
import com.app.jfinal.service.workorder.model.Workorder
import org.shoukaiseki.jfinal.kernel.AbstractController
import org.shoukaiseki.jfinal.kernel.SnowDB
import org.shoukaiseki.jfinal.kernel.common.AnnotationUtils
import org.shoukaiseki.jfinal.kernel.common.BaseModel
import org.shoukaiseki.jfinal.kernel.utils.DBUtils

/** com.app.jfinal.service.workorder.WorkorderController
 * @author 蒋カイセキ    Japan-Tokyo  2017年4月5日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
class WorkorderController : AbstractController() {
    internal var sfpMap = BaseModel.loadSnowFieldPropMap(Workorder::class.java)

    internal var woDB = WODB()
    internal var workDB = WorkorderDB()


    fun findallwotrackbythissiteid() {
        try {
            initJsonModel()
            var sql = org.shoukaiseki.jfinal.kernel.plugin.SqlReadConfig.getSql("workorder.findallwotrackbythissiteid", jm.parameters)
            sql = org.shoukaiseki.jfinal.kernel.sql.oracle.SqlPagingFormat.pagingFormat(ms_rows, ms_page, sql, jsonModel)

            val list = Db.find(sql)
            var obj: Workorder? = null
            for (record in list) {
                jsonModel.setColumnNames(record.columnNames)
                obj = BaseModel.recordTo(record, Workorder::class.java)
                jsonModel.addDatas(obj!!)
            }
            jsonModel.status = org.shoukaiseki.jfinal.kernel.http.JsonModel.SUCCESS
            render(jsonModel)
        } catch (e: org.shoukaiseki.jfinal.kernel.exception.SnowException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
            renderException(e)

        } catch (ex: Exception) {
            ex.printStackTrace()
            renderException(org.shoukaiseki.jfinal.kernel.exception.SnowException(10000, ex))
        }

    }

    fun listweiwanchengwotrack() {
        try {
            initJsonModel()

            var sql = org.shoukaiseki.jfinal.kernel.plugin.SqlReadConfig.getSql("workorder.listweiwanchengwotrack", jm.parameters)
            sql = org.shoukaiseki.jfinal.kernel.sql.oracle.SqlPagingFormat.pagingFormat(ms_rows, ms_page, sql, jsonModel)

            val list = Db.find(sql)
            var obj: Workorder? = null
            for (record in list) {
                jsonModel.setColumnNames(record.columnNames)
                obj = BaseModel.recordTo(record, Workorder::class.java)
                jsonModel.addDatas(obj!!)
            }
            jsonModel.status = org.shoukaiseki.jfinal.kernel.http.JsonModel.SUCCESS
            render(jsonModel)
        } catch (e: org.shoukaiseki.jfinal.kernel.exception.SnowException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
            renderException(e)

        } catch (ex: Exception) {
            ex.printStackTrace()
            renderException(org.shoukaiseki.jfinal.kernel.exception.SnowException(10000, ex))
        }

    }


    fun findallwotrack() {
        try {

            initJsonModel()

            var sql = org.shoukaiseki.jfinal.kernel.plugin.SqlReadConfig.getSql("workorder.findallwotrack", jm.parameters)
            sql = org.shoukaiseki.jfinal.kernel.sql.oracle.SqlPagingFormat.pagingFormat(ms_rows, ms_page, sql, jsonModel)

            val list = Db.find(sql)
            var obj: Workorder? = null
            for (record in list) {
                jsonModel.setColumnNames(record.columnNames)
                obj = BaseModel.recordTo(record, Workorder::class.java)
                jsonModel.addDatas(obj!!)
            }
            jsonModel.status = org.shoukaiseki.jfinal.kernel.http.JsonModel.SUCCESS
            render(jsonModel)

        } catch (e: org.shoukaiseki.jfinal.kernel.exception.SnowException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
            renderException(e)
        } catch (ex: Exception) {
            ex.printStackTrace()
            renderException(org.shoukaiseki.jfinal.kernel.exception.SnowException(10000, ex))
        }

    }

    fun findwotrack() {
        try {

            initJsonModel()

            var sql = org.shoukaiseki.jfinal.kernel.plugin.SqlReadConfig.getSql("workorder.findwotrack", jm.parameters)
            sql = org.shoukaiseki.jfinal.kernel.sql.oracle.SqlPagingFormat.pagingFormat(ms_rows, ms_page, sql, jsonModel)

            val list = Db.find(sql)
            var obj: Workorder? = null
            for (record in list) {
                jsonModel.setColumnNames(record.columnNames)
                obj = BaseModel.recordTo(record, Workorder::class.java)
                jsonModel.addDatas(obj!!)
            }
            jsonModel.status = org.shoukaiseki.jfinal.kernel.http.JsonModel.SUCCESS
            render(jsonModel)

        } catch (e: org.shoukaiseki.jfinal.kernel.exception.SnowException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
            renderException(e)
        } catch (ex: Exception) {
            ex.printStackTrace()
            renderException(org.shoukaiseki.jfinal.kernel.exception.SnowException(10000, ex))
        }

    }


    fun findwotrackbywoid() {
        try {
            initJsonModel()
            var obj:BaseModel? = workDB.findwotrackbywoid(jm.parameters)
            if (obj != null) {
                jsonModel.addDatas(obj)
            } else {
                renderException(org.shoukaiseki.jfinal.kernel.exception.SnowException(10000, "WorkorderController.findwotrackbywoid 错误"))
            }
            jsonModel.status = org.shoukaiseki.jfinal.kernel.http.JsonModel.SUCCESS
            render(jsonModel)
        } catch (e: org.shoukaiseki.jfinal.kernel.exception.SnowException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
            renderException(e)

        } catch (ex: Exception) {
            ex.printStackTrace()
            renderException(org.shoukaiseki.jfinal.kernel.exception.SnowException(10000, ex))
        }

    }



    fun updateworkorder() {
        var snowDb: SnowDB? = null
        try {
            initJsonModel()
            //		logger.debug("jm="+JSONObject.toJSONString(jm));


            val user = User()
            user.personid = getCanshu("personid")
            user.defsite = getCanshu("siteid")
            var maxdefMap: Map<String, Any>? = null
            var obj: Workorder? = null
            var datas: List<Any>? = jm.data

            AbstractController.logger.debug("paras=" + JSONObject.toJSONString(jm.parameters))
            AbstractController.logger.debug("datas=" + JSONObject.toJSONString(datas))
            snowDb = SnowDB()
            workDB.snowDb = snowDb
            maxDB.setSnowDb(snowDb)
            workDB.user = user
            if (datas != null) {
                for (data in datas) {
                    AbstractController.logger.debug("data=" + data.toString())
                    obj = JSON.parseObject(data.toString(), Workorder::class.java)

                    if (obj!!.ms_toadd) {
                        AbstractController.logger.debug("obj=" + JSONObject.toJSONString(obj))
                        val objid = DBUtils.nextSequenceValue(Workorder::class.java)
                        obj.workorderid = objid

                        val insertMap = obj.toInsertMap(1)
                        //设置默认值
                        obj.insertDefaultValueToNull(insertMap, user)

                        AbstractController.logger.debug("insertMap=" + JSONObject.toJSONString(insertMap))


                        maxdefMap = maxDB.getInsertDefaultValue(AnnotationUtils.getMaxObjectName(Workorder::class.java), user)
                        AbstractController.logger.debug("maxdefMap=" + JSONObject.toJSONString(maxdefMap))
                        val wo = workDB.addWorkorder(insertMap, maxdefMap, obj)
                        wo!!.ms_id = obj.ms_id
                        wo.copyChildrenToMe<Any>(obj)
                        obj = wo
                        workDB.updateChildren(obj)
                        maxDB.uploadDocFile(obj.dfs, obj)
                        jsonModel.addDatas(obj)
                    } else if (obj.ms_tobemodify) {
                        obj.modifyVerification()
                        obj.hasSavePermissions()
                        val updateMap = obj.toUpdateMap()
                        AbstractController.logger.debug("updateMap=" + JSONObject.toJSONString(updateMap))

                        workDB.updateWorkorder(updateMap, obj.workorderid, obj)
                        workDB.updateChildren(obj)
                        maxDB.uploadDocFile(obj.dfs, obj)
                        jsonModel.addDatas(obj)
                    } else {
                        jsonModel.status = org.shoukaiseki.jfinal.kernel.http.JsonModel.ERROR
                        jsonModel.errorinfo = "工单没有更新标志位,workorderid:" + obj.workorderid + ",description:" + obj.description
                        SnowDB.rollbackClose(snowDb)
                        render(jsonModel)
                        return
                    }


                }
            }

            //			jsonModel.setJson(JSONObject.toJSONString(maxdefMap));
            SnowDB.autoClose(snowDb)
            datas = jsonModel.data
            jsonModel.data = Lists.newArrayList()
            for (data in datas!!) {
                val wo = data as Workorder
                val woid = wo.workorderid
                AbstractController.logger.debug("woid=" + woid!!)
                val objMap = Maps.newHashMap<Any, Any>()
                objMap.put("workorderid", woid.toString())
                val workorder = workDB.findwotrackbywoid(objMap)
                workorder!!.ms_id = wo.ms_id
                jsonModel.addDatas(workorder)
            }

            jsonModel.errorinfo = "保存成功"
            render(jsonModel)
        } catch (e: org.shoukaiseki.jfinal.kernel.exception.SnowException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
            SnowDB.rollbackClose(snowDb)
            renderException(e)

        } catch (ex: Exception) {
            ex.printStackTrace()
            SnowDB.rollbackClose(snowDb)
            renderException(org.shoukaiseki.jfinal.kernel.exception.SnowException(10000, ex))
        }


    }

    companion object {

        @JvmField var TAG:String="workorder"
    }


}

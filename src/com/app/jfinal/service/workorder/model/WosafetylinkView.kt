package com.app.jfinal.service.workorder.model

import com.google.common.collect.Lists
import org.shoukaiseki.jfinal.kernel.common.BaseModel
import org.shoukaiseki.jfinal.kernel.common.SnowField
import org.shoukaiseki.jfinal.kernel.common.SnowTable
import java.util.*

/**
 * com.app.jfinal.service.workorder.model.WosafetylinkView <br></br>
 *
 * @author 蒋カイセキ    Japan-Tokyo  2017-08-08 15:25:20<br></br>
 * ブログ http://shoukaiseki.blog.163.com/<br></br>
 * E-メール jiang28555@Gmail.com<br></br>
 */
@SnowTable(maxObjecxtName = "WOSAFETYLINK", maxSequenceName = "WOSAFETYLINKSEQ", maxUniqueIDName = "WOSAFETYLINKID")
class WosafetylinkView : BaseModel() {

    /**
     * 危险点详细描述
     */
    var wohazard_description: String? = null

    var wohazard_wohazardid:Long?=null

    /**
     * 危险点预防措施
     */
    var wohazardprecViews: List<WohazardprecView> = Lists.newArrayList()

    /**
     * 应用序列
     */
    var applyseq: Int? = null


    /**
     * 关联资产
     */
    var assetnum: String? = null


    /**
     * 是否执行？
     */
    var da_iszx: Boolean? = null


    /**
     * 危险
     */
    var hazardid: String? = null


    /**
     * 相关位置
     */
    var location: String? = null


    /**
     * 组织
     */
    override var orgid: String? = null


    /**
     * 删除序列
     */
    var removeseq: Int? = null


    /**
     * 地点
     */
    override var siteid: String? = null


    /**
     * 隔离
     */
    var tagoutid: String? = null


    /**
     * 工单
     */
    var wonum: String? = null


    /**
     * 安全源
     */
    var wosafetydatasource: String? = null


    /**
     * 工单链接标识
     */
    @SnowField(isPrimary = true)
    var wosafetylinkid: Long? = null


    /**
     * wosl01
     */
    var wosl01: String? = null


    /**
     * wosl02
     */
    var wosl02: String? = null


    /**
     * WOSL03
     */
    var wosl03: Date? = null


    /**
     * wosl04
     */
    var wosl04: Double? = null


    /**
     * wosl05
     */
    var wosl05: Int? = null


    override fun showMaxUniqueIDValue(): Long? {
        return wosafetylinkid
    }

    override fun add( ):Long {
        val obj = this
        var parentbm =parentbasemodel

        var objid:Long=-1L
        log.debug("wosafetylink.add")
        log.debug("parentbasemodel=${parentbasemodel?.javaClass}")
        if(parentbm is Workorder){
            var wohazard= Wohazard()
            wohazard.copyDBObjects(obj)
            wohazard.wonum=parentbm.wonum
            wohazard.hazardid=obj.hazardid
            wohazard.wohazardid=obj.wohazard_wohazardid
            wohazard.ms_toadd=obj.ms_toadd
            wohazard.ms_tobedelete=obj.ms_tobedelete
            wohazard.ms_tobemodify=obj.ms_tobemodify
            wohazard.description=obj.wohazard_description

            var wosafetylink= Wosafetylink()
            wosafetylink.copyDBObjects(obj)
            wosafetylink.wosafetylinkid=obj.wosafetylinkid
            wosafetylink.parentbasemodel= obj.parentbasemodel
            wosafetylink.wonum= parentbm.wonum
            wosafetylink.hazardid=obj.hazardid
            wosafetylink.tagoutid=obj.tagoutid
            wosafetylink.location=obj.location
            wosafetylink.assetnum=obj.assetnum
            wosafetylink.ms_toadd=obj.ms_toadd
            wosafetylink.ms_tobedelete=obj.ms_tobedelete
            wosafetylink.ms_tobemodify=obj.ms_tobemodify
            if(obj.ms_toadd){
                wosafetylink.putMaxUniqueIDValue()
                wohazard.putMaxUniqueIDValue()
//                objid = DBUtils.nextSequenceValue(wosafetylink.showMaxSequenceName())
//                wosafetylink.wosafetylinkid=objid
            }

            wohazard.save()
            objid=wosafetylink.save()
            for (wohazardprecview in obj.wohazardprecViews){
                wohazardprecview.copyDB(obj)
                var wohazardprec= Wohazardprec()
                wohazardprec.copyDBObjects(wohazardprecview)
                wohazardprec.wonum=parentbm.wonum
                wohazardprec.hazardid=wohazardprecview.hazardid
                wohazardprec.precautionid=wohazardprecview.precautionid
                var woprecaution= Woprecaution()
                woprecaution.copyDBObjects(wohazardprecview)
                woprecaution.wonum=parentbm.wonum
                woprecaution.precautionid=wohazardprecview.precautionid
                woprecaution.description=wohazardprecview.woprecaution_description
                woprecaution.woprecautionid=wohazardprecview.woprecaution_woprecautionid
                if(wohazardprecview.ms_toadd){
                    wohazardprec.putMaxUniqueIDValue()
                    woprecaution.putMaxUniqueIDValue()
                }
                wohazardprec.save()
                woprecaution.save()
            }

        }

        /**
         *
        val sfpMap = BaseModel.loadSnowFieldPropMap(this.javaClass)

        val objid = DBUtils.nextSequenceValue(this.javaClass)
        obj.putMaxUniqueIDValue(objid)

        val insertMap = obj.toInsertMap(1)
        //设置默认值
        obj.insertDefaultValueToNull(insertMap, basemodelUser as User)

        log.debug("insertMap=" + JSONObject.toJSONString(insertMap, SerializerFeature.WriteMapNullValue))
        val maxdefMap = maxDB!!.getInsertDefaultValue(AnnotationUtils.getMaxObjectName(this.javaClass), basemodelUser)
        log.debug("maxdefMap=" + JSONObject.toJSONString(maxdefMap, SerializerFeature.WriteMapNullValue))
        val map = DBUtils.mergeInsertMap(insertMap, maxdefMap, sfpMap)
        log.debug(this.javaClass.toString() + "save.map=" + JSONObject.toJSONString(map, SerializerFeature.WriteMapNullValue))
        DBUtils.saveInsertByMap(snowDb, AnnotationUtils.getMaxEntityName(this.javaClass), map)
         */
        return objid
    }
}


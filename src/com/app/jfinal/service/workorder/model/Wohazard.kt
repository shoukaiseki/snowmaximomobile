package com.app.jfinal.service.workorder.model

import com.google.common.collect.Maps
import org.shoukaiseki.jfinal.kernel.common.BaseModel
import org.shoukaiseki.jfinal.kernel.common.SnowField
import org.shoukaiseki.jfinal.kernel.common.SnowTable
import java.util.*

/**
 * com.app.jfinal.service.workorder.model.Wohazard <br></br>
 *
 * @author 蒋カイセキ    Japan-Tokyo  2017-08-21 16:42:17<br></br>
 * ブログ http://shoukaiseki.blog.163.com/<br></br>
 * E-メール jiang28555@Gmail.com<br></br>
 */
@SnowTable(maxObjecxtName = "WOHAZARD", maxSequenceName = "WOHAZARDSEQ", maxEntityName = "WOHAZARD",maxUniqueIDName = "WOHAZARDID")
class Wohazard : BaseModel() {




    /**
     * 描述
     */
     var description: String? = null

    @SnowField(isPrimary =true)
    var wohazardid:Long?=null

    /**
     * 地点
     */
    @SnowField(isUpdateIgnore = true)
    override var siteid: String? = null

    /**
     * 工单
     */
    @SnowField(isUpdateIgnore = true)
    var wonum: String? = null

    var hazardid: String?=null


    override fun ifNullDefaultValueMap(): HashMap<String, Any> {
        val defvalmap = Maps.newHashMap<String, Any>()
        defvalmap.put("ORGID", "&ORGID&")
        defvalmap.put("SITEID", "&SITEID&")
        defvalmap.put("WOSAFETYDATASOURCE","WO")
        defvalmap.put("LANGCODE","ZH")
        defvalmap.put("PRECAUTIONENABLED",true)
        defvalmap.put("HAZMATENABLED",false)
        defvalmap.put("TAGOUTENABLED",false)

        return defvalmap;
    }


}

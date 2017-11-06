package com.app.jfinal.service.workorder.model

import org.shoukaiseki.jfinal.kernel.common.SnowField
import org.shoukaiseki.jfinal.kernel.common.SnowTable

@SnowTable(maxObjecxtName = "WORKORDER", maxSequenceName = "WORKORDERSEQ")
class Wotask : Workorder() {

    override var wonum: String? = null

    override var istask: Boolean? = true

    override var description: String? = null

    override var taskid: Int? = null

    override var siteid: String? = null

    override var orgid: String? = null


    override var parent: String? = null

    @SnowField(isPrimary = true)
    override var workorderid: Long? = null

    @SnowField(isInsertIgnore = true)
    var rowtamp: Long? = null

    override var woclass: String? = null


    override fun toUpdateMap(): Map<String, Any> {
        // TODO Auto-generated method stub
        return toUpdateMap(-1, Wotask::class.java)
    }


    override fun ifNullDefaultValueMap(): java.util.HashMap<String, Any> {
        val defvalmap = super.ifNullDefaultValueMap()
        defvalmap.put("ISTASK", true)
        return defvalmap
    }

}

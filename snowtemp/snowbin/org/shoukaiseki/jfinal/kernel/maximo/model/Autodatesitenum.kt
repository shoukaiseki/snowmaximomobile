package org.shoukaiseki.jfinal.kernel.maximo.model

import org.shoukaiseki.jfinal.kernel.common.BaseModel
import org.shoukaiseki.jfinal.kernel.common.SnowField
import org.shoukaiseki.jfinal.kernel.common.SnowTable

/**
 * org.shoukaiseki.jfinal.kernel.maximo.model.Autodatesitenum <br></br>

 * @author 蒋カイセキ    Japan-Tokyo  2017-06-29 08:55:06<br></br>
 * *         ブログ http://shoukaiseki.blog.163.com/<br></br>
 * *         E-メール jiang28555@Gmail.com<br></br>
 */

@SnowTable(maxObjecxtName = "AUTODATESITENUM", maxSequenceName = "AUTODATESITENUMIDSEQ")
class Autodatesitenum : BaseModel() {

    /**
     * ID
     */
    @SnowField(isPrimary = true)
    var autodatesitenumid: Long? = null


    /**
     * 描述
     */
    var description: String? = null

    /**
     * 月份
     */
    var month: Int? = null


    /**
     * 当月记录数编号
     */
    var num: Int? = null




    /**
     * 用于编号的字段名
     */
    var ownerattributename: String? = null


    /**
     * 用于编号的主对象名
     */
    var ownertable: String? = null


    /**
     * 站点
     */
    override var siteid: String? = null


    /**
     * 年份
     */
    var year: Int? = null


    override fun showMaxUniqueIDName(): String {
        return "AUTODATESITENUMID"
    }

    override fun showMaxUniqueIDValue(): Long? {
        return autodatesitenumid
    }

    override fun showMaxTableName(): String {
        return "AUTODATESITENUM"
    }
}

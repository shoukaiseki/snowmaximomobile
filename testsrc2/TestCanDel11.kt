import com.app.jfinal.service.workorder.model.Workorder
import java.util.*

/**
 */
object TestCanDel11 {

    @JvmStatic fun main(ages: Array<String>) {
        val l = java.lang.Long.parseLong("1212121")
        setValue("asus", Date("1212121".toLong()), 11L)
        var wo= Workorder();
        wo.workorderid=123L
        var a=wo.showMaxUniqueIDName()
        println("showMaxUniqueIDName=$a,showMaxUniqueIDValue=${wo.showMaxUniqueIDValue()}")
    }

    fun setValue(name: String, value: Date, pae: Long) {

    }

}

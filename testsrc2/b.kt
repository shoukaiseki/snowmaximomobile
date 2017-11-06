

import model.TestModel2
import java.util.*

/**
 */
object b {

    @JvmStatic fun main(args: Array<String>) {
        val cishu = 100
        var startDate = Date(System.currentTimeMillis())
        test1(cishu)
        var endDate = Date(System.currentTimeMillis())
        println("test1=" + dateDiff(startDate, endDate))
        startDate = Date(System.currentTimeMillis())
        test2(cishu)
        endDate = Date(System.currentTimeMillis())
        println("test2=" + dateDiff(startDate, endDate))
        var tm2=TestModel2()
        tm2.showName()
//        val name =  TestModel2.INSTANCE.showName()
//        val name2 = TestModel.INSTANCE.showName()
//        println("name=$name,name2=$name2")

    }

    fun dateDiff(startDate: Date, endDate: Date): String {
        val l = endDate.time - startDate.time
        return (l / 1000).toString() + "s" + l % 1000 + "ms"
    }

    fun test1(cishu: Int) {
        for (i in 0..cishu - 1) {

//            val name = AnnotationUtils.getMaxObjectName(Workorder::class.java)
            //            println("$i.test1.name=$name")
        }
    }

    fun test2(cishu: Int) {
        //        Workorder tm=new Workorder();
//        val tm = TestModel()
        for (i in 0..cishu - 1) {
            //            var name=TestModel.showMaxTableName()
//             val name =  TestModel2.INSTANCE.showName()
//            val name2 = TestModel.INSTANCE.showName()
            //            println("$i.test1.name=$name")
        }
    }

}

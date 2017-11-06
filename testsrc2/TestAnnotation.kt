
import com.app.jfinal.service.workorder.model.Workorder
import java.util.*

/**
 **/
public class TestAnnotation {

    init{
        println("aaaa")
    }

    companion object {
        fun test1(cishu:Int){
            for (i in 0..cishu-1){
//                var name=AnnotationUtils.getMaxObjectName(TestModel::class.java)
//            println("$i.test1.name=$name")
            }
        }
        fun test2(cishu:Int){
            val tm= Workorder()
            for (i in 0..cishu-1){
//            var name=TestModel.showMaxTableName()
//                var name=tm.showMaxTableName()
//            println("$i.test1.name=$name")
            }
        }

        fun dateDiff(startDate:Date,endDate: Date):String{
            var l=endDate.time-startDate.time
            return "${l/1000}s${l%1000}ms";
        }

        fun asus(age:String?="asus"){
            println("age=$age")
        }

        @JvmStatic fun main(ages: Array<String>) {
//        var l=java.lang.Long.valueOf("100KB")
//        println("l=$l")


            var cishu=10
            var startDate=Date(System.currentTimeMillis())
            test1(cishu)
            var endDate=Date(System.currentTimeMillis())
            println("test1=${dateDiff(startDate,endDate)}")
            startDate=Date(System.currentTimeMillis())
            test2(cishu)
            endDate=Date(System.currentTimeMillis())
            println("test2=${dateDiff(startDate,endDate)}")

            asus()
            asus("11")
        }
    }

}



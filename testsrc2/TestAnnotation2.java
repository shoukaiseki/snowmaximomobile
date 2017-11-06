import com.app.jfinal.service.workorder.model.Workorder;
import org.shoukaiseki.jfinal.kernel.common.AnnotationUtils;
import model.TestModel;

import java.util.Date;

/**
 **/
public class TestAnnotation2 {

    public static void main(String[] args) {
        int cishu=100;
        Date startDate=new Date(System.currentTimeMillis());
        test1(cishu);
        Date endDate=new Date(System.currentTimeMillis());
        System.out.println("test1="+dateDiff(startDate,endDate));
        startDate=new Date(System.currentTimeMillis());
        test2(cishu);
        endDate=new Date(System.currentTimeMillis());
        System.out.println("test2="+dateDiff(startDate,endDate));


    }

    public static String dateDiff(Date startDate,Date endDate ){
        long l=endDate.getTime()-startDate.getTime();
        return l/1000+"s"+l%1000+"ms";
    }

    public static void test1(int cishu){
        for (int i = 0; i < cishu; i++) {

            String name= AnnotationUtils.getMaxObjectName(Workorder.class);
//            println("$i.test1.name=$name")
        }
    }
    public static void test2(int cishu){
//        Workorder tm=new Workorder();
        TestModel tm=new TestModel();
        for (int i = 0; i < cishu; i++) {
//            var name=TestModel.showMaxTableName()
            String name=tm.showMaxTableName();
//            String name2=TestModel.INSTANCE.showName();
//            println("$i.test1.name=$name")
        }
    }

}

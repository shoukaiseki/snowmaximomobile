import model.TestModel;
import model.TestModel2;

/**
 **/
public class TestAnnotation3 {

    public static void main(String[] args) {
        TestAnnotation ta=new TestAnnotation();;
        TestAnnotation2 ta2=new TestAnnotation2();

        ta=new TestAnnotation();;
        ta2=new TestAnnotation2();

        String name=new TestModel().showName();

        String name2= TestModel2.Companion.getINSTANCE().showName();
        System.out.println("name="+name+",name2="+name2);

    }

}

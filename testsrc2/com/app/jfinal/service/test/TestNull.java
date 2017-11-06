package com.app.jfinal.service.test;

/**
 **/
public class TestNull {

    public static TestNull getThis(){
        if(1==1){
            return new TestNull();
        }
        return null;
    }

    public void asus1(){
        System.out.println("asus1");
    }

    public void asus2(){
        System.out.println("asus2");
    }

    public static void main(String[] args) {
        TestNull tn=TestNull.getThis();
        if(tn!=null){
            tn.asus1();
            tn.asus2();
        }

        try {

            System.out.println("asus111");
//            Long.parseLong("ass");
            String[] aaaaa={""};
            System.out.println(aaaaa[12]);

//            throw new NullPointerException("aaaaaaaaaa");

        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            System.out.println("asus222");
        }
        System.out.println("asus333");

    }

}

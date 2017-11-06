package com.app.jfinal.service.test;

import java.util.Random;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.app.jfinal.service.test.model.Test3;
import org.shoukaiseki.jfinal.kernel.testkit.RandomData;
import org.shoukaiseki.jfinal.kernel.testkit.RandomModel;

public class TestRandomModel {
	
	public static void main(String[] args) {
		Test3 model = new RandomModel().random(Test3.class, Test3.class);
		
		System.out.println();
		System.out.println(JSONObject.toJSONString(model,SerializerFeature.WriteMapNullValue));
		
		String str=RandomData.randomChineseByte();
		System.out.println(str);
		str=randomEN(12);
		System.out.println(str);
	}

	public static String randomEN(int length){
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(52);// [0,51)
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
    
}

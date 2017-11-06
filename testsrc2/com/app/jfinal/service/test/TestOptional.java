package com.app.jfinal.service.test;

import com.google.common.base.Optional;
import org.shoukaiseki.jfinal.kernel.common.SnowFieldProp;

public class TestOptional {

	public static void main(String[] args) throws Exception {
		testOptional();
		
		SnowFieldProp sfp=null;
		Optional<SnowFieldProp> sd=Optional.fromNullable(sfp);
		System.out.println(sd);
		//如果空对象则不能直接 get
		System.out.println(sd.isPresent());
		
		sfp=new SnowFieldProp("workorder","asus");
		 sd=Optional.fromNullable(sfp);
		System.out.println(sd.get());
	}
	
	
	public static void testOptional() throws Exception { 
		Optional<Integer> possible=Optional.of(6);
		Optional<Integer> absentOpt=Optional.absent();
		Optional<Integer> NullableOpt=Optional.fromNullable(null);
		Optional<Integer> NoNullableOpt=Optional.fromNullable(10);
		if(possible.isPresent()){
			System.out.println("possible isPresent:"+possible.isPresent());
			System.out.println("possible value:"+possible.get());
		}
		if(absentOpt.isPresent()){
			System.out.println("absentOpt isPresent:"+absentOpt.isPresent()); ;
		}
		if(NullableOpt.isPresent()){
			System.out.println("fromNullableOpt isPresent:"+NullableOpt.isPresent()); ;
			System.out.println("fromNullableOpt value:"+NullableOpt.get()); ;
		}
		if(NoNullableOpt.isPresent()){
			System.out.println("NoNullableOpt isPresent:"+NoNullableOpt.isPresent()); ;
		}
	} 
}

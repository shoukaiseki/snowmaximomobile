package com

class TestKotlin 	{

	companion  object {
		fun getThis():TestKotlin?{
			if(1==2){
				return TestKotlin()
			}else{
				return null
			}
		}

	}

	fun asus1(){
		println("asus1")
	}

	fun asus2(){
		println("asus2")
	}
}
	fun asus(){
		println("Hello")
	}

    fun asus2() {
		var a:String? = null
        a="valueb"
		var b = a ?: return
        println("b=$b")

    }

	fun main(args: Array<String>) {
        /**
		asus()
		asus2()

		var aas=TTTTSSA()
		aas.asuss();
		**/
        var tk:TestKotlin?
		tk= TestKotlin.getThis()
		tk?.let {
			tk!!.asus1()
			tk!!.asus2()
		}
		println("tk is null")
	}
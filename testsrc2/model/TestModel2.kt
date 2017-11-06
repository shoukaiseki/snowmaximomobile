package model

import org.shoukaiseki.jfinal.kernel.common.SnowTable


/**
 */
@SnowTable(maxObjecxtName = "WORKORDER", maxSequenceName = "WORKORDERSEQ")
class TestModel2 : TestModel() {

    companion object  {
        val INSTANCE = TestModel2()
    }

     override fun showName():String {

        return "TestModel2"
    }

     fun showName2(): String {
        return "TestModel2"
    }


}

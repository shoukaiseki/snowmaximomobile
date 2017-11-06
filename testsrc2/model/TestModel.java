package model;

import org.shoukaiseki.jfinal.kernel.common.SnowTable;

import java.util.Date;

/**
 **/
@SnowTable(maxObjecxtName="WORKORDER",maxSequenceName="WORKORDERSEQ")
public class TestModel {

    private Date date;
    private String string;
    private Integer integer;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    @Override
    public String toString() {
        return ReflectToStringUtil.toStringUtil(this,false);
    }

    public  String showMaxTableName() {
        // TODO Auto-generated method stub
        return "WORKORDER";
    }

    public  String showName() {
        return "WORKORDER";
    }
}

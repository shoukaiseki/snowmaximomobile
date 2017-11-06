package com.app.jfinal.service.workorder.model;

import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowTable;

import java.util.Date;

/**
 * Wplabor <br>
 *
 * @author 蒋カイセキ    Japan-Tokyo  2017-08-10 15:39:55<br>
 * ブログ http://shoukaiseki.blog.163.com/<br>
 * E-メール jiang28555@Gmail.com<br>
 **/
@SnowTable(maxObjecxtName = "WPLABOR",maxSequenceName ="WPLABORSEQ",maxEntityName = "WPLABOR",maxUniqueIDName = "WPLABORUID")
public class Wplabor extends BaseModel{

    /**
     *班组
     **/
    private String amcrew;


    /**
     *班组类型
     **/
    private String amcrewtype;


    /**
     *需要委派
     **/
    private Boolean apptrequired;


    /**
     *员工合同
     **/
    private String contractnum;


    /**
     *工种
     **/
    private String craft;


    /**
     *班组工作组
     **/
    private String crewworkgroup;


    /**
     *员工
     **/
    private String laborcode;


    /**
     *常规时数
     **/
    private Double laborhrs;


    /**
     *组织
     **/
    private String orgid;


    /**
     *数量
     **/
    private Integer quantity;


    /**
     *费率
     **/
    private Double rate;


    /**
     *比率已变更
     **/
    private Boolean ratehaschanged;


    /**
     *地点
     **/
    private String siteid;


    /**
     *技能级别
     **/
    private String skilllevel;


    /**
     *供应商
     **/
    private String vendor;


    /**
     *工单
     **/
    private String wonum;


    /**
     *Wpl1
     **/
    private String wpl1;


    /**
     *Wpl2
     **/
    private Date wpl2;


    /**
     *Wpl3
     **/
    private String wpl3;


    /**
     *Wpl4
     **/
    private String wpl4;


    /**
     *Wpl5
     **/
    private String wpl5;


    /**
     *Wpl6
     **/
    private Double wpl6;


    /**
     *WPL7
     **/
    private String wpl7;


    /**
     *WPL8
     **/
    private String wpl8;


    /**
     *WPL9
     **/
    private String wpl9;


    /**
     *工作计划员工标识
     **/
    private String wplaborid;


    /**
     *WPLABORUID
     **/
    private Long wplaboruid;


    public String getAmcrew() {
        return amcrew;
    }

    public void setAmcrew(String amcrew) {
        this.amcrew = amcrew;
    }

    public String getAmcrewtype() {
        return amcrewtype;
    }

    public void setAmcrewtype(String amcrewtype) {
        this.amcrewtype = amcrewtype;
    }

    public Boolean getApptrequired() {
        return apptrequired;
    }

    public void setApptrequired(Boolean apptrequired) {
        this.apptrequired = apptrequired;
    }

    public String getContractnum() {
        return contractnum;
    }

    public void setContractnum(String contractnum) {
        this.contractnum = contractnum;
    }

    public String getCraft() {
        return craft;
    }

    public void setCraft(String craft) {
        this.craft = craft;
    }

    public String getCrewworkgroup() {
        return crewworkgroup;
    }

    public void setCrewworkgroup(String crewworkgroup) {
        this.crewworkgroup = crewworkgroup;
    }

    public String getLaborcode() {
        return laborcode;
    }

    public void setLaborcode(String laborcode) {
        this.laborcode = laborcode;
    }

    public Double getLaborhrs() {
        return laborhrs;
    }

    public void setLaborhrs(Double laborhrs) {
        this.laborhrs = laborhrs;
    }

    @Override
    public String getOrgid() {
        return orgid;
    }

    @Override
    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Boolean getRatehaschanged() {
        return ratehaschanged;
    }

    public void setRatehaschanged(Boolean ratehaschanged) {
        this.ratehaschanged = ratehaschanged;
    }

    @Override
    public String getSiteid() {
        return siteid;
    }

    @Override
    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getSkilllevel() {
        return skilllevel;
    }

    public void setSkilllevel(String skilllevel) {
        this.skilllevel = skilllevel;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getWonum() {
        return wonum;
    }

    public void setWonum(String wonum) {
        this.wonum = wonum;
    }

    public String getWpl1() {
        return wpl1;
    }

    public void setWpl1(String wpl1) {
        this.wpl1 = wpl1;
    }

    public Date getWpl2() {
        return wpl2;
    }

    public void setWpl2(Date wpl2) {
        this.wpl2 = wpl2;
    }

    public String getWpl3() {
        return wpl3;
    }

    public void setWpl3(String wpl3) {
        this.wpl3 = wpl3;
    }

    public String getWpl4() {
        return wpl4;
    }

    public void setWpl4(String wpl4) {
        this.wpl4 = wpl4;
    }

    public String getWpl5() {
        return wpl5;
    }

    public void setWpl5(String wpl5) {
        this.wpl5 = wpl5;
    }

    public Double getWpl6() {
        return wpl6;
    }

    public void setWpl6(Double wpl6) {
        this.wpl6 = wpl6;
    }

    public String getWpl7() {
        return wpl7;
    }

    public void setWpl7(String wpl7) {
        this.wpl7 = wpl7;
    }

    public String getWpl8() {
        return wpl8;
    }

    public void setWpl8(String wpl8) {
        this.wpl8 = wpl8;
    }

    public String getWpl9() {
        return wpl9;
    }

    public void setWpl9(String wpl9) {
        this.wpl9 = wpl9;
    }

    public String getWplaborid() {
        return wplaborid;
    }

    public void setWplaborid(String wplaborid) {
        this.wplaborid = wplaborid;
    }

    public Long getWplaboruid() {
        return wplaboruid;
    }

    public void setWplaboruid(Long wplaboruid) {
        this.wplaboruid = wplaboruid;
    }



    public Long showMaxUniqueIDValue() {
        return wplaboruid;
    }


}

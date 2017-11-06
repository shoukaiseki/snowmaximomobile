package com.app.jfinal.service.workorder.model;

import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowTable;

import java.util.Date;

/**
 * Wpitem <br>
 *
 * @author 蒋カイセキ    Japan-Tokyo  2017-08-10 16:45:47<br>
 * ブログ http://shoukaiseki.blog.163.com/<br>
 * E-メール jiang28555@Gmail.com<br>
 **/
@SnowTable(maxObjecxtName = "WPITEM",maxSequenceName ="WPITEMSEQ",maxEntityName = "WPITEM",maxUniqueIDName = "WPITEMID")
public class Wpitem extends BaseModel{

    /**
     *实际用量
     **/
    private Double actualqty;


    /**
     *班组
     **/
    private String amcrew;


    /**
     *班组类型
     **/
    private String amcrewtype;


    /**
     *目录号
     **/
    private String catalogcode;


    /**
     *条件代码
     **/
    private String conditioncode;


    /**
     *描述
     **/
    private String description;


    /**
     *直接请求
     **/
    private Boolean directreq;


    /**
     *具有详细描述
     **/
    private Boolean hasld;


    /**
     *工具时数
     **/
    private Double hours;


    /**
     *发放目标
     **/
    private String issueto;


    /**
     *项目
     **/
    private String itemnum;


    /**
     *项目数量
     **/
    private Double itemqty;


    /**
     *项目集
     **/
    private String itemsetid;


    /**
     *语言代码
     **/
    private String langcode;


    /**
     *行成本
     **/
    private Double linecost;


    /**
     *行类型
     **/
    private String linetype;


    /**
     *库房
     **/
    private String location;


    /**
     *制造商
     **/
    private String manufacturer;


    /**
     *市场项目
     **/
    private Boolean mktplcitem;


    /**
     *型号
     **/
    private String modelnum;


    /**
     *订购单位
     **/
    private String orderunit;


    /**
     *组织
     **/
    private String orgid;


    /**
     *PR
     **/
    private String pr;


    /**
     *PR 行
     **/
    private Integer prlinenum;


    /**
     *费率
     **/
    private Double rate;


    /**
     *比率已变更
     **/
    private Boolean ratehaschanged;


    /**
     *请求者
     **/
    private String requestby;


    /**
     *请求
     **/
    private String requestnum;


    /**
     *要求的日期
     **/
    private Date requiredate;


    /**
     *预留类型
     **/
    private String restype;


    /**
     *地点
     **/
    private String siteid;


    /**
     *标准用量
     **/
    private Double standardqty;


    /**
     *库房地点
     **/
    private String storelocsite;


    /**
     *单位成本
     **/
    private Double unitcost;


    /**
     *单位成本已变更
     **/
    private Boolean unitcosthaschanged;


    /**
     *供应商
     **/
    private String vendor;


    /**
     *供应商包装代码
     **/
    private String vendorpackcode;


    /**
     *供应商包装数量
     **/
    private String vendorpackquantity;


    /**
     *供应商单位成本
     **/
    private Double vendorunitcost;


    /**
     *供应商仓库
     **/
    private String vendorwarehouse;


    /**
     *工单
     **/
    private String wonum;


    /**
     *工作计划项目标识
     **/
    private Long wpitemid;


    /**
     *班组引用
     **/
    private Long wplaborref;


    /**
     *Wpm1
     **/
    private String wpm1;


    /**
     *Wpm2
     **/
    private String wpm2;


    /**
     *Wpm3
     **/
    private Double wpm3;


    /**
     *Wpm4
     **/
    private String wpm4;


    /**
     *Wpm4
     **/
    private Double wpm5;


    /**
     *Wpm6
     **/
    private String wpm6;

    public Double getActualqty() {
        return actualqty;
    }

    public void setActualqty(Double actualqty) {
        this.actualqty = actualqty;
    }

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

    public String getCatalogcode() {
        return catalogcode;
    }

    public void setCatalogcode(String catalogcode) {
        this.catalogcode = catalogcode;
    }

    public String getConditioncode() {
        return conditioncode;
    }

    public void setConditioncode(String conditioncode) {
        this.conditioncode = conditioncode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDirectreq() {
        return directreq;
    }

    public void setDirectreq(Boolean directreq) {
        this.directreq = directreq;
    }

    public Boolean getHasld() {
        return hasld;
    }

    public void setHasld(Boolean hasld) {
        this.hasld = hasld;
    }

    public Double getHours() {
        return hours;
    }

    public void setHours(Double hours) {
        this.hours = hours;
    }

    public String getIssueto() {
        return issueto;
    }

    public void setIssueto(String issueto) {
        this.issueto = issueto;
    }

    public String getItemnum() {
        return itemnum;
    }

    public void setItemnum(String itemnum) {
        this.itemnum = itemnum;
    }

    public Double getItemqty() {
        return itemqty;
    }

    public void setItemqty(Double itemqty) {
        this.itemqty = itemqty;
    }

    public String getItemsetid() {
        return itemsetid;
    }

    public void setItemsetid(String itemsetid) {
        this.itemsetid = itemsetid;
    }

    public String getLangcode() {
        return langcode;
    }

    public void setLangcode(String langcode) {
        this.langcode = langcode;
    }

    public Double getLinecost() {
        return linecost;
    }

    public void setLinecost(Double linecost) {
        this.linecost = linecost;
    }

    public String getLinetype() {
        return linetype;
    }

    public void setLinetype(String linetype) {
        this.linetype = linetype;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Boolean getMktplcitem() {
        return mktplcitem;
    }

    public void setMktplcitem(Boolean mktplcitem) {
        this.mktplcitem = mktplcitem;
    }

    public String getModelnum() {
        return modelnum;
    }

    public void setModelnum(String modelnum) {
        this.modelnum = modelnum;
    }

    public String getOrderunit() {
        return orderunit;
    }

    public void setOrderunit(String orderunit) {
        this.orderunit = orderunit;
    }

    @Override
    public String getOrgid() {
        return orgid;
    }

    @Override
    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getPr() {
        return pr;
    }

    public void setPr(String pr) {
        this.pr = pr;
    }

    public Integer getPrlinenum() {
        return prlinenum;
    }

    public void setPrlinenum(Integer prlinenum) {
        this.prlinenum = prlinenum;
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

    public String getRequestby() {
        return requestby;
    }

    public void setRequestby(String requestby) {
        this.requestby = requestby;
    }

    public String getRequestnum() {
        return requestnum;
    }

    public void setRequestnum(String requestnum) {
        this.requestnum = requestnum;
    }

    public Date getRequiredate() {
        return requiredate;
    }

    public void setRequiredate(Date requiredate) {
        this.requiredate = requiredate;
    }

    public String getRestype() {
        return restype;
    }

    public void setRestype(String restype) {
        this.restype = restype;
    }

    @Override
    public String getSiteid() {
        return siteid;
    }

    @Override
    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public Double getStandardqty() {
        return standardqty;
    }

    public void setStandardqty(Double standardqty) {
        this.standardqty = standardqty;
    }

    public String getStorelocsite() {
        return storelocsite;
    }

    public void setStorelocsite(String storelocsite) {
        this.storelocsite = storelocsite;
    }

    public Double getUnitcost() {
        return unitcost;
    }

    public void setUnitcost(Double unitcost) {
        this.unitcost = unitcost;
    }

    public Boolean getUnitcosthaschanged() {
        return unitcosthaschanged;
    }

    public void setUnitcosthaschanged(Boolean unitcosthaschanged) {
        this.unitcosthaschanged = unitcosthaschanged;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVendorpackcode() {
        return vendorpackcode;
    }

    public void setVendorpackcode(String vendorpackcode) {
        this.vendorpackcode = vendorpackcode;
    }

    public String getVendorpackquantity() {
        return vendorpackquantity;
    }

    public void setVendorpackquantity(String vendorpackquantity) {
        this.vendorpackquantity = vendorpackquantity;
    }

    public Double getVendorunitcost() {
        return vendorunitcost;
    }

    public void setVendorunitcost(Double vendorunitcost) {
        this.vendorunitcost = vendorunitcost;
    }

    public String getVendorwarehouse() {
        return vendorwarehouse;
    }

    public void setVendorwarehouse(String vendorwarehouse) {
        this.vendorwarehouse = vendorwarehouse;
    }

    public String getWonum() {
        return wonum;
    }

    public void setWonum(String wonum) {
        this.wonum = wonum;
    }

    public Long getWpitemid() {
        return wpitemid;
    }

    public void setWpitemid(Long wpitemid) {
        this.wpitemid = wpitemid;
    }

    public Long getWplaborref() {
        return wplaborref;
    }

    public void setWplaborref(Long wplaborref) {
        this.wplaborref = wplaborref;
    }

    public String getWpm1() {
        return wpm1;
    }

    public void setWpm1(String wpm1) {
        this.wpm1 = wpm1;
    }

    public String getWpm2() {
        return wpm2;
    }

    public void setWpm2(String wpm2) {
        this.wpm2 = wpm2;
    }

    public Double getWpm3() {
        return wpm3;
    }

    public void setWpm3(Double wpm3) {
        this.wpm3 = wpm3;
    }

    public String getWpm4() {
        return wpm4;
    }

    public void setWpm4(String wpm4) {
        this.wpm4 = wpm4;
    }

    public Double getWpm5() {
        return wpm5;
    }

    public void setWpm5(Double wpm5) {
        this.wpm5 = wpm5;
    }

    public String getWpm6() {
        return wpm6;
    }

    public void setWpm6(String wpm6) {
        this.wpm6 = wpm6;
    }



    public Long showMaxUniqueIDValue() {
        return wpitemid;
    }

}

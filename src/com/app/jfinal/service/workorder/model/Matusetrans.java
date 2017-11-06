package com.app.jfinal.service.workorder.model;

import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowTable;

import java.util.Date;

/**
 * Matusetrans <br>
 *
 * @author 蒋カイセキ    Japan-Tokyo  2017-08-10 18:59:40<br>
 * ブログ http://shoukaiseki.blog.163.com/<br>
 * E-メール jiang28555@Gmail.com<br>
 **/
@SnowTable(maxObjecxtName = "MATUSETRANS",maxSequenceName ="MATUSETRANSSEQ",maxEntityName = "MATUSETRANS",maxUniqueIDName = "MATUSETRANSID")
public class Matusetrans extends BaseModel{



    /**
     *实际成本
     **/
    private Double actualcost;


    /**
     *实际日期
     **/
    private Date actualdate;


    /**
     *实际用量
     **/
    private Double actualqty;


    /**
     *Anywhere 引用标识
     **/
    private Long anywhererefid;


    /**
     *资产
     **/
    private String assetnum;


    /**
     *货柜
     **/
    private String binnum;


    /**
     *商品代码
     **/
    private String commodity;


    /**
     *商品组
     **/
    private String commoditygroup;


    /**
     *条件代码
     **/
    private String conditioncode;


    /**
     *费率百分比
     **/
    private Integer condrate;


    /**
     *寄售
     **/
    private Boolean consignment;


    /**
     *寄售发票
     **/
    private String consinvoicenum;


    /**
     *寄售供应商
     **/
    private String consvendor;


    /**
     *换算系数
     **/
    private Double conversion;


    /**
     *当前余量
     **/
    private Double curbal;


    /**
     *货币
     **/
    private String currencycode;


    /**
     *贷币行成本
     **/
    private Double currencylinecost;


    /**
     *货币单位成本
     **/
    private Double currencyunitcost;


    /**
     *描述
     **/
    private String description;


    /**
     *输入人
     **/
    private String enterby;


    /**
     *作为任务输入
     **/
    private Boolean enteredastask;


    /**
     *汇率
     **/
    private Double exchangerate;


    /**
     *二级汇率
     **/
    private Double exchangerate2;


    /**
     *外部引用标识
     **/
    private String externalrefid;


    /**
     *财务周期
     **/
    private String financialperiod;


    /**
     *财务控制标识
     **/
    private String fincntrlid;


    /**
     *GL 贷方科目
     **/
    private String glcreditacct;


    /**
     *GL 借方科目
     **/
    private String gldebitacct;


    /**
     *具有详细描述
     **/
    private Boolean hasld;


    /**
     *用途
     **/
    private Long invuseid;


    /**
     *使用情况行
     **/
    private Long invuselineid;


    /**
     *发放标识
     **/
    private Long issueid;


    /**
     *发放到
     **/
    private String issueto;


    /**
     *交易类型
     **/
    private String issuetype;


    /**
     *扩展字段 1
     **/
    private String it1;


    /**
     *IT10
     **/
    private String it10;


    /**
     *扩展字段 2
     **/
    private String it2;


    /**
     *扩展字段 3
     **/
    private String it3;


    /**
     *扩展字段 4
     **/
    private Double it4;


    /**
     *扩展字段 5
     **/
    private String it5;


    /**
     *IT6
     **/
    private String it6;


    /**
     *IT7
     **/
    private String it7;


    /**
     *IT8
     **/
    private String it8;


    /**
     *IT9
     **/
    private String it9;


    /**
     *项目
     **/
    private String itemnum;


    /**
     *项目集
     **/
    private String itemsetid;


    /**
     *Itin1
     **/
    private String itin1;


    /**
     *Itin2
     **/
    private String itin2;


    /**
     *Itin3
     **/
    private String itin3;


    /**
     *ITIN4
     **/
    private String itin4;


    /**
     *ITIN5
     **/
    private String itin5;


    /**
     *ITIN6
     **/
    private String itin6;


    /**
     *ITIN7
     **/
    private String itin7;


    /**
     *语言代码
     **/
    private String langcode;


    /**
     *行成本
     **/
    private Double linecost;


    /**
     *次级行成本
     **/
    private Double linecost2;


    /**
     *行类型
     **/
    private String linetype;


    /**
     *位置
     **/
    private String location;


    /**
     *批次
     **/
    private String lotnum;


    /**
     *收据标识
     **/
    private Long matrectransid;


    /**
     *使用情况标识
     **/
    private Long matusetransid;


    /**
     *备忘录
     **/
    private String memo;


    /**
     *申请行
     **/
    private Integer mrlinenum;


    /**
     *申请
     **/
    private String mrnum;


    /**
     *组织
     **/
    private String orgid;


    /**
     *外部
     **/
    private Boolean outside;


    /**
     *所有者系统标识
     **/
    private String ownersysid;


    /**
     *装箱单
     **/
    private String packingslipnum;


    /**
     *实际库存量
     **/
    private Double physcnt;


    /**
     *PO 行
     **/
    private Integer polinenum;


    /**
     *PO
     **/
    private String ponum;


    /**
     *PO 修订
     **/
    private Integer porevisionnum;


    /**
     *请求的量
     **/
    private Double qtyrequested;


    /**
     *已退回数量
     **/
    private Double qtyreturned;


    /**
     *数量
     **/
    private Double quantity;


    /**
     *工单
     **/
    private String refwo;


    /**
     *累计
     **/
    private Boolean rollup;


    /**
     *周转资产
     **/
    private String rotassetnum;


    /**
     *发送者系统标识
     **/
    private String sendersysid;


    /**
     *地点
     **/
    private String siteid;


    /**
     *源系统标识
     **/
    private String sourcesysid;


    /**
     *备件已添加
     **/
    private Boolean sparepartadded;


    /**
     *库房
     **/
    private String storeloc;


    /**
     *地点
     **/
    private String tositeid;


    /**
     *交易日期
     **/
    private Date transdate;


    /**
     *单位成本
     **/
    private Double unitcost;


    public Double getActualcost() {
        return actualcost;
    }

    public void setActualcost(Double actualcost) {
        this.actualcost = actualcost;
    }

    public Date getActualdate() {
        return actualdate;
    }

    public void setActualdate(Date actualdate) {
        this.actualdate = actualdate;
    }

    public Double getActualqty() {
        return actualqty;
    }

    public void setActualqty(Double actualqty) {
        this.actualqty = actualqty;
    }

    public Long getAnywhererefid() {
        return anywhererefid;
    }

    public void setAnywhererefid(Long anywhererefid) {
        this.anywhererefid = anywhererefid;
    }

    public String getAssetnum() {
        return assetnum;
    }

    public void setAssetnum(String assetnum) {
        this.assetnum = assetnum;
    }

    public String getBinnum() {
        return binnum;
    }

    public void setBinnum(String binnum) {
        this.binnum = binnum;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getCommoditygroup() {
        return commoditygroup;
    }

    public void setCommoditygroup(String commoditygroup) {
        this.commoditygroup = commoditygroup;
    }

    public String getConditioncode() {
        return conditioncode;
    }

    public void setConditioncode(String conditioncode) {
        this.conditioncode = conditioncode;
    }

    public Integer getCondrate() {
        return condrate;
    }

    public void setCondrate(Integer condrate) {
        this.condrate = condrate;
    }

    public Boolean getConsignment() {
        return consignment;
    }

    public void setConsignment(Boolean consignment) {
        this.consignment = consignment;
    }

    public String getConsinvoicenum() {
        return consinvoicenum;
    }

    public void setConsinvoicenum(String consinvoicenum) {
        this.consinvoicenum = consinvoicenum;
    }

    public String getConsvendor() {
        return consvendor;
    }

    public void setConsvendor(String consvendor) {
        this.consvendor = consvendor;
    }

    public Double getConversion() {
        return conversion;
    }

    public void setConversion(Double conversion) {
        this.conversion = conversion;
    }

    public Double getCurbal() {
        return curbal;
    }

    public void setCurbal(Double curbal) {
        this.curbal = curbal;
    }

    public String getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode;
    }

    public Double getCurrencylinecost() {
        return currencylinecost;
    }

    public void setCurrencylinecost(Double currencylinecost) {
        this.currencylinecost = currencylinecost;
    }

    public Double getCurrencyunitcost() {
        return currencyunitcost;
    }

    public void setCurrencyunitcost(Double currencyunitcost) {
        this.currencyunitcost = currencyunitcost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnterby() {
        return enterby;
    }

    public void setEnterby(String enterby) {
        this.enterby = enterby;
    }

    public Boolean getEnteredastask() {
        return enteredastask;
    }

    public void setEnteredastask(Boolean enteredastask) {
        this.enteredastask = enteredastask;
    }

    public Double getExchangerate() {
        return exchangerate;
    }

    public void setExchangerate(Double exchangerate) {
        this.exchangerate = exchangerate;
    }

    public Double getExchangerate2() {
        return exchangerate2;
    }

    public void setExchangerate2(Double exchangerate2) {
        this.exchangerate2 = exchangerate2;
    }

    public String getExternalrefid() {
        return externalrefid;
    }

    public void setExternalrefid(String externalrefid) {
        this.externalrefid = externalrefid;
    }

    public String getFinancialperiod() {
        return financialperiod;
    }

    public void setFinancialperiod(String financialperiod) {
        this.financialperiod = financialperiod;
    }

    public String getFincntrlid() {
        return fincntrlid;
    }

    public void setFincntrlid(String fincntrlid) {
        this.fincntrlid = fincntrlid;
    }

    public String getGlcreditacct() {
        return glcreditacct;
    }

    public void setGlcreditacct(String glcreditacct) {
        this.glcreditacct = glcreditacct;
    }

    public String getGldebitacct() {
        return gldebitacct;
    }

    public void setGldebitacct(String gldebitacct) {
        this.gldebitacct = gldebitacct;
    }

    public Boolean getHasld() {
        return hasld;
    }

    public void setHasld(Boolean hasld) {
        this.hasld = hasld;
    }

    public Long getInvuseid() {
        return invuseid;
    }

    public void setInvuseid(Long invuseid) {
        this.invuseid = invuseid;
    }

    public Long getInvuselineid() {
        return invuselineid;
    }

    public void setInvuselineid(Long invuselineid) {
        this.invuselineid = invuselineid;
    }

    public Long getIssueid() {
        return issueid;
    }

    public void setIssueid(Long issueid) {
        this.issueid = issueid;
    }

    public String getIssueto() {
        return issueto;
    }

    public void setIssueto(String issueto) {
        this.issueto = issueto;
    }

    public String getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(String issuetype) {
        this.issuetype = issuetype;
    }

    public String getIt1() {
        return it1;
    }

    public void setIt1(String it1) {
        this.it1 = it1;
    }

    public String getIt10() {
        return it10;
    }

    public void setIt10(String it10) {
        this.it10 = it10;
    }

    public String getIt2() {
        return it2;
    }

    public void setIt2(String it2) {
        this.it2 = it2;
    }

    public String getIt3() {
        return it3;
    }

    public void setIt3(String it3) {
        this.it3 = it3;
    }

    public Double getIt4() {
        return it4;
    }

    public void setIt4(Double it4) {
        this.it4 = it4;
    }

    public String getIt5() {
        return it5;
    }

    public void setIt5(String it5) {
        this.it5 = it5;
    }

    public String getIt6() {
        return it6;
    }

    public void setIt6(String it6) {
        this.it6 = it6;
    }

    public String getIt7() {
        return it7;
    }

    public void setIt7(String it7) {
        this.it7 = it7;
    }

    public String getIt8() {
        return it8;
    }

    public void setIt8(String it8) {
        this.it8 = it8;
    }

    public String getIt9() {
        return it9;
    }

    public void setIt9(String it9) {
        this.it9 = it9;
    }

    public String getItemnum() {
        return itemnum;
    }

    public void setItemnum(String itemnum) {
        this.itemnum = itemnum;
    }

    public String getItemsetid() {
        return itemsetid;
    }

    public void setItemsetid(String itemsetid) {
        this.itemsetid = itemsetid;
    }

    public String getItin1() {
        return itin1;
    }

    public void setItin1(String itin1) {
        this.itin1 = itin1;
    }

    public String getItin2() {
        return itin2;
    }

    public void setItin2(String itin2) {
        this.itin2 = itin2;
    }

    public String getItin3() {
        return itin3;
    }

    public void setItin3(String itin3) {
        this.itin3 = itin3;
    }

    public String getItin4() {
        return itin4;
    }

    public void setItin4(String itin4) {
        this.itin4 = itin4;
    }

    public String getItin5() {
        return itin5;
    }

    public void setItin5(String itin5) {
        this.itin5 = itin5;
    }

    public String getItin6() {
        return itin6;
    }

    public void setItin6(String itin6) {
        this.itin6 = itin6;
    }

    public String getItin7() {
        return itin7;
    }

    public void setItin7(String itin7) {
        this.itin7 = itin7;
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

    public Double getLinecost2() {
        return linecost2;
    }

    public void setLinecost2(Double linecost2) {
        this.linecost2 = linecost2;
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

    public String getLotnum() {
        return lotnum;
    }

    public void setLotnum(String lotnum) {
        this.lotnum = lotnum;
    }

    public Long getMatrectransid() {
        return matrectransid;
    }

    public void setMatrectransid(Long matrectransid) {
        this.matrectransid = matrectransid;
    }

    public Long getMatusetransid() {
        return matusetransid;
    }

    public void setMatusetransid(Long matusetransid) {
        this.matusetransid = matusetransid;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getMrlinenum() {
        return mrlinenum;
    }

    public void setMrlinenum(Integer mrlinenum) {
        this.mrlinenum = mrlinenum;
    }

    public String getMrnum() {
        return mrnum;
    }

    public void setMrnum(String mrnum) {
        this.mrnum = mrnum;
    }

    @Override
    public String getOrgid() {
        return orgid;
    }

    @Override
    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public Boolean getOutside() {
        return outside;
    }

    public void setOutside(Boolean outside) {
        this.outside = outside;
    }

    public String getOwnersysid() {
        return ownersysid;
    }

    public void setOwnersysid(String ownersysid) {
        this.ownersysid = ownersysid;
    }

    public String getPackingslipnum() {
        return packingslipnum;
    }

    public void setPackingslipnum(String packingslipnum) {
        this.packingslipnum = packingslipnum;
    }

    public Double getPhyscnt() {
        return physcnt;
    }

    public void setPhyscnt(Double physcnt) {
        this.physcnt = physcnt;
    }

    public Integer getPolinenum() {
        return polinenum;
    }

    public void setPolinenum(Integer polinenum) {
        this.polinenum = polinenum;
    }

    public String getPonum() {
        return ponum;
    }

    public void setPonum(String ponum) {
        this.ponum = ponum;
    }

    public Integer getPorevisionnum() {
        return porevisionnum;
    }

    public void setPorevisionnum(Integer porevisionnum) {
        this.porevisionnum = porevisionnum;
    }

    public Double getQtyrequested() {
        return qtyrequested;
    }

    public void setQtyrequested(Double qtyrequested) {
        this.qtyrequested = qtyrequested;
    }

    public Double getQtyreturned() {
        return qtyreturned;
    }

    public void setQtyreturned(Double qtyreturned) {
        this.qtyreturned = qtyreturned;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getRefwo() {
        return refwo;
    }

    public void setRefwo(String refwo) {
        this.refwo = refwo;
    }

    public Boolean getRollup() {
        return rollup;
    }

    public void setRollup(Boolean rollup) {
        this.rollup = rollup;
    }

    public String getRotassetnum() {
        return rotassetnum;
    }

    public void setRotassetnum(String rotassetnum) {
        this.rotassetnum = rotassetnum;
    }

    public String getSendersysid() {
        return sendersysid;
    }

    public void setSendersysid(String sendersysid) {
        this.sendersysid = sendersysid;
    }

    @Override
    public String getSiteid() {
        return siteid;
    }

    @Override
    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getSourcesysid() {
        return sourcesysid;
    }

    public void setSourcesysid(String sourcesysid) {
        this.sourcesysid = sourcesysid;
    }

    public Boolean getSparepartadded() {
        return sparepartadded;
    }

    public void setSparepartadded(Boolean sparepartadded) {
        this.sparepartadded = sparepartadded;
    }

    public String getStoreloc() {
        return storeloc;
    }

    public void setStoreloc(String storeloc) {
        this.storeloc = storeloc;
    }

    public String getTositeid() {
        return tositeid;
    }

    public void setTositeid(String tositeid) {
        this.tositeid = tositeid;
    }

    public Date getTransdate() {
        return transdate;
    }

    public void setTransdate(Date transdate) {
        this.transdate = transdate;
    }

    public Double getUnitcost() {
        return unitcost;
    }

    public void setUnitcost(Double unitcost) {
        this.unitcost = unitcost;
    }




    public Long showMaxUniqueIDValue() {
        return matusetransid;
    }


}

package com.app.jfinal.service.workorder.model;

import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowTable;

import java.util.Date;

/**
 * Labtrans <br>
 *
 * @author 蒋カイセキ    Japan-Tokyo  2017-08-10 18:26:14<br>
 * ブログ http://shoukaiseki.blog.163.com/<br>
 * E-メール jiang28555@Gmail.com<br>
 **/
@SnowTable(maxObjecxtName = "LABTRANS",maxSequenceName ="LABTRANSSEQ",maxEntityName = "LABTRANS",maxUniqueIDName = "LABTRANSID")
public class Labtrans extends BaseModel{

    /**
     *班组
     **/
    private String amcrew;


    /**
     *班组类型
     **/
    private String amcrewtype;


    /**
     *Anywhere 引用标识
     **/
    private Long anywhererefid;


    /**
     *资产
     **/
    private String assetnum;


    /**
     *合同
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
     *输入人
     **/
    private String enterby;


    /**
     *输入日期
     **/
    private Date enterdate;


    /**
     *作为任务输入
     **/
    private Boolean enteredastask;


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
     *结束日期
     **/
    private Date finishdateentered;


    /**
     *开始日期时间
     **/
    private Date finishdatetime;


    /**
     *结束时间
     **/
    private Date finishtimeentered;


    /**
     *已批准
     **/
    private Boolean genapprservreceipt;


    /**
     *GL 贷方科目
     **/
    private String glcreditacct;


    /**
     *GL 借方科目
     **/
    private String gldebitacct;


    /**
     *发票行
     **/
    private Integer invoicelinenum;


    /**
     *发票
     **/
    private String invoicenum;


    /**
     *员工
     **/
    private String laborcode;


    /**
     *标识
     **/
    private Long labtransid;


    /**
     *行成本
     **/
    private Double linecost;


    /**
     *加班费代码
     **/
    private Double linecost2;


    /**
     *位置
     **/
    private String location;


    /**
     *备忘录
     **/
    private String memo;


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
     *按接收日期记录
     **/
    private Date paymenttransdate;


    /**
     *费率
     **/
    private Double payrate;


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
     *职位
     **/
    private String position;


    /**
     *加班费代码
     **/
    private String premiumpaycode;


    /**
     *加班费时数
     **/
    private Double premiumpayhours;


    /**
     *加班费比率
     **/
    private Double premiumpayrate;


    /**
     *加班费率类型
     **/
    private String premiumpayratetype;


    /**
     *活动
     **/
    private String refwo;


    /**
     *常规时数
     **/
    private Double regularhrs;


    /**
     *修订
     **/
    private Integer revisionnum;


    /**
     *累计
     **/
    private Boolean rollup;


    /**
     *发送者系统标识
     **/
    private String sendersysid;


    /**
     *服务接收标识
     **/
    private Long servrectransid;


    /**
     *地点
     **/
    private String siteid;


    /**
     *技能级别
     **/
    private String skilllevel;


    /**
     *源系统标识
     **/
    private String sourcesysid;


    /**
     *开始日期
     **/
    private Date startdateentered;


    /**
     *开始日期时间
     **/
    private Date startdatetime;


    /**
     *开始时间
     **/
    private Date starttimeentered;


    /**
     *凭单类
     **/
    private String ticketclass;


    /**
     *凭单
     **/
    private String ticketid;


    /**
     *计时器状态
     **/
    private String timerstatus;


    /**
     *交易日期
     **/
    private Date transdate;


    /**
     *类型
     **/
    private String transtype;


    /**
     *供应商
     **/
    private String vendor;

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

    public String getEnterby() {
        return enterby;
    }

    public void setEnterby(String enterby) {
        this.enterby = enterby;
    }

    public Date getEnterdate() {
        return enterdate;
    }

    public void setEnterdate(Date enterdate) {
        this.enterdate = enterdate;
    }

    public Boolean getEnteredastask() {
        return enteredastask;
    }

    public void setEnteredastask(Boolean enteredastask) {
        this.enteredastask = enteredastask;
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

    public Date getFinishdateentered() {
        return finishdateentered;
    }

    public void setFinishdateentered(Date finishdateentered) {
        this.finishdateentered = finishdateentered;
    }

    public Date getFinishdatetime() {
        return finishdatetime;
    }

    public void setFinishdatetime(Date finishdatetime) {
        this.finishdatetime = finishdatetime;
    }

    public Date getFinishtimeentered() {
        return finishtimeentered;
    }

    public void setFinishtimeentered(Date finishtimeentered) {
        this.finishtimeentered = finishtimeentered;
    }

    public Boolean getGenapprservreceipt() {
        return genapprservreceipt;
    }

    public void setGenapprservreceipt(Boolean genapprservreceipt) {
        this.genapprservreceipt = genapprservreceipt;
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

    public Integer getInvoicelinenum() {
        return invoicelinenum;
    }

    public void setInvoicelinenum(Integer invoicelinenum) {
        this.invoicelinenum = invoicelinenum;
    }

    public String getInvoicenum() {
        return invoicenum;
    }

    public void setInvoicenum(String invoicenum) {
        this.invoicenum = invoicenum;
    }

    public String getLaborcode() {
        return laborcode;
    }

    public void setLaborcode(String laborcode) {
        this.laborcode = laborcode;
    }

    public Long getLabtransid() {
        return labtransid;
    }

    public void setLabtransid(Long labtransid) {
        this.labtransid = labtransid;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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

    public Date getPaymenttransdate() {
        return paymenttransdate;
    }

    public void setPaymenttransdate(Date paymenttransdate) {
        this.paymenttransdate = paymenttransdate;
    }

    public Double getPayrate() {
        return payrate;
    }

    public void setPayrate(Double payrate) {
        this.payrate = payrate;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPremiumpaycode() {
        return premiumpaycode;
    }

    public void setPremiumpaycode(String premiumpaycode) {
        this.premiumpaycode = premiumpaycode;
    }

    public Double getPremiumpayhours() {
        return premiumpayhours;
    }

    public void setPremiumpayhours(Double premiumpayhours) {
        this.premiumpayhours = premiumpayhours;
    }

    public Double getPremiumpayrate() {
        return premiumpayrate;
    }

    public void setPremiumpayrate(Double premiumpayrate) {
        this.premiumpayrate = premiumpayrate;
    }

    public String getPremiumpayratetype() {
        return premiumpayratetype;
    }

    public void setPremiumpayratetype(String premiumpayratetype) {
        this.premiumpayratetype = premiumpayratetype;
    }

    public String getRefwo() {
        return refwo;
    }

    public void setRefwo(String refwo) {
        this.refwo = refwo;
    }

    public Double getRegularhrs() {
        return regularhrs;
    }

    public void setRegularhrs(Double regularhrs) {
        this.regularhrs = regularhrs;
    }

    public Integer getRevisionnum() {
        return revisionnum;
    }

    public void setRevisionnum(Integer revisionnum) {
        this.revisionnum = revisionnum;
    }

    public Boolean getRollup() {
        return rollup;
    }

    public void setRollup(Boolean rollup) {
        this.rollup = rollup;
    }

    public String getSendersysid() {
        return sendersysid;
    }

    public void setSendersysid(String sendersysid) {
        this.sendersysid = sendersysid;
    }

    public Long getServrectransid() {
        return servrectransid;
    }

    public void setServrectransid(Long servrectransid) {
        this.servrectransid = servrectransid;
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

    public String getSourcesysid() {
        return sourcesysid;
    }

    public void setSourcesysid(String sourcesysid) {
        this.sourcesysid = sourcesysid;
    }

    public Date getStartdateentered() {
        return startdateentered;
    }

    public void setStartdateentered(Date startdateentered) {
        this.startdateentered = startdateentered;
    }

    public Date getStartdatetime() {
        return startdatetime;
    }

    public void setStartdatetime(Date startdatetime) {
        this.startdatetime = startdatetime;
    }

    public Date getStarttimeentered() {
        return starttimeentered;
    }

    public void setStarttimeentered(Date starttimeentered) {
        this.starttimeentered = starttimeentered;
    }

    public String getTicketclass() {
        return ticketclass;
    }

    public void setTicketclass(String ticketclass) {
        this.ticketclass = ticketclass;
    }

    public String getTicketid() {
        return ticketid;
    }

    public void setTicketid(String ticketid) {
        this.ticketid = ticketid;
    }

    public String getTimerstatus() {
        return timerstatus;
    }

    public void setTimerstatus(String timerstatus) {
        this.timerstatus = timerstatus;
    }

    public Date getTransdate() {
        return transdate;
    }

    public void setTransdate(Date transdate) {
        this.transdate = transdate;
    }

    public String getTranstype() {
        return transtype;
    }

    public void setTranstype(String transtype) {
        this.transtype = transtype;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }



    public Long showMaxUniqueIDValue() {
        return labtransid;
    }


}

package com.app.jfinal.service.lookup.model;

import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowTable;

import java.util.Date;

/**
 * 人员表
 * 
 * @author zhangfei
 * 
 */
@SnowTable(maxObjecxtName = "PERSON")
public class Person extends BaseModel {




    /**
     *接受电子邮件
     **/
    private Boolean acceptingwfmail;


    /**
     *地址
     **/
    private String addressline1;


    /**
     *城市
     **/
    private String addressline2;


    /**
     *省/直辖市/自治区
     **/
    private String addressline3;


    /**
     *收款人地址
     **/
    private String billtoaddress;


    /**
     *出生日期
     **/
    private Date birthdate;


    /**
     *日历类型
     **/
    private String caltype;


    /**
     *城市
     **/
    private String city;


    /**
     *国家或地区
     **/
    private String country;


    /**
     *国家或地区
     **/
    private String county;


    /**
     *工序
     **/
    private String da_process;


    /**
     *工作流任务分配代表
     **/
    private String delegate;


    /**
     *代表开始日期
     **/
    private Date delegatefromdate;


    /**
     *委任职务
     **/
    private Date delegatetodate;


    /**
     *部门
     **/
    private String department;


    /**
     *电子邮件格式
     **/
    private Integer deviceclass;


    /**
     *用户缺省应用程序
     **/
    private String dfltapp;


    /**
     *名称
     **/
    private String displayname;


    /**
     *交付点
     **/
    private String droppoint;


    /**
     *职员类别
     **/
    private String employeetype;


    /**
     *外部引用标识
     **/
    private String externalrefid;


    /**
     *名
     **/
    private String firstname;


    /**
     *具有详细描述
     **/
    private Boolean hasld;


    /**
     *聘用日期
     **/
    private Date hiredate;


    /**
     *即时消息传递标识
     **/
    private String im_id;


    /**
     *职务代码
     **/
    private String jobcode;


    /**
     *语言代码
     **/
    private String langcode;


    /**
     *语言
     **/
    private String language;


    /**
     *上一次评估
     **/
    private Date lastevaldate;


    /**
     *姓
     **/
    private String lastname;


    /**
     *语言环境
     **/
    private String locale;


    /**
     *人员的位置
     **/
    private String location;


    /**
     *组织
     **/
    private String locationorg;


    /**
     *人员的地点
     **/
    private String locationsite;


    /**
     *服务请求的缺省位置
     **/
    private Boolean loctoservreq;


    /**
     *下一次评估
     **/
    private Date nextevaldate;


    /**
     *人员组
     **/
    private String ownergroup;


    /**
     *所有者系统标识
     **/
    private String ownersysid;


    /**
     *截止日期
     **/
    private String pcardexpdate;


    /**
     *卡号
     **/
    private String pcardnum;


    /**
     *卡类型
     **/
    private String pcardtype;


    /**
     *验证值
     **/
    private String pcardverification;


    /**
     *人员
     **/
    private String personid;


    /**
     *PERSONUID
     **/
    private Long personuid;


    /**
     *邮政编码
     **/
    private String postalcode;


    /**
     *主要
     **/
    private String primarysms;


    /**
     *地区/区域
     **/
    private String regiondistrict;


    /**
     *发送者系统标识
     **/
    private String sendersysid;


    /**
     *收货地址
     **/
    private String shiptoaddress;


    /**
     *源系统标识
     **/
    private String sourcesysid;


    /**
     *省/直辖市/自治区
     **/
    private String stateprovince;


    /**
     *状态
     **/
    private String status;


    /**
     *状态日期
     **/
    private Date statusdate;


    /**
     *主管人
     **/
    private String supervisor;


    /**
     *终止日期
     **/
    private Date terminationdate;


    /**
     *时区
     **/
    private String timezone;


    /**
     *头衔
     **/
    private String title;


    /**
     *电子商务异常通知
     **/
    private String transemailelection;


    /**
     *VIP
     **/
    private Integer vip;


    /**
     *工作流电子邮件通知
     **/
    private String wfmailelection;


    /**
     *缺省工单优先级
     **/
    private Integer wopriority;


    public Boolean getAcceptingwfmail() {
        return acceptingwfmail;
    }

    public void setAcceptingwfmail(Boolean acceptingwfmail) {
        this.acceptingwfmail = acceptingwfmail;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    public String getAddressline3() {
        return addressline3;
    }

    public void setAddressline3(String addressline3) {
        this.addressline3 = addressline3;
    }

    public String getBilltoaddress() {
        return billtoaddress;
    }

    public void setBilltoaddress(String billtoaddress) {
        this.billtoaddress = billtoaddress;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getCaltype() {
        return caltype;
    }

    public void setCaltype(String caltype) {
        this.caltype = caltype;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getDa_process() {
        return da_process;
    }

    public void setDa_process(String da_process) {
        this.da_process = da_process;
    }

    public String getDelegate() {
        return delegate;
    }

    public void setDelegate(String delegate) {
        this.delegate = delegate;
    }

    public Date getDelegatefromdate() {
        return delegatefromdate;
    }

    public void setDelegatefromdate(Date delegatefromdate) {
        this.delegatefromdate = delegatefromdate;
    }

    public Date getDelegatetodate() {
        return delegatetodate;
    }

    public void setDelegatetodate(Date delegatetodate) {
        this.delegatetodate = delegatetodate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getDeviceclass() {
        return deviceclass;
    }

    public void setDeviceclass(Integer deviceclass) {
        this.deviceclass = deviceclass;
    }

    public String getDfltapp() {
        return dfltapp;
    }

    public void setDfltapp(String dfltapp) {
        this.dfltapp = dfltapp;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getDroppoint() {
        return droppoint;
    }

    public void setDroppoint(String droppoint) {
        this.droppoint = droppoint;
    }

    public String getEmployeetype() {
        return employeetype;
    }

    public void setEmployeetype(String employeetype) {
        this.employeetype = employeetype;
    }

    public String getExternalrefid() {
        return externalrefid;
    }

    public void setExternalrefid(String externalrefid) {
        this.externalrefid = externalrefid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Boolean getHasld() {
        return hasld;
    }

    public void setHasld(Boolean hasld) {
        this.hasld = hasld;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getIm_id() {
        return im_id;
    }

    public void setIm_id(String im_id) {
        this.im_id = im_id;
    }

    public String getJobcode() {
        return jobcode;
    }

    public void setJobcode(String jobcode) {
        this.jobcode = jobcode;
    }

    public String getLangcode() {
        return langcode;
    }

    public void setLangcode(String langcode) {
        this.langcode = langcode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getLastevaldate() {
        return lastevaldate;
    }

    public void setLastevaldate(Date lastevaldate) {
        this.lastevaldate = lastevaldate;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationorg() {
        return locationorg;
    }

    public void setLocationorg(String locationorg) {
        this.locationorg = locationorg;
    }

    public String getLocationsite() {
        return locationsite;
    }

    public void setLocationsite(String locationsite) {
        this.locationsite = locationsite;
    }

    public Boolean getLoctoservreq() {
        return loctoservreq;
    }

    public void setLoctoservreq(Boolean loctoservreq) {
        this.loctoservreq = loctoservreq;
    }

    public Date getNextevaldate() {
        return nextevaldate;
    }

    public void setNextevaldate(Date nextevaldate) {
        this.nextevaldate = nextevaldate;
    }

    public String getOwnergroup() {
        return ownergroup;
    }

    public void setOwnergroup(String ownergroup) {
        this.ownergroup = ownergroup;
    }

    public String getOwnersysid() {
        return ownersysid;
    }

    public void setOwnersysid(String ownersysid) {
        this.ownersysid = ownersysid;
    }

    public String getPcardexpdate() {
        return pcardexpdate;
    }

    public void setPcardexpdate(String pcardexpdate) {
        this.pcardexpdate = pcardexpdate;
    }

    public String getPcardnum() {
        return pcardnum;
    }

    public void setPcardnum(String pcardnum) {
        this.pcardnum = pcardnum;
    }

    public String getPcardtype() {
        return pcardtype;
    }

    public void setPcardtype(String pcardtype) {
        this.pcardtype = pcardtype;
    }

    public String getPcardverification() {
        return pcardverification;
    }

    public void setPcardverification(String pcardverification) {
        this.pcardverification = pcardverification;
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public Long getPersonuid() {
        return personuid;
    }

    public void setPersonuid(Long personuid) {
        this.personuid = personuid;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getPrimarysms() {
        return primarysms;
    }

    public void setPrimarysms(String primarysms) {
        this.primarysms = primarysms;
    }

    public String getRegiondistrict() {
        return regiondistrict;
    }

    public void setRegiondistrict(String regiondistrict) {
        this.regiondistrict = regiondistrict;
    }

    public String getSendersysid() {
        return sendersysid;
    }

    public void setSendersysid(String sendersysid) {
        this.sendersysid = sendersysid;
    }

    public String getShiptoaddress() {
        return shiptoaddress;
    }

    public void setShiptoaddress(String shiptoaddress) {
        this.shiptoaddress = shiptoaddress;
    }

    public String getSourcesysid() {
        return sourcesysid;
    }

    public void setSourcesysid(String sourcesysid) {
        this.sourcesysid = sourcesysid;
    }

    public String getStateprovince() {
        return stateprovince;
    }

    public void setStateprovince(String stateprovince) {
        this.stateprovince = stateprovince;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStatusdate() {
        return statusdate;
    }

    public void setStatusdate(Date statusdate) {
        this.statusdate = statusdate;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public Date getTerminationdate() {
        return terminationdate;
    }

    public void setTerminationdate(Date terminationdate) {
        this.terminationdate = terminationdate;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTransemailelection() {
        return transemailelection;
    }

    public void setTransemailelection(String transemailelection) {
        this.transemailelection = transemailelection;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public String getWfmailelection() {
        return wfmailelection;
    }

    public void setWfmailelection(String wfmailelection) {
        this.wfmailelection = wfmailelection;
    }

    public Integer getWopriority() {
        return wopriority;
    }

    public void setWopriority(Integer wopriority) {
        this.wopriority = wopriority;
    }
}

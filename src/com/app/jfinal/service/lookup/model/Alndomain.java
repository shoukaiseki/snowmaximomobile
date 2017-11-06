package com.app.jfinal.service.lookup.model;

import com.jfinal.plugin.activerecord.Record;
import org.shoukaiseki.jfinal.kernel.common.BaseModel;

/**
 * Alndomain <br>
 *
 * @author 蒋カイセキ    Japan-Tokyo  2017-06-07 09:19:10<br>
 *         ブログ http://shoukaiseki.blog.163.com/<br>
 *         E-メール jiang28555@Gmail.com<br>
 */

public class Alndomain extends BaseModel {




    /**
     *字母数字域标识
     **/
    private Long alndomainid;


    /**
     *描述
     **/
    private String description;


    /**
     *域
     **/
    private String domainid;


    /**
     *组织
     **/
    private String orgid;


    /**
     *地点
     **/
    private String siteid;


    /**
     *值
     **/
    private String value;


    /**
     *值标识
     **/
    private String valueid;

    public Long getAlndomainid() {
        return alndomainid;
    }

    public void setAlndomainid(Long alndomainid) {
        this.alndomainid = alndomainid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDomainid() {
        return domainid;
    }

    public void setDomainid(String domainid) {
        this.domainid = domainid;
    }

    @Override
    public String getOrgid() {
        return orgid;
    }

    @Override
    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    @Override
    public String getSiteid() {
        return siteid;
    }

    @Override
    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueid() {
        return valueid;
    }

    public void setValueid(String valueid) {
        this.valueid = valueid;
    }
}

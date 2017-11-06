package com.app.jfinal.service.lookup.model;

import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowTable;

/**
 * Da_department <br>
 *
 * @author 蒋カイセキ    Japan-Tokyo  2017-08-14 16:00:19<br>
 * ブログ http://shoukaiseki.blog.163.com/<br>
 * E-メール jiang28555@Gmail.com<br>
 **/

@SnowTable(maxObjecxtName = "DA_DEPARTMENT",maxSequenceName ="DA_DEPARTMENTIDSEQ",maxEntityName = "DA_DEPARTMENT")
public class Da_department extends BaseModel{


    /**
     *序号
     **/
    private Long da_departmentid;


    /**
     *部门编号
     **/
    private String da_depnum;


    /**
     *部门负责人
     **/
    private String da_fzperson;


    /**
     *状态
     **/
    private String da_status;


    /**
     *部门名称
     **/
    private String description;


    /**
     *Hasld
     **/
    private Boolean hasld;


    /**
     *是否生产
     **/
    private Boolean issc;


    /**
     *是否巡检
     **/
    private Boolean isxj;


    /**
     *是否资产
     **/
    private Boolean iszc;


    /**
     *组织
     **/
    private String orgid;


    /**
     *父级部门编号
     **/
    private String parentdepnum;


    /**
     *地点
     **/
    private String siteid;

    public Long getDa_departmentid() {
        return da_departmentid;
    }

    public void setDa_departmentid(Long da_departmentid) {
        this.da_departmentid = da_departmentid;
    }

    public String getDa_depnum() {
        return da_depnum;
    }

    public void setDa_depnum(String da_depnum) {
        this.da_depnum = da_depnum;
    }

    public String getDa_fzperson() {
        return da_fzperson;
    }

    public void setDa_fzperson(String da_fzperson) {
        this.da_fzperson = da_fzperson;
    }

    public String getDa_status() {
        return da_status;
    }

    public void setDa_status(String da_status) {
        this.da_status = da_status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getHasld() {
        return hasld;
    }

    public void setHasld(Boolean hasld) {
        this.hasld = hasld;
    }

    public Boolean getIssc() {
        return issc;
    }

    public void setIssc(Boolean issc) {
        this.issc = issc;
    }

    public Boolean getIsxj() {
        return isxj;
    }

    public void setIsxj(Boolean isxj) {
        this.isxj = isxj;
    }

    public Boolean getIszc() {
        return iszc;
    }

    public void setIszc(Boolean iszc) {
        this.iszc = iszc;
    }

    @Override
    public String getOrgid() {
        return orgid;
    }

    @Override
    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getParentdepnum() {
        return parentdepnum;
    }

    public void setParentdepnum(String parentdepnum) {
        this.parentdepnum = parentdepnum;
    }

    @Override
    public String getSiteid() {
        return siteid;
    }

    @Override
    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }


}

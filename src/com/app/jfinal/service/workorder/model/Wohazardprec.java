package com.app.jfinal.service.workorder.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowField;
import org.shoukaiseki.jfinal.kernel.common.SnowTable;

import java.util.HashMap;

/**
 * Wohazardprec <br>
 *
 * @author 蒋カイセキ    Japan-Tokyo  2017-08-23 10:24:01<br>
 * ブログ http://shoukaiseki.blog.163.com/<br>
 * E-メール jiang28555@Gmail.com<br>
 **/
@SnowTable(maxObjecxtName = "WOHAZARDPREC",maxSequenceName ="WOHAZARDPRECSEQ",maxEntityName = "WOHAZARDPREC",maxUniqueIDName = "WOHAZARDPRECID")
public class Wohazardprec extends BaseModel{



    /**
     *危险
     **/
    private String hazardid;


    /**
     *组织
     **/
    @SnowField(isUpdateIgnore = true)
    private String orgid;


    /**
     *预防措施
     **/
    private String precautionid;


    /**
     *地点
     **/
    @SnowField(isUpdateIgnore = true)
    private String siteid;


    /**
     *WOHAZARDPRECID
     **/
    @SnowField(isPrimary = true)
    private Long wohazardprecid;


    /**
     *工单
     **/
    @SnowField(isUpdateIgnore = true)
    private String wonum;


    /**
     *安全源
     **/
    private String wosafetydatasource;


    public String getHazardid() {
        return hazardid;
    }

    public void setHazardid(String hazardid) {
        this.hazardid = hazardid;
    }

    @Nullable
    @Override
    public String getOrgid() {
        return orgid;
    }

    @Override
    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getPrecautionid() {
        return precautionid;
    }

    public void setPrecautionid(String precautionid) {
        this.precautionid = precautionid;
    }

    @Nullable
    @Override
    public String getSiteid() {
        return siteid;
    }

    @Override
    public void setSiteid(String siteid) {
        this.siteid = siteid;
    }

    public Long getWohazardprecid() {
        return wohazardprecid;
    }

    public void setWohazardprecid(Long wohazardprecid) {
        this.wohazardprecid = wohazardprecid;
    }

    public String getWonum() {
        return wonum;
    }

    public void setWonum(String wonum) {
        this.wonum = wonum;
    }

    public String getWosafetydatasource() {
        return wosafetydatasource;
    }

    public void setWosafetydatasource(String wosafetydatasource) {
        this.wosafetydatasource = wosafetydatasource;
    }


    @NotNull
    @Override
    public HashMap<String, Object> ifNullDefaultValueMap(){
        HashMap<String, Object> defvalmap=super.ifNullDefaultValueMap();
        defvalmap.put("ORGID", "&ORGID&");
        defvalmap.put("SITEID", "&SITEID&");
        defvalmap.put("WOSAFETYDATASOURCE","WO");

        return defvalmap;
    }
}

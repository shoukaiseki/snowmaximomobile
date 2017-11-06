package com.app.jfinal.service.workorder.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowField;
import org.shoukaiseki.jfinal.kernel.common.SnowTable;

import java.util.HashMap;

/**
 * Woprecaution <br>
 *
 * @author 蒋カイセキ    Japan-Tokyo  2017-08-23 10:48:34<br>
 * ブログ http://shoukaiseki.blog.163.com/<br>
 * E-メール jiang28555@Gmail.com<br>
 **/
@SnowTable(maxObjecxtName = "WOPRECAUTION",maxSequenceName ="WOPRECAUTIONSEQ",maxEntityName = "WOPRECAUTION",maxUniqueIDName = "WOPRECAUTIONID")
public class Woprecaution extends BaseModel{



    /**
     *描述
     **/
    private String description;


    /**
     *语言代码
     **/
    @SnowField(isUpdateIgnore = true)
    private String langcode;


    /**
     *组织
     **/
    @SnowField(isUpdateIgnore = true)
    private String orgid;



    /**
     *预防措施标识
     **/
    @SnowField(isUpdateIgnore = true)
    private String precautionid;


    /**
     *地点
     **/
    @SnowField(isUpdateIgnore = true)
    private String siteid;


    /**
     *工单
     **/
    @SnowField(isUpdateIgnore = true)
    private String wonum;


    /**
     *工单预防措施标识
     **/
    @SnowField(isPrimary = true)
    private Long woprecautionid;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLangcode() {
        return langcode;
    }

    public void setLangcode(String langcode) {
        this.langcode = langcode;
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

    public String getWonum() {
        return wonum;
    }

    public void setWonum(String wonum) {
        this.wonum = wonum;
    }

    public Long getWoprecautionid() {
        return woprecautionid;
    }

    public void setWoprecautionid(Long woprecautionid) {
        this.woprecautionid = woprecautionid;
    }

    @NotNull
    @Override
    public HashMap<String, Object> ifNullDefaultValueMap() {
        HashMap<String, Object> defvalmap=super.ifNullDefaultValueMap();
        defvalmap.put("ORGID", "&ORGID&");
        defvalmap.put("SITEID", "&SITEID&");
        defvalmap.put("WOSAFETYDATASOURCE","WO");
        defvalmap.put("LANGCODE","ZH");

        return defvalmap;

    }
}

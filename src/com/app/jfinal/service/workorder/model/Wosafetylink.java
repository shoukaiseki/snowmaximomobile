package com.app.jfinal.service.workorder.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowField;
import org.shoukaiseki.jfinal.kernel.common.SnowTable;

import java.util.Date;
import java.util.HashMap;

/**
 * com.app.jfinal.service.workorder.model.WosafetylinkView <br>
 *
 * @author 蒋カイセキ    Japan-Tokyo  2017-08-21 16:51:18<br>
 * ブログ http://shoukaiseki.blog.163.com/<br>
 * E-メール jiang28555@Gmail.com<br>
 **/
@SnowTable(maxObjecxtName = "WOSAFETYLINK",maxSequenceName ="WOSAFETYLINKSEQ",maxEntityName = "WOSAFETYLINK",maxUniqueIDName = "WOSAFETYLINKID")
public class Wosafetylink extends BaseModel{



    /**
     *应用序列
     **/
    @SnowField(isUpdateIgnore = true)
    private Integer applyseq;


    /**
     *关联资产
     **/
    private String assetnum;


    /**
     *是否执行？
     **/
    @SnowField(isUpdateIgnore = true)
    private Boolean da_iszx;


    /**
     *危险
     **/
    private String hazardid;


    /**
     *相关位置
     **/
    private String location;


    /**
     *组织
     **/
    @SnowField(isUpdateIgnore = true)
    private String orgid;


    /**
     *删除序列
     **/
    @SnowField(isUpdateIgnore = true)
    private Integer removeseq;


    /**
     *地点
     **/
    @SnowField(isUpdateIgnore = true)
    private String siteid;


    /**
     *隔离
     **/
    private String tagoutid;


    /**
     *工单
     **/
    @SnowField(isUpdateIgnore = true)
    private String wonum;


    /**
     *安全源
     **/
    @SnowField(isUpdateIgnore = true)
    private String wosafetydatasource;


    /**
     *工单链接标识
     **/
    private Long wosafetylinkid;


    /**
     *wosl01
     **/
    @SnowField(isUpdateIgnore = true)
    private String wosl01;


    /**
     *wosl02
     **/
    @SnowField(isUpdateIgnore = true)
    private String wosl02;


    /**
     *WOSL03
     **/
    @SnowField(isUpdateIgnore = true)
    private Date wosl03;


    /**
     *wosl04
     **/
    @SnowField(isUpdateIgnore = true)
    private Double wosl04;


    /**
     *wosl05
     **/
    @SnowField(isUpdateIgnore = true)
    private Integer wosl05;

    public Integer getApplyseq() {
        return applyseq;
    }

    public void setApplyseq(Integer applyseq) {
        this.applyseq = applyseq;
    }

    public String getAssetnum() {
        return assetnum;
    }

    public void setAssetnum(String assetnum) {
        this.assetnum = assetnum;
    }

    public Boolean getDa_iszx() {
        return da_iszx;
    }

    public void setDa_iszx(Boolean da_iszx) {
        this.da_iszx = da_iszx;
    }

    public String getHazardid() {
        return hazardid;
    }

    public void setHazardid(String hazardid) {
        this.hazardid = hazardid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public Integer getRemoveseq() {
        return removeseq;
    }

    public void setRemoveseq(Integer removeseq) {
        this.removeseq = removeseq;
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

    public String getTagoutid() {
        return tagoutid;
    }

    public void setTagoutid(String tagoutid) {
        this.tagoutid = tagoutid;
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

    public Long getWosafetylinkid() {
        return wosafetylinkid;
    }

    public void setWosafetylinkid(Long wosafetylinkid) {
        this.wosafetylinkid = wosafetylinkid;
    }

    public String getWosl01() {
        return wosl01;
    }

    public void setWosl01(String wosl01) {
        this.wosl01 = wosl01;
    }

    public String getWosl02() {
        return wosl02;
    }

    public void setWosl02(String wosl02) {
        this.wosl02 = wosl02;
    }

    public Date getWosl03() {
        return wosl03;
    }

    public void setWosl03(Date wosl03) {
        this.wosl03 = wosl03;
    }

    public Double getWosl04() {
        return wosl04;
    }

    public void setWosl04(Double wosl04) {
        this.wosl04 = wosl04;
    }

    public Integer getWosl05() {
        return wosl05;
    }

    public void setWosl05(Integer wosl05) {
        this.wosl05 = wosl05;
    }


    @NotNull
    public HashMap<String, Object> ifNullDefaultValueMap(){
        HashMap<String, Object> defvalmap=super.ifNullDefaultValueMap();
        defvalmap.put("ORGID", "&ORGID&");
        defvalmap.put("SITEID", "&SITEID&");
        defvalmap.put("WOSAFETYDATASOURCE","WO");

        return defvalmap;
    }

}

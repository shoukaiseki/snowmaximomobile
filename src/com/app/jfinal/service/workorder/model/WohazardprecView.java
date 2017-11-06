package com.app.jfinal.service.workorder.model;

import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowField;
import org.shoukaiseki.jfinal.kernel.common.SnowTable;

/**
 * WohazardprecView <br>
 *
 * @author 蒋カイセキ    Japan-Tokyo  2017-08-10 12:16:39<br>
 * ブログ http://shoukaiseki.blog.163.com/<br>
 * E-メール jiang28555@Gmail.com<br>
 **/
@SnowTable(maxObjecxtName = "WOHAZARDPREC",maxSequenceName = "WOHAZARDPRECSEQ",maxUniqueIDName = "WOHAZARDPRECID")
public class WohazardprecView extends BaseModel{


    private Long woprecaution_woprecautionid;

    /**
     * 预防措施描述
     */
    private String woprecaution_description;

    public String getWoprecaution_description() {
        return woprecaution_description;
    }

    public void setWoprecaution_description(String woprecaution_description) {
        this.woprecaution_description = woprecaution_description;
    }

    /**
     *危险
     **/
    private String hazardid;


    /**
     *组织
     **/
    private String orgid;


    /**
     *预防措施
     **/
    private String precautionid;


    /**
     *地点
     **/
    private String siteid;


    /**
     *WOHAZARDPRECID
     **/
    @SnowField(isPrimary = true)
    private Long wohazardprecid;


    /**
     *工单
     **/
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


    public Long getWoprecaution_woprecautionid() {
        return woprecaution_woprecautionid;
    }

    public void setWoprecaution_woprecautionid(Long woprecaution_woprecautionid) {
        this.woprecaution_woprecautionid = woprecaution_woprecautionid;
    }
}

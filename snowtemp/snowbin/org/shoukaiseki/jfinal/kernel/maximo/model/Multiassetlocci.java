package org.shoukaiseki.jfinal.kernel.maximo.model;

import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowTable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/** com.app.jfinal.service.model.Multiassetlocci
 * 多资产,位置
 * @author 蒋カイセキ    Japan-Tokyo  2017年4月7日
 * ブログ http://shoukaiseki.blog.163.com/
 * E-メール jiang28555@Gmail.com
 */
@SnowTable(maxObjecxtName = "MULTIASSETLOCCI",maxSequenceName="MULTIASSETLOCCISEQ",maxUniqueIDName = "MULTIID")
public class Multiassetlocci extends BaseModel{
	//注释
	private String	comments;
	//运行交代
	private String	da_yunxingjiaodai;
	//故障类
	private String	failurecode;
	//风速大于6m/s停机原因
	private String	da_wxyy;
	//功能标签
	private String	featurelabel;
	//终点 Z 偏移量引用目标
	private String	endzoffsetref;
	//起点 Z 偏移量参照目标
	private String	startzoffsetref;
	//终点 Y 偏移量引用目标
	private String	endyoffsetref;
	//是否停运
	private String	da_isty;
	//移动到货柜
	private String	movetobin;
	//目标描述
	private String	targetdesc;
	//起点 Y 偏移量引用目标
	private String	startyoffsetref;
	//终点资产功能标识
	private Long	endassetfeatureid;
	//资产功能标识
	private Long	assetfeatureid;
	//起点资产功能标识
	private Long	startassetfeatureid;
	//检修路线站点
	private Long	routestop;
	//多个标识
	private Long	multiid;
	//故障日期
	private Date	faildate;
	//恢复运行时间
	private Date	da_hfyxsj;
	//停机时间
	private Date	da_gztjsj;
	//结束测量
	private Double	endmeasure;
	//终点偏移量
	private Double	endoffset;
	//终点 Y 偏移量
	private Double	endyoffset;
	//终点 Z 偏移量
	private Double	endzoffset;
	//开始测量
	private Double	startmeasure;
	//起点偏移量
	private Double	startoffset;
	//起点 Y 偏移量
	private Double	startyoffset;
	//起点 Z 偏移量
	private Double	startzoffset;
	//终点基础计量
	private Double	endbasemeasure;
	//起点基础计量
	private Double	startbasemeasure;
	//平均风速m/s
	private Double	da_fengsu;
	//停机小时数（h小时）
	private Double	da_tjxss;
	//停机损失电量
	private Double	da_tjssdl;
	//序号
	private Integer	sequence;
	//修正位置
	private String	da_xzlocation;
	//配置项
	private String	cinum;
	//资产
	private String	assetnum;
	//位置
	private String	location;
	//修正资产
	private String	da_xzassetnum;
	//问题代码
	private String	problemcode;
	//功能
	private String	feature;
	//工作组织
	private String	workorgid;
	//工作地点
	private String	worksiteid;
	//组织
	private String	orgid;
	//地点
	private String	siteid;
	//检修路线
	private String	route;
	//移动到父级
	private String	movetoparent;
	//移动到位置
	private String	movetolocation;
	//记录键
	private String	recordkey;
	//类
	private String	recordclass;
	//语言代码
	private String	langcode;
	//移动到地点
	private String	movetosite;
	//新资产编号
	private String	newassetnum;
	//替换资产地点
	private String	replacementsite;
	//替换资产
	private String	replaceassetnum;
	//新的替换资产号
	private String	newreplaceassetnum;
	//基础计量单位
	private String	basemeasureunitid;
	//终点计量单位
	private String	endmeasureunitid;
	//终点偏移量的单位
	private String	endoffsetunitid;
	//起点计量单位
	private String	startmeasureunitid;
	//起点偏移量的单位
	private String	startoffsetunitid;
	//执行“移动到”操作
	private Boolean	performmoveto;
	//具有详细描述
	private Boolean	hasld;
	//为主要的
	private Boolean	isprimary;
	//标记进展
	private Boolean	progress;
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getDa_yunxingjiaodai() {
		return da_yunxingjiaodai;
	}
	public void setDa_yunxingjiaodai(String da_yunxingjiaodai) {
		this.da_yunxingjiaodai = da_yunxingjiaodai;
	}
	public String getFailurecode() {
		return failurecode;
	}
	public void setFailurecode(String failurecode) {
		this.failurecode = failurecode;
	}
	public String getDa_wxyy() {
		return da_wxyy;
	}
	public void setDa_wxyy(String da_wxyy) {
		this.da_wxyy = da_wxyy;
	}
	public String getFeaturelabel() {
		return featurelabel;
	}
	public void setFeaturelabel(String featurelabel) {
		this.featurelabel = featurelabel;
	}
	public String getEndzoffsetref() {
		return endzoffsetref;
	}
	public void setEndzoffsetref(String endzoffsetref) {
		this.endzoffsetref = endzoffsetref;
	}
	public String getStartzoffsetref() {
		return startzoffsetref;
	}
	public void setStartzoffsetref(String startzoffsetref) {
		this.startzoffsetref = startzoffsetref;
	}
	public String getEndyoffsetref() {
		return endyoffsetref;
	}
	public void setEndyoffsetref(String endyoffsetref) {
		this.endyoffsetref = endyoffsetref;
	}
	public String getDa_isty() {
		return da_isty;
	}
	public void setDa_isty(String da_isty) {
		this.da_isty = da_isty;
	}
	public String getMovetobin() {
		return movetobin;
	}
	public void setMovetobin(String movetobin) {
		this.movetobin = movetobin;
	}
	public String getTargetdesc() {
		return targetdesc;
	}
	public void setTargetdesc(String targetdesc) {
		this.targetdesc = targetdesc;
	}
	public String getStartyoffsetref() {
		return startyoffsetref;
	}
	public void setStartyoffsetref(String startyoffsetref) {
		this.startyoffsetref = startyoffsetref;
	}
	public Long getEndassetfeatureid() {
		return endassetfeatureid;
	}
	public void setEndassetfeatureid(Long endassetfeatureid) {
		this.endassetfeatureid = endassetfeatureid;
	}
	public Long getAssetfeatureid() {
		return assetfeatureid;
	}
	public void setAssetfeatureid(Long assetfeatureid) {
		this.assetfeatureid = assetfeatureid;
	}
	public Long getStartassetfeatureid() {
		return startassetfeatureid;
	}
	public void setStartassetfeatureid(Long startassetfeatureid) {
		this.startassetfeatureid = startassetfeatureid;
	}
	public Long getRoutestop() {
		return routestop;
	}
	public void setRoutestop(Long routestop) {
		this.routestop = routestop;
	}
	public Long getMultiid() {
		return multiid;
	}
	public void setMultiid(Long multiid) {
		this.multiid = multiid;
	}
	public Date getFaildate() {
		return faildate;
	}
	public void setFaildate(Date faildate) {
		this.faildate = faildate;
	}
	public Date getDa_hfyxsj() {
		return da_hfyxsj;
	}
	public void setDa_hfyxsj(Date da_hfyxsj) {
		this.da_hfyxsj = da_hfyxsj;
	}
	public Date getDa_gztjsj() {
		return da_gztjsj;
	}
	public void setDa_gztjsj(Date da_gztjsj) {
		this.da_gztjsj = da_gztjsj;
	}
	public Double getEndmeasure() {
		return endmeasure;
	}
	public void setEndmeasure(Double endmeasure) {
		this.endmeasure = endmeasure;
	}
	public Double getEndoffset() {
		return endoffset;
	}
	public void setEndoffset(Double endoffset) {
		this.endoffset = endoffset;
	}
	public Double getEndyoffset() {
		return endyoffset;
	}
	public void setEndyoffset(Double endyoffset) {
		this.endyoffset = endyoffset;
	}
	public Double getEndzoffset() {
		return endzoffset;
	}
	public void setEndzoffset(Double endzoffset) {
		this.endzoffset = endzoffset;
	}
	public Double getStartmeasure() {
		return startmeasure;
	}
	public void setStartmeasure(Double startmeasure) {
		this.startmeasure = startmeasure;
	}
	public Double getStartoffset() {
		return startoffset;
	}
	public void setStartoffset(Double startoffset) {
		this.startoffset = startoffset;
	}
	public Double getStartyoffset() {
		return startyoffset;
	}
	public void setStartyoffset(Double startyoffset) {
		this.startyoffset = startyoffset;
	}
	public Double getStartzoffset() {
		return startzoffset;
	}
	public void setStartzoffset(Double startzoffset) {
		this.startzoffset = startzoffset;
	}
	public Double getEndbasemeasure() {
		return endbasemeasure;
	}
	public void setEndbasemeasure(Double endbasemeasure) {
		this.endbasemeasure = endbasemeasure;
	}
	public Double getStartbasemeasure() {
		return startbasemeasure;
	}
	public void setStartbasemeasure(Double startbasemeasure) {
		this.startbasemeasure = startbasemeasure;
	}
	public Double getDa_fengsu() {
		return da_fengsu;
	}
	public void setDa_fengsu(Double da_fengsu) {
		this.da_fengsu = da_fengsu;
	}
	public Double getDa_tjxss() {
		return da_tjxss;
	}
	public void setDa_tjxss(Double da_tjxss) {
		this.da_tjxss = da_tjxss;
	}
	public Double getDa_tjssdl() {
		return da_tjssdl;
	}
	public void setDa_tjssdl(Double da_tjssdl) {
		this.da_tjssdl = da_tjssdl;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public String getDa_xzlocation() {
		return da_xzlocation;
	}
	public void setDa_xzlocation(String da_xzlocation) {
		this.da_xzlocation = da_xzlocation;
	}
	public String getCinum() {
		return cinum;
	}
	public void setCinum(String cinum) {
		this.cinum = cinum;
	}
	public String getAssetnum() {
		return assetnum;
	}
	public void setAssetnum(String assetnum) {
		this.assetnum = assetnum;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDa_xzassetnum() {
		return da_xzassetnum;
	}
	public void setDa_xzassetnum(String da_xzassetnum) {
		this.da_xzassetnum = da_xzassetnum;
	}
	public String getProblemcode() {
		return problemcode;
	}
	public void setProblemcode(String problemcode) {
		this.problemcode = problemcode;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public String getWorkorgid() {
		return workorgid;
	}
	public void setWorkorgid(String workorgid) {
		this.workorgid = workorgid;
	}
	public String getWorksiteid() {
		return worksiteid;
	}
	public void setWorksiteid(String worksiteid) {
		this.worksiteid = worksiteid;
	}
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	public String getSiteid() {
		return siteid;
	}
	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getMovetoparent() {
		return movetoparent;
	}
	public void setMovetoparent(String movetoparent) {
		this.movetoparent = movetoparent;
	}
	public String getMovetolocation() {
		return movetolocation;
	}
	public void setMovetolocation(String movetolocation) {
		this.movetolocation = movetolocation;
	}
	public String getRecordkey() {
		return recordkey;
	}
	public void setRecordkey(String recordkey) {
		this.recordkey = recordkey;
	}
	public String getRecordclass() {
		return recordclass;
	}
	public void setRecordclass(String recordclass) {
		this.recordclass = recordclass;
	}
	public String getLangcode() {
		return langcode;
	}
	public void setLangcode(String langcode) {
		this.langcode = langcode;
	}
	public String getMovetosite() {
		return movetosite;
	}
	public void setMovetosite(String movetosite) {
		this.movetosite = movetosite;
	}
	public String getNewassetnum() {
		return newassetnum;
	}
	public void setNewassetnum(String newassetnum) {
		this.newassetnum = newassetnum;
	}
	public String getReplacementsite() {
		return replacementsite;
	}
	public void setReplacementsite(String replacementsite) {
		this.replacementsite = replacementsite;
	}
	public String getReplaceassetnum() {
		return replaceassetnum;
	}
	public void setReplaceassetnum(String replaceassetnum) {
		this.replaceassetnum = replaceassetnum;
	}
	public String getNewreplaceassetnum() {
		return newreplaceassetnum;
	}
	public void setNewreplaceassetnum(String newreplaceassetnum) {
		this.newreplaceassetnum = newreplaceassetnum;
	}
	public String getBasemeasureunitid() {
		return basemeasureunitid;
	}
	public void setBasemeasureunitid(String basemeasureunitid) {
		this.basemeasureunitid = basemeasureunitid;
	}
	public String getEndmeasureunitid() {
		return endmeasureunitid;
	}
	public void setEndmeasureunitid(String endmeasureunitid) {
		this.endmeasureunitid = endmeasureunitid;
	}
	public String getEndoffsetunitid() {
		return endoffsetunitid;
	}
	public void setEndoffsetunitid(String endoffsetunitid) {
		this.endoffsetunitid = endoffsetunitid;
	}
	public String getStartmeasureunitid() {
		return startmeasureunitid;
	}
	public void setStartmeasureunitid(String startmeasureunitid) {
		this.startmeasureunitid = startmeasureunitid;
	}
	public String getStartoffsetunitid() {
		return startoffsetunitid;
	}
	public void setStartoffsetunitid(String startoffsetunitid) {
		this.startoffsetunitid = startoffsetunitid;
	}
	public Boolean getPerformmoveto() {
		return performmoveto;
	}
	public void setPerformmoveto(Boolean performmoveto) {
		this.performmoveto = performmoveto;
	}
	public Boolean getHasld() {
		return hasld;
	}
	public void setHasld(Boolean hasld) {
		this.hasld = hasld;
	}
	public Boolean getIsprimary() {
		return isprimary;
	}
	public void setIsprimary(Boolean isprimary) {
		this.isprimary = isprimary;
	}
	public Boolean getProgress() {
		return progress;
	}
	public void setProgress(Boolean progress) {
		this.progress = progress;
	}


	@Override
	public Long showMaxUniqueIDValue() {
		// TODO Auto-generated method stub
		return getMultiid();
	}
	
	
	@Override
	public HashMap<String, Object> ifNullDefaultValueMap() {
		// TODO Auto-generated method stub
		HashMap<String,Object> defvalmap = super.ifNullDefaultValueMap();
		defvalmap.put("SITEID", "&SITEID&");
		defvalmap.put("ORGID", "&ORGID&");
		defvalmap.put("ISPRIMARY",false);
		defvalmap.put("LANGCODE","ZH");
		defvalmap.put("PERFORMMOVETO",false);
		defvalmap.put("PROGRESS",false);
		defvalmap.put("RECORDCLASS","工单");
		
		return defvalmap;
	}

}

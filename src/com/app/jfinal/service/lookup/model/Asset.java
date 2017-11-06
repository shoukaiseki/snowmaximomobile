package com.app.jfinal.service.lookup.model;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.jfinal.plugin.activerecord.Record;
import org.shoukaiseki.jfinal.kernel.common.BaseModel;
import org.shoukaiseki.jfinal.kernel.common.SnowTable;

@SnowTable(maxObjecxtName = "Asset")
public class Asset extends BaseModel {

	private static final long serialVersionUID = 1L;




	/**
	 *祖代
	 **/
	private String ancestor;


	/**
	 *起始端
	 **/
	private String assetfrom;


	/**
	 *资产
	 **/
	private Long assetid;


	/**
	 *介质
	 **/
	private String assetjz;


	/**
	 *资产
	 **/
	private String assetnum;


	/**
	 *资产标记
	 **/
	private String assettag;


	/**
	 *终止点
	 **/
	private String assetto;


	/**
	 *类型
	 **/
	private String assettype;


	/**
	 *ASSETUID
	 **/
	private Long assetuid;


	/**
	 *自动生成工单
	 **/
	private Boolean autowogen;


	/**
	 *货柜
	 **/
	private String binnum;


	/**
	 *预算
	 **/
	private Double budgetcost;


	/**
	 *日历
	 **/
	private String calnum;


	/**
	 *变更人
	 **/
	private String changeby;


	/**
	 *变更日期
	 **/
	private Date changedate;


	/**
	 *子级
	 **/
	private Boolean children;


	/**
	 *类结构
	 **/
	private String classstructureid;


	/**
	 *条件代码
	 **/
	private String conditioncode;


	/**
	 *档案编号
	 **/
	private String da_archivesnum;


	/**
	 *备注
	 **/
	private String da_beizhu;


	/**
	 *子分类
	 **/
	private String da_cclassstructure;


	/**
	 *颜色转变原因
	 **/
	private String da_coloractyy;


	/**
	 *颜色分类
	 **/
	private String da_colorclassify;


	/**
	 *产品编号
	 **/
	private String da_cpbh;


	/**
	 *创建日期
	 **/
	private Date da_createdate;


	/**
	 *创建人
	 **/
	private String da_createperson;


	/**
	 *操作条件-最高工作压力MPa
	 **/
	private String da_ctgy;


	/**
	 *操作条件-温度℃
	 **/
	private String da_ctwd;


	/**
	 *备注
	 **/
	private String da_cw_bz;


	/**
	 *发票规格
	 **/
	private String da_cw_fpgg;


	/**
	 *发票号
	 **/
	private String da_cw_fph;


	/**
	 *发票名称
	 **/
	private String da_cw_fpmc;


	/**
	 *购买单位
	 **/
	private String da_cw_gmdw;


	/**
	 *合同号
	 **/
	private String da_cw_hth;


	/**
	 *金额（不含税）
	 **/
	private Double da_cw_price;


	/**
	 *凭证号
	 **/
	private String da_cw_pzh;


	/**
	 *运行周期（小时）
	 **/
	private Long da_cycle;


	/**
	 *部门编码
	 **/
	private String da_depnum;


	/**
	 *动/静设备
	 **/
	private String da_dorj;


	/**
	 *服务设备名称/管线号
	 **/
	private String da_fwname;


	/**
	 *规使用年限
	 **/
	private String da_gdsynx;


	/**
	 *固定资产编号
	 **/
	private String da_gdzcbh;


	/**
	 *规格-厚度
	 **/
	private String da_gghd;


	/**
	 *规格-内径
	 **/
	private String da_ggnj;


	/**
	 *规格-容积
	 **/
	private String da_ggrj;


	/**
	 *绿色使用年限（年）
	 **/
	private Long da_greennx;


	/**
	 *绿色运行时间（小时）
	 **/
	private Long da_greenyx;


	/**
	 *换热器芯使用日期
	 **/
	private Date da_hxsydate;


	/**
	 *是否颜色分类
	 **/
	private Boolean da_iscolorclassify;


	/**
	 *是否换热器芯
	 **/
	private Boolean da_ishrqx;


	/**
	 *是否换芯设备
	 **/
	private Boolean da_ishxsb;


	/**
	 *是否主要设备
	 **/
	private Boolean da_iskey;


	/**
	 *检定单位
	 **/
	private String da_jddw;


	/**
	 *介质
	 **/
	private String da_jiezhi;


	/**
	 *校验日期
	 **/
	private Date da_jydate;


	/**
	 *类别代号
	 **/
	private String da_lbdh;


	/**
	 *设备级别
	 **/
	private String da_level;


	/**
	 *流道/公称直径mm
	 **/
	private String da_lgzj;


	/**
	 *类型/形式
	 **/
	private String da_lxxs;


	/**
	 *规格型号
	 **/
	private String da_model;


	/**
	 *分类
	 **/
	private String da_pclassstructure;


	/**
	 *工序
	 **/
	private String da_process;


	/**
	 *入厂日期
	 **/
	private Date da_rcdate;


	/**
	 *红色使用年限（年）
	 **/
	private Long da_rednx;


	/**
	 *红色运行时间（小时）
	 **/
	private Long da_redyx;


	/**
	 *设计单位
	 **/
	private String da_sjdw;


	/**
	 *使用证代号
	 **/
	private String da_syzdh;


	/**
	 *台套标识
	 **/
	private String da_tt;


	/**
	 *单位
	 **/
	private String da_unit;


	/**
	 *下次检验日期
	 **/
	private Date da_xcjyrq;


	/**
	 *黄色使用年限（年）
	 **/
	private Long da_yellownx;


	/**
	 *黄色运行时间（小时）
	 **/
	private Long da_yellowyx;


	/**
	 *压力等级代号
	 **/
	private String da_yldjdh;


	/**
	 *用途代号
	 **/
	private String da_ytdh;


	/**
	 *注册代码
	 **/
	private String da_zcdm;


	/**
	 *整定压力Mpa
	 **/
	private String da_zdyl;


	/**
	 *主体材质
	 **/
	private String da_ztcz;


	/**
	 *制造日期
	 **/
	private Date da_zzdate;


	/**
	 *制造单位
	 **/
	private String da_zzdw;


	/**
	 *缺省维修设施
	 **/
	private String defaultrepfac;


	/**
	 *维修设施地点
	 **/
	private String defaultrepfacsiteid;


	/**
	 *描述
	 **/
	private String description;


	/**
	 *方向
	 **/
	private String direction;


	/**
	 *禁用
	 **/
	private Boolean disabled;


	/**
	 *资产终点
	 **/
	private String enddescription;


	/**
	 *结束测量
	 **/
	private Double endmeasure;


	/**
	 *Eq1
	 **/
	private String eq1;


	/**
	 *Eq10
	 **/
	private String eq10;


	/**
	 *Eq11
	 **/
	private String eq11;


	/**
	 *Eq12
	 **/
	private Double eq12;


	/**
	 *Eq2
	 **/
	private String eq2;


	/**
	 *Eq23
	 **/
	private Date eq23;


	/**
	 *Eq24
	 **/
	private Double eq24;


	/**
	 *Eq3
	 **/
	private String eq3;


	/**
	 *Eq4
	 **/
	private String eq4;


	/**
	 *Eq5
	 **/
	private Double eq5;


	/**
	 *Eq6
	 **/
	private Date eq6;


	/**
	 *Eq7
	 **/
	private Double eq7;


	/**
	 *Eq8
	 **/
	private String eq8;


	/**
	 *Eq9
	 **/
	private String eq9;


	/**
	 *外部引用标识
	 **/
	private String externalrefid;


	/**
	 *故障类
	 **/
	private String failurecode;


	/**
	 *GL 科目
	 **/
	private String glaccount;


	/**
	 *计量表组
	 **/
	private String groupname;


	/**
	 *具有详细描述
	 **/
	private Boolean hasld;


	/**
	 *安装日期
	 **/
	private Date installdate;


	/**
	 *库存成本
	 **/
	private Double invcost;


	/**
	 *校准
	 **/
	private Boolean iscalibration;


	/**
	 *是否编辑润滑部件
	 **/
	private Boolean iseditorlubricationstandard;


	/**
	 *线性
	 **/
	private Boolean islinear;


	/**
	 *是否润滑设备
	 **/
	private Boolean islubrication;


	/**
	 *资产运营
	 **/
	private Boolean isrunning;


	/**
	 *周转项目
	 **/
	private String itemnum;


	/**
	 *项目集
	 **/
	private String itemsetid;


	/**
	 *项目类型
	 **/
	private String itemtype;


	/**
	 *语言代码
	 **/
	private String langcode;


	/**
	 *上次审计者
	 **/
	private String lastauditby;


	/**
	 *上次审计日期
	 **/
	private Date lastauditdate;


	/**
	 *位置
	 **/
	private String location;


	/**
	 *LRM
	 **/
	private String lrm;


	/**
	 *维护层次结构
	 **/
	private Boolean mainthierchy;


	/**
	 *制造商
	 **/
	private String manufacturer;


	/**
	 *移动
	 **/
	private Boolean moved;


	/**
	 *组织
	 **/
	private String orgid;


	/**
	 *所有者系统标识
	 **/
	private String ownersysid;


	/**
	 *父级
	 **/
	private String parent;


	/**
	 *资产部门
	 **/
	private String pluscassetdept;


	/**
	 *类
	 **/
	private String pluscclass;


	/**
	 *校准到期日期
	 **/
	private Date pluscduedate;


	/**
	 *已受污染描述
	 **/
	private String plusciscondesc;


	/**
	 *已受污染
	 **/
	private Boolean plusciscontam;


	/**
	 *内部校准
	 **/
	private Boolean pluscisinhousecal;


	/**
	 *是测量和测试设备
	 **/
	private Boolean pluscismte;


	/**
	 *测量和测试设备分类
	 **/
	private String pluscismteclass;


	/**
	 *回路号
	 **/
	private String pluscloopnum;


	/**
	 *循环位置
	 **/
	private String plusclploc;


	/**
	 *型号
	 **/
	private String pluscmodelnum;


	/**
	 *单位
	 **/
	private String pluscoprgeeu;


	/**
	 *操作范围自
	 **/
	private String pluscoprgefrom;


	/**
	 *收件人
	 **/
	private String pluscoprgeto;


	/**
	 *实际位置
	 **/
	private String pluscphyloc;


	/**
	 *延长日期
	 **/
	private Boolean pluscpmextdate;


	/**
	 *缓冲区解决方案标志
	 **/
	private Boolean pluscsolution;


	/**
	 *应用为
	 **/
	private String pluscsumdir;


	/**
	 *精度工程单位
	 **/
	private String pluscsumeu;


	/**
	 *% READING
	 **/
	private String pluscsumread;


	/**
	 *%SPAN
	 **/
	private String pluscsumspan;


	/**
	 *%URV
	 **/
	private String pluscsumurv;


	/**
	 *校准供应商
	 **/
	private String pluscvendor;


	/**
	 *优先级
	 **/
	private Integer priority;


	/**
	 *采购价格
	 **/
	private Double purchaseprice;


	/**
	 *更换成本
	 **/
	private Double replacecost;


	/**
	 *退回给供应商
	 **/
	private Boolean returnedtovendor;


	/**
	 *周转暂记科目
	 **/
	private String rotsuspacct;


	/**
	 *服务地址
	 **/
	private String saddresscode;


	/**
	 *发送者系统标识
	 **/
	private String sendersysid;


	/**
	 *序列号
	 **/
	private String serialnum;


	/**
	 *班次
	 **/
	private String shiftnum;


	/**
	 *地点
	 **/
	private String siteid;


	/**
	 *源系统标识
	 **/
	private String sourcesysid;


	/**
	 *资产起点
	 **/
	private String startdescription;


	/**
	 *开始测量
	 **/
	private Double startmeasure;


	/**
	 *状态
	 **/
	private String status;


	/**
	 *上一次变更的日期
	 **/
	private Date statusdate;


	/**
	 *使用日期
	 **/
	private Date sydate;


	/**
	 *资产模板
	 **/
	private String templateid;


	/**
	 *分区标识
	 **/
	private String tloamhash;


	/**
	 *分区
	 **/
	private Boolean tloampartition;


	/**
	 *控制科目
	 **/
	private String toolcontrolaccount;


	/**
	 *工具费率
	 **/
	private Double toolrate;


	/**
	 *成本总计
	 **/
	private Double totalcost;


	/**
	 *停工总计
	 **/
	private Double totdowntime;


	/**
	 *总的未记帐成本
	 **/
	private Double totunchargedcost;


	/**
	 *未记帐的成本
	 **/
	private Double unchargedcost;


	/**
	 *使用情况
	 **/
	private String usage;


	/**
	 *供应商
	 **/
	private String vendor;


	/**
	 *保修期截止日期
	 **/
	private Date warrantyexpdate;


	/**
	 *年累计成本
	 **/
	private Double ytdcost;



	public String getAncestor() {
		return ancestor;
	}

	public void setAncestor(String ancestor) {
		this.ancestor = ancestor;
	}

	public String getAssetfrom() {
		return assetfrom;
	}

	public void setAssetfrom(String assetfrom) {
		this.assetfrom = assetfrom;
	}

	public Long getAssetid() {
		return assetid;
	}

	public void setAssetid(Long assetid) {
		this.assetid = assetid;
	}

	public String getAssetjz() {
		return assetjz;
	}

	public void setAssetjz(String assetjz) {
		this.assetjz = assetjz;
	}

	public String getAssetnum() {
		return assetnum;
	}

	public void setAssetnum(String assetnum) {
		this.assetnum = assetnum;
	}

	public String getAssettag() {
		return assettag;
	}

	public void setAssettag(String assettag) {
		this.assettag = assettag;
	}

	public String getAssetto() {
		return assetto;
	}

	public void setAssetto(String assetto) {
		this.assetto = assetto;
	}

	public String getAssettype() {
		return assettype;
	}

	public void setAssettype(String assettype) {
		this.assettype = assettype;
	}

	public Long getAssetuid() {
		return assetuid;
	}

	public void setAssetuid(Long assetuid) {
		this.assetuid = assetuid;
	}

	public Boolean getAutowogen() {
		return autowogen;
	}

	public void setAutowogen(Boolean autowogen) {
		this.autowogen = autowogen;
	}

	public String getBinnum() {
		return binnum;
	}

	public void setBinnum(String binnum) {
		this.binnum = binnum;
	}

	public Double getBudgetcost() {
		return budgetcost;
	}

	public void setBudgetcost(Double budgetcost) {
		this.budgetcost = budgetcost;
	}

	public String getCalnum() {
		return calnum;
	}

	public void setCalnum(String calnum) {
		this.calnum = calnum;
	}

	public String getChangeby() {
		return changeby;
	}

	public void setChangeby(String changeby) {
		this.changeby = changeby;
	}

	public Date getChangedate() {
		return changedate;
	}

	public void setChangedate(Date changedate) {
		this.changedate = changedate;
	}

	public Boolean getChildren() {
		return children;
	}

	public void setChildren(Boolean children) {
		this.children = children;
	}

	public String getClassstructureid() {
		return classstructureid;
	}

	public void setClassstructureid(String classstructureid) {
		this.classstructureid = classstructureid;
	}

	public String getConditioncode() {
		return conditioncode;
	}

	public void setConditioncode(String conditioncode) {
		this.conditioncode = conditioncode;
	}

	public String getDa_archivesnum() {
		return da_archivesnum;
	}

	public void setDa_archivesnum(String da_archivesnum) {
		this.da_archivesnum = da_archivesnum;
	}

	public String getDa_beizhu() {
		return da_beizhu;
	}

	public void setDa_beizhu(String da_beizhu) {
		this.da_beizhu = da_beizhu;
	}

	public String getDa_cclassstructure() {
		return da_cclassstructure;
	}

	public void setDa_cclassstructure(String da_cclassstructure) {
		this.da_cclassstructure = da_cclassstructure;
	}

	public String getDa_coloractyy() {
		return da_coloractyy;
	}

	public void setDa_coloractyy(String da_coloractyy) {
		this.da_coloractyy = da_coloractyy;
	}

	public String getDa_colorclassify() {
		return da_colorclassify;
	}

	public void setDa_colorclassify(String da_colorclassify) {
		this.da_colorclassify = da_colorclassify;
	}

	public String getDa_cpbh() {
		return da_cpbh;
	}

	public void setDa_cpbh(String da_cpbh) {
		this.da_cpbh = da_cpbh;
	}

	public Date getDa_createdate() {
		return da_createdate;
	}

	public void setDa_createdate(Date da_createdate) {
		this.da_createdate = da_createdate;
	}

	public String getDa_createperson() {
		return da_createperson;
	}

	public void setDa_createperson(String da_createperson) {
		this.da_createperson = da_createperson;
	}

	public String getDa_ctgy() {
		return da_ctgy;
	}

	public void setDa_ctgy(String da_ctgy) {
		this.da_ctgy = da_ctgy;
	}

	public String getDa_ctwd() {
		return da_ctwd;
	}

	public void setDa_ctwd(String da_ctwd) {
		this.da_ctwd = da_ctwd;
	}

	public String getDa_cw_bz() {
		return da_cw_bz;
	}

	public void setDa_cw_bz(String da_cw_bz) {
		this.da_cw_bz = da_cw_bz;
	}

	public String getDa_cw_fpgg() {
		return da_cw_fpgg;
	}

	public void setDa_cw_fpgg(String da_cw_fpgg) {
		this.da_cw_fpgg = da_cw_fpgg;
	}

	public String getDa_cw_fph() {
		return da_cw_fph;
	}

	public void setDa_cw_fph(String da_cw_fph) {
		this.da_cw_fph = da_cw_fph;
	}

	public String getDa_cw_fpmc() {
		return da_cw_fpmc;
	}

	public void setDa_cw_fpmc(String da_cw_fpmc) {
		this.da_cw_fpmc = da_cw_fpmc;
	}

	public String getDa_cw_gmdw() {
		return da_cw_gmdw;
	}

	public void setDa_cw_gmdw(String da_cw_gmdw) {
		this.da_cw_gmdw = da_cw_gmdw;
	}

	public String getDa_cw_hth() {
		return da_cw_hth;
	}

	public void setDa_cw_hth(String da_cw_hth) {
		this.da_cw_hth = da_cw_hth;
	}

	public Double getDa_cw_price() {
		return da_cw_price;
	}

	public void setDa_cw_price(Double da_cw_price) {
		this.da_cw_price = da_cw_price;
	}

	public String getDa_cw_pzh() {
		return da_cw_pzh;
	}

	public void setDa_cw_pzh(String da_cw_pzh) {
		this.da_cw_pzh = da_cw_pzh;
	}

	public Long getDa_cycle() {
		return da_cycle;
	}

	public void setDa_cycle(Long da_cycle) {
		this.da_cycle = da_cycle;
	}

	public String getDa_depnum() {
		return da_depnum;
	}

	public void setDa_depnum(String da_depnum) {
		this.da_depnum = da_depnum;
	}

	public String getDa_dorj() {
		return da_dorj;
	}

	public void setDa_dorj(String da_dorj) {
		this.da_dorj = da_dorj;
	}

	public String getDa_fwname() {
		return da_fwname;
	}

	public void setDa_fwname(String da_fwname) {
		this.da_fwname = da_fwname;
	}

	public String getDa_gdsynx() {
		return da_gdsynx;
	}

	public void setDa_gdsynx(String da_gdsynx) {
		this.da_gdsynx = da_gdsynx;
	}

	public String getDa_gdzcbh() {
		return da_gdzcbh;
	}

	public void setDa_gdzcbh(String da_gdzcbh) {
		this.da_gdzcbh = da_gdzcbh;
	}

	public String getDa_gghd() {
		return da_gghd;
	}

	public void setDa_gghd(String da_gghd) {
		this.da_gghd = da_gghd;
	}

	public String getDa_ggnj() {
		return da_ggnj;
	}

	public void setDa_ggnj(String da_ggnj) {
		this.da_ggnj = da_ggnj;
	}

	public String getDa_ggrj() {
		return da_ggrj;
	}

	public void setDa_ggrj(String da_ggrj) {
		this.da_ggrj = da_ggrj;
	}

	public Long getDa_greennx() {
		return da_greennx;
	}

	public void setDa_greennx(Long da_greennx) {
		this.da_greennx = da_greennx;
	}

	public Long getDa_greenyx() {
		return da_greenyx;
	}

	public void setDa_greenyx(Long da_greenyx) {
		this.da_greenyx = da_greenyx;
	}

	public Date getDa_hxsydate() {
		return da_hxsydate;
	}

	public void setDa_hxsydate(Date da_hxsydate) {
		this.da_hxsydate = da_hxsydate;
	}

	public Boolean getDa_iscolorclassify() {
		return da_iscolorclassify;
	}

	public void setDa_iscolorclassify(Boolean da_iscolorclassify) {
		this.da_iscolorclassify = da_iscolorclassify;
	}

	public Boolean getDa_ishrqx() {
		return da_ishrqx;
	}

	public void setDa_ishrqx(Boolean da_ishrqx) {
		this.da_ishrqx = da_ishrqx;
	}

	public Boolean getDa_ishxsb() {
		return da_ishxsb;
	}

	public void setDa_ishxsb(Boolean da_ishxsb) {
		this.da_ishxsb = da_ishxsb;
	}

	public Boolean getDa_iskey() {
		return da_iskey;
	}

	public void setDa_iskey(Boolean da_iskey) {
		this.da_iskey = da_iskey;
	}

	public String getDa_jddw() {
		return da_jddw;
	}

	public void setDa_jddw(String da_jddw) {
		this.da_jddw = da_jddw;
	}

	public String getDa_jiezhi() {
		return da_jiezhi;
	}

	public void setDa_jiezhi(String da_jiezhi) {
		this.da_jiezhi = da_jiezhi;
	}

	public Date getDa_jydate() {
		return da_jydate;
	}

	public void setDa_jydate(Date da_jydate) {
		this.da_jydate = da_jydate;
	}

	public String getDa_lbdh() {
		return da_lbdh;
	}

	public void setDa_lbdh(String da_lbdh) {
		this.da_lbdh = da_lbdh;
	}

	public String getDa_level() {
		return da_level;
	}

	public void setDa_level(String da_level) {
		this.da_level = da_level;
	}

	public String getDa_lgzj() {
		return da_lgzj;
	}

	public void setDa_lgzj(String da_lgzj) {
		this.da_lgzj = da_lgzj;
	}

	public String getDa_lxxs() {
		return da_lxxs;
	}

	public void setDa_lxxs(String da_lxxs) {
		this.da_lxxs = da_lxxs;
	}

	public String getDa_model() {
		return da_model;
	}

	public void setDa_model(String da_model) {
		this.da_model = da_model;
	}

	public String getDa_pclassstructure() {
		return da_pclassstructure;
	}

	public void setDa_pclassstructure(String da_pclassstructure) {
		this.da_pclassstructure = da_pclassstructure;
	}

	public String getDa_process() {
		return da_process;
	}

	public void setDa_process(String da_process) {
		this.da_process = da_process;
	}

	public Date getDa_rcdate() {
		return da_rcdate;
	}

	public void setDa_rcdate(Date da_rcdate) {
		this.da_rcdate = da_rcdate;
	}

	public Long getDa_rednx() {
		return da_rednx;
	}

	public void setDa_rednx(Long da_rednx) {
		this.da_rednx = da_rednx;
	}

	public Long getDa_redyx() {
		return da_redyx;
	}

	public void setDa_redyx(Long da_redyx) {
		this.da_redyx = da_redyx;
	}

	public String getDa_sjdw() {
		return da_sjdw;
	}

	public void setDa_sjdw(String da_sjdw) {
		this.da_sjdw = da_sjdw;
	}

	public String getDa_syzdh() {
		return da_syzdh;
	}

	public void setDa_syzdh(String da_syzdh) {
		this.da_syzdh = da_syzdh;
	}

	public String getDa_tt() {
		return da_tt;
	}

	public void setDa_tt(String da_tt) {
		this.da_tt = da_tt;
	}

	public String getDa_unit() {
		return da_unit;
	}

	public void setDa_unit(String da_unit) {
		this.da_unit = da_unit;
	}

	public Date getDa_xcjyrq() {
		return da_xcjyrq;
	}

	public void setDa_xcjyrq(Date da_xcjyrq) {
		this.da_xcjyrq = da_xcjyrq;
	}

	public Long getDa_yellownx() {
		return da_yellownx;
	}

	public void setDa_yellownx(Long da_yellownx) {
		this.da_yellownx = da_yellownx;
	}

	public Long getDa_yellowyx() {
		return da_yellowyx;
	}

	public void setDa_yellowyx(Long da_yellowyx) {
		this.da_yellowyx = da_yellowyx;
	}

	public String getDa_yldjdh() {
		return da_yldjdh;
	}

	public void setDa_yldjdh(String da_yldjdh) {
		this.da_yldjdh = da_yldjdh;
	}

	public String getDa_ytdh() {
		return da_ytdh;
	}

	public void setDa_ytdh(String da_ytdh) {
		this.da_ytdh = da_ytdh;
	}

	public String getDa_zcdm() {
		return da_zcdm;
	}

	public void setDa_zcdm(String da_zcdm) {
		this.da_zcdm = da_zcdm;
	}

	public String getDa_zdyl() {
		return da_zdyl;
	}

	public void setDa_zdyl(String da_zdyl) {
		this.da_zdyl = da_zdyl;
	}

	public String getDa_ztcz() {
		return da_ztcz;
	}

	public void setDa_ztcz(String da_ztcz) {
		this.da_ztcz = da_ztcz;
	}

	public Date getDa_zzdate() {
		return da_zzdate;
	}

	public void setDa_zzdate(Date da_zzdate) {
		this.da_zzdate = da_zzdate;
	}

	public String getDa_zzdw() {
		return da_zzdw;
	}

	public void setDa_zzdw(String da_zzdw) {
		this.da_zzdw = da_zzdw;
	}

	public String getDefaultrepfac() {
		return defaultrepfac;
	}

	public void setDefaultrepfac(String defaultrepfac) {
		this.defaultrepfac = defaultrepfac;
	}

	public String getDefaultrepfacsiteid() {
		return defaultrepfacsiteid;
	}

	public void setDefaultrepfacsiteid(String defaultrepfacsiteid) {
		this.defaultrepfacsiteid = defaultrepfacsiteid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public String getEnddescription() {
		return enddescription;
	}

	public void setEnddescription(String enddescription) {
		this.enddescription = enddescription;
	}

	public Double getEndmeasure() {
		return endmeasure;
	}

	public void setEndmeasure(Double endmeasure) {
		this.endmeasure = endmeasure;
	}

	public String getEq1() {
		return eq1;
	}

	public void setEq1(String eq1) {
		this.eq1 = eq1;
	}

	public String getEq10() {
		return eq10;
	}

	public void setEq10(String eq10) {
		this.eq10 = eq10;
	}

	public String getEq11() {
		return eq11;
	}

	public void setEq11(String eq11) {
		this.eq11 = eq11;
	}

	public Double getEq12() {
		return eq12;
	}

	public void setEq12(Double eq12) {
		this.eq12 = eq12;
	}

	public String getEq2() {
		return eq2;
	}

	public void setEq2(String eq2) {
		this.eq2 = eq2;
	}

	public Date getEq23() {
		return eq23;
	}

	public void setEq23(Date eq23) {
		this.eq23 = eq23;
	}

	public Double getEq24() {
		return eq24;
	}

	public void setEq24(Double eq24) {
		this.eq24 = eq24;
	}

	public String getEq3() {
		return eq3;
	}

	public void setEq3(String eq3) {
		this.eq3 = eq3;
	}

	public String getEq4() {
		return eq4;
	}

	public void setEq4(String eq4) {
		this.eq4 = eq4;
	}

	public Double getEq5() {
		return eq5;
	}

	public void setEq5(Double eq5) {
		this.eq5 = eq5;
	}

	public Date getEq6() {
		return eq6;
	}

	public void setEq6(Date eq6) {
		this.eq6 = eq6;
	}

	public Double getEq7() {
		return eq7;
	}

	public void setEq7(Double eq7) {
		this.eq7 = eq7;
	}

	public String getEq8() {
		return eq8;
	}

	public void setEq8(String eq8) {
		this.eq8 = eq8;
	}

	public String getEq9() {
		return eq9;
	}

	public void setEq9(String eq9) {
		this.eq9 = eq9;
	}

	public String getExternalrefid() {
		return externalrefid;
	}

	public void setExternalrefid(String externalrefid) {
		this.externalrefid = externalrefid;
	}

	public String getFailurecode() {
		return failurecode;
	}

	public void setFailurecode(String failurecode) {
		this.failurecode = failurecode;
	}

	public String getGlaccount() {
		return glaccount;
	}

	public void setGlaccount(String glaccount) {
		this.glaccount = glaccount;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public Boolean getHasld() {
		return hasld;
	}

	public void setHasld(Boolean hasld) {
		this.hasld = hasld;
	}

	public Date getInstalldate() {
		return installdate;
	}

	public void setInstalldate(Date installdate) {
		this.installdate = installdate;
	}

	public Double getInvcost() {
		return invcost;
	}

	public void setInvcost(Double invcost) {
		this.invcost = invcost;
	}

	public Boolean getIscalibration() {
		return iscalibration;
	}

	public void setIscalibration(Boolean iscalibration) {
		this.iscalibration = iscalibration;
	}

	public Boolean getIseditorlubricationstandard() {
		return iseditorlubricationstandard;
	}

	public void setIseditorlubricationstandard(Boolean iseditorlubricationstandard) {
		this.iseditorlubricationstandard = iseditorlubricationstandard;
	}

	public Boolean getIslinear() {
		return islinear;
	}

	public void setIslinear(Boolean islinear) {
		this.islinear = islinear;
	}

	public Boolean getIslubrication() {
		return islubrication;
	}

	public void setIslubrication(Boolean islubrication) {
		this.islubrication = islubrication;
	}

	public Boolean getIsrunning() {
		return isrunning;
	}

	public void setIsrunning(Boolean isrunning) {
		this.isrunning = isrunning;
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

	public String getItemtype() {
		return itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	public String getLangcode() {
		return langcode;
	}

	public void setLangcode(String langcode) {
		this.langcode = langcode;
	}

	public String getLastauditby() {
		return lastauditby;
	}

	public void setLastauditby(String lastauditby) {
		this.lastauditby = lastauditby;
	}

	public Date getLastauditdate() {
		return lastauditdate;
	}

	public void setLastauditdate(Date lastauditdate) {
		this.lastauditdate = lastauditdate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLrm() {
		return lrm;
	}

	public void setLrm(String lrm) {
		this.lrm = lrm;
	}

	public Boolean getMainthierchy() {
		return mainthierchy;
	}

	public void setMainthierchy(Boolean mainthierchy) {
		this.mainthierchy = mainthierchy;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Boolean getMoved() {
		return moved;
	}

	public void setMoved(Boolean moved) {
		this.moved = moved;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getOwnersysid() {
		return ownersysid;
	}

	public void setOwnersysid(String ownersysid) {
		this.ownersysid = ownersysid;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getPluscassetdept() {
		return pluscassetdept;
	}

	public void setPluscassetdept(String pluscassetdept) {
		this.pluscassetdept = pluscassetdept;
	}

	public String getPluscclass() {
		return pluscclass;
	}

	public void setPluscclass(String pluscclass) {
		this.pluscclass = pluscclass;
	}

	public Date getPluscduedate() {
		return pluscduedate;
	}

	public void setPluscduedate(Date pluscduedate) {
		this.pluscduedate = pluscduedate;
	}

	public String getPlusciscondesc() {
		return plusciscondesc;
	}

	public void setPlusciscondesc(String plusciscondesc) {
		this.plusciscondesc = plusciscondesc;
	}

	public Boolean getPlusciscontam() {
		return plusciscontam;
	}

	public void setPlusciscontam(Boolean plusciscontam) {
		this.plusciscontam = plusciscontam;
	}

	public Boolean getPluscisinhousecal() {
		return pluscisinhousecal;
	}

	public void setPluscisinhousecal(Boolean pluscisinhousecal) {
		this.pluscisinhousecal = pluscisinhousecal;
	}

	public Boolean getPluscismte() {
		return pluscismte;
	}

	public void setPluscismte(Boolean pluscismte) {
		this.pluscismte = pluscismte;
	}

	public String getPluscismteclass() {
		return pluscismteclass;
	}

	public void setPluscismteclass(String pluscismteclass) {
		this.pluscismteclass = pluscismteclass;
	}

	public String getPluscloopnum() {
		return pluscloopnum;
	}

	public void setPluscloopnum(String pluscloopnum) {
		this.pluscloopnum = pluscloopnum;
	}

	public String getPlusclploc() {
		return plusclploc;
	}

	public void setPlusclploc(String plusclploc) {
		this.plusclploc = plusclploc;
	}

	public String getPluscmodelnum() {
		return pluscmodelnum;
	}

	public void setPluscmodelnum(String pluscmodelnum) {
		this.pluscmodelnum = pluscmodelnum;
	}

	public String getPluscoprgeeu() {
		return pluscoprgeeu;
	}

	public void setPluscoprgeeu(String pluscoprgeeu) {
		this.pluscoprgeeu = pluscoprgeeu;
	}

	public String getPluscoprgefrom() {
		return pluscoprgefrom;
	}

	public void setPluscoprgefrom(String pluscoprgefrom) {
		this.pluscoprgefrom = pluscoprgefrom;
	}

	public String getPluscoprgeto() {
		return pluscoprgeto;
	}

	public void setPluscoprgeto(String pluscoprgeto) {
		this.pluscoprgeto = pluscoprgeto;
	}

	public String getPluscphyloc() {
		return pluscphyloc;
	}

	public void setPluscphyloc(String pluscphyloc) {
		this.pluscphyloc = pluscphyloc;
	}

	public Boolean getPluscpmextdate() {
		return pluscpmextdate;
	}

	public void setPluscpmextdate(Boolean pluscpmextdate) {
		this.pluscpmextdate = pluscpmextdate;
	}

	public Boolean getPluscsolution() {
		return pluscsolution;
	}

	public void setPluscsolution(Boolean pluscsolution) {
		this.pluscsolution = pluscsolution;
	}

	public String getPluscsumdir() {
		return pluscsumdir;
	}

	public void setPluscsumdir(String pluscsumdir) {
		this.pluscsumdir = pluscsumdir;
	}

	public String getPluscsumeu() {
		return pluscsumeu;
	}

	public void setPluscsumeu(String pluscsumeu) {
		this.pluscsumeu = pluscsumeu;
	}

	public String getPluscsumread() {
		return pluscsumread;
	}

	public void setPluscsumread(String pluscsumread) {
		this.pluscsumread = pluscsumread;
	}

	public String getPluscsumspan() {
		return pluscsumspan;
	}

	public void setPluscsumspan(String pluscsumspan) {
		this.pluscsumspan = pluscsumspan;
	}

	public String getPluscsumurv() {
		return pluscsumurv;
	}

	public void setPluscsumurv(String pluscsumurv) {
		this.pluscsumurv = pluscsumurv;
	}

	public String getPluscvendor() {
		return pluscvendor;
	}

	public void setPluscvendor(String pluscvendor) {
		this.pluscvendor = pluscvendor;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Double getPurchaseprice() {
		return purchaseprice;
	}

	public void setPurchaseprice(Double purchaseprice) {
		this.purchaseprice = purchaseprice;
	}

	public Double getReplacecost() {
		return replacecost;
	}

	public void setReplacecost(Double replacecost) {
		this.replacecost = replacecost;
	}

	public Boolean getReturnedtovendor() {
		return returnedtovendor;
	}

	public void setReturnedtovendor(Boolean returnedtovendor) {
		this.returnedtovendor = returnedtovendor;
	}

	public String getRotsuspacct() {
		return rotsuspacct;
	}

	public void setRotsuspacct(String rotsuspacct) {
		this.rotsuspacct = rotsuspacct;
	}

	public String getSaddresscode() {
		return saddresscode;
	}

	public void setSaddresscode(String saddresscode) {
		this.saddresscode = saddresscode;
	}

	public String getSendersysid() {
		return sendersysid;
	}

	public void setSendersysid(String sendersysid) {
		this.sendersysid = sendersysid;
	}

	public String getSerialnum() {
		return serialnum;
	}

	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
	}

	public String getShiftnum() {
		return shiftnum;
	}

	public void setShiftnum(String shiftnum) {
		this.shiftnum = shiftnum;
	}

	public String getSiteid() {
		return siteid;
	}

	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}

	public String getSourcesysid() {
		return sourcesysid;
	}

	public void setSourcesysid(String sourcesysid) {
		this.sourcesysid = sourcesysid;
	}

	public String getStartdescription() {
		return startdescription;
	}

	public void setStartdescription(String startdescription) {
		this.startdescription = startdescription;
	}

	public Double getStartmeasure() {
		return startmeasure;
	}

	public void setStartmeasure(Double startmeasure) {
		this.startmeasure = startmeasure;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStatusdate() {
		return statusdate;
	}

	public void setStatusdate(Date statusdate) {
		this.statusdate = statusdate;
	}

	public Date getSydate() {
		return sydate;
	}

	public void setSydate(Date sydate) {
		this.sydate = sydate;
	}

	public String getTemplateid() {
		return templateid;
	}

	public void setTemplateid(String templateid) {
		this.templateid = templateid;
	}

	public String getTloamhash() {
		return tloamhash;
	}

	public void setTloamhash(String tloamhash) {
		this.tloamhash = tloamhash;
	}

	public Boolean getTloampartition() {
		return tloampartition;
	}

	public void setTloampartition(Boolean tloampartition) {
		this.tloampartition = tloampartition;
	}

	public String getToolcontrolaccount() {
		return toolcontrolaccount;
	}

	public void setToolcontrolaccount(String toolcontrolaccount) {
		this.toolcontrolaccount = toolcontrolaccount;
	}

	public Double getToolrate() {
		return toolrate;
	}

	public void setToolrate(Double toolrate) {
		this.toolrate = toolrate;
	}

	public Double getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(Double totalcost) {
		this.totalcost = totalcost;
	}

	public Double getTotdowntime() {
		return totdowntime;
	}

	public void setTotdowntime(Double totdowntime) {
		this.totdowntime = totdowntime;
	}

	public Double getTotunchargedcost() {
		return totunchargedcost;
	}

	public void setTotunchargedcost(Double totunchargedcost) {
		this.totunchargedcost = totunchargedcost;
	}

	public Double getUnchargedcost() {
		return unchargedcost;
	}

	public void setUnchargedcost(Double unchargedcost) {
		this.unchargedcost = unchargedcost;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Date getWarrantyexpdate() {
		return warrantyexpdate;
	}

	public void setWarrantyexpdate(Date warrantyexpdate) {
		this.warrantyexpdate = warrantyexpdate;
	}

	public Double getYtdcost() {
		return ytdcost;
	}

	public void setYtdcost(Double ytdcost) {
		this.ytdcost = ytdcost;
	}
}

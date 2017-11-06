package com.app.jfinal.service.workorder.model

import com.google.common.collect.Lists
import com.jfinal.plugin.activerecord.Db
import com.jfinal.plugin.activerecord.Record
import org.shoukaiseki.jfinal.kernel.common.BaseModel
import org.shoukaiseki.jfinal.kernel.common.SnowField
import org.shoukaiseki.jfinal.kernel.common.SnowTable
import org.shoukaiseki.jfinal.kernel.maximo.model.DocFile
import org.shoukaiseki.jfinal.kernel.plugin.SqlReadConfig
import java.util.*

/**
 * com.wmc.dunanjfinal.service.workorder.model.Workorder <br></br>
 *
 * @author 蒋カイセキ    Japan-Tokyo  2017-08-10 18:28:10<br></br>
 * ブログ http://shoukaiseki.blog.163.com/<br></br>
 * E-メール jiang28555@Gmail.com<br></br>
 */

@SnowTable(maxObjecxtName = "WORKORDER", maxSequenceName = "WORKORDERSEQ",maxUniqueIDName = "WORKORDERID")
open class Workorder : BaseModel() {


    /**
     * 实际物料
     */
    @SnowField(isPersistent = false)
    var showactualmaterials: List<Matusetrans> = Lists.newArrayList()

    /**
     * 实际员工
     */
    @SnowField(isPersistent = false)
    var showactuallabors: List<Labtrans> = Lists.newArrayList()


    /**
     * 计划物料
     */
    @SnowField(isPersistent = false)
    var showplanmaterial: List<Wpitem> = Lists.newArrayList()

    /**
     * 计划员工
     */
    @SnowField(isPersistent = false)
    var showplanlabors: List<Wplabor> = Lists.newArrayList()

    /**
     * 工单任务
     */
    @SnowField(isPersistent = false)
    var showtasks: List<Workorder> = Lists.newArrayList()

    /**
     * 子工单
     */
    @SnowField(isPersistent = false)
    var showchildrens: List<Workorder> = Lists.newArrayList()

    /**
     * 危险点
     */
    var wosafetylinks: List<WosafetylinkView> = Lists.newArrayList()

    /**
     * 附件
     */
    var dfs: List<DocFile> = Lists.newArrayList()

    /**
     * 实际完成时间
     */
    var actfinish: Date? = null


    /**
     * 内部员工的实际成本
     */
    var actintlabcost: Double? = null


    /**
     * 内部员工的实际时数
     */
    var actintlabhrs: Double? = null


    /**
     * 实际员工成本
     */
    var actlabcost: Double? = null


    /**
     * 实际工时
     */
    var actlabhrs: Double? = null


    /**
     * 实际物料成本
     */
    var actmatcost: Double? = null


    /**
     * 外部员工的实际成本
     */
    var actoutlabcost: Double? = null


    /**
     * 外部员工的实际时数
     */
    var actoutlabhrs: Double? = null


    /**
     * 实际服务成本
     */
    var actservcost: Double? = null


    /**
     * 实际开始时间
     */
    var actstart: Date? = null


    /**
     * 实际工具成本
     */
    var acttoolcost: Double? = null


    /**
     * 班组
     */
    var amcrew: String? = null


    /**
     * 需要专用的资产维护窗口
     */
    var ams: Boolean? = null


    /**
     * 要求资产停工
     */
    var aos: Boolean? = null


    /**
     * 需要委派
     */
    var apptrequired: Boolean? = null


    /**
     * 资产/位置优先级
     */
    var assetlocpriority: Int? = null


    /**
     * 资产
     */
    var assetnum: String? = null


    /**
     * 分配的所有者组
     */
    var assignedownergroup: String? = null


    /**
     * 上次更新的物料状态
     */
    var availstatusdate: Date? = null


    /**
     * 撤销计划
     */
    var backoutplan: String? = null


    /**
     * 单据流水号
     */
    var bwnum: String? = null


    /**
     * 日历
     */
    var calccalendar: String? = null


    /**
     * 组织
     */
    var calcorgid: String? = null


    /**
     * 计算的优先级
     */
    var calcpriority: Int? = null


    /**
     * 班次
     */
    var calcshift: String? = null


    /**
     * 计算的经度 (X)
     */
    var calculatedx: Double? = null


    /**
     * 计算的纬度 (Y)
     */
    var calculatedy: Double? = null


    /**
     * 日历
     */
    var calendar: String? = null


    /**
     * 变更人
     */
    var changeby: String? = null


    /**
     * 变更日期
     */
    var changedate: Date? = null


    /**
     * 记入库存
     */
    var chargestore: Boolean? = null


    /**
     * 配置项
     */
    var cinum: String? = null


    /**
     * 类结构
     */
    var classstructureid: String? = null


    /**
     * 服务
     */
    var commodity: String? = null


    /**
     * 服务组
     */
    var commoditygroup: String? = null


    /**
     * 合同
     */
    var contract: String? = null


    /**
     * 创建时间
     */
    var createdate: Date? = null


    /**
     * 创建人
     */
    var createperson: String? = null


    /**
     * 班组
     */
    var crewid: String? = null


    /**
     * 班组工作组
     */
    var crewworkgroup: String? = null


    /**
     * 更换后设备
     */
    var da_areplaceasset: String? = null


    /**
     * 设备所属部门
     */
    var da_assetdepnum: String? = null


    /**
     * 安装地点
     */
    var da_azaddress: String? = null


    /**
     * 不合格原因
     */
    var da_bhgyy: String? = null


    /**
     * 更换前设备
     */
    var da_breplaceasset: String? = null


    /**
     * 车间技术员签字
     */
    var da_cjperson: String? = null


    /**
     * 车间技术员签字时间
     */
    var da_cjpersondate: Date? = null


    /**
     * 修改工作类型时间
     */
    var da_cjxtypedate: Date? = null


    /**
     * 修改工作类型人员
     */
    var da_cjxtypeperson: String? = null


    /**
     * 修改工作类型原因
     */
    var da_cjxtypeyy: String? = null


    /**
     * 检修内容
     */
    var da_content: String? = null


    /**
     * 持续时间
     */
    var da_cxtime: Double? = null


    /**
     * 单机车间技术员签字
     */
    var da_djcjperson: String? = null


    /**
     * 单机调试人员
     */
    var da_djperson: String? = null


    /**
     * 单机设备部专工签字
     */
    var da_djsbperson: String? = null


    /**
     * 单机调试记录
     */
    var da_djts: String? = null


    /**
     * 单机调试记录
     */
    var da_djtscontent: String? = null


    /**
     * 电气是否合格
     */
    var da_dqishg: String? = null


    /**
     * 实际结束时间
     */
    var da_enddate: Date? = null


    /**
     * 工艺是否合格
     */
    var da_gyishg: String? = null


    /**
     * 故障描述
     */
    var da_gzdescription: String? = null


    /**
     * 是否带病运行
     */
    var da_isdbyx: String? = null


    /**
     * 是否故障统计
     */
    var da_isgztj: Boolean? = null


    /**
     * 是否一次合格
     */
    var da_ishg: String? = null


    /**
     * 是否全部更换
     */
    var da_isreplaceall: String? = null


    /**
     * 是否外委
     */
    var da_isww: String? = null


    /**
     * 是否延期?
     */
    var da_isyq: Boolean? = null


    /**
     * 维修监护人
     */
    var da_jhperson: String? = null


    /**
     * 检修地点
     */
    var da_jxaddress: String? = null


    /**
     * 检修日期
     */
    var da_jxdate: Date? = null


    /**
     * 检修单位
     */
    var da_jxdw: String? = null


    /**
     * 检修结束时间
     */
    var da_jxenddate: Date? = null


    /**
     * 机修是否合格
     */
    var da_jxishg: String? = null


    /**
     * 检修方案
     */
    var da_jxplan: String? = null


    /**
     * 处理措施
     */
    var da_jxresult: String? = null


    /**
     * 工作类型
     */
    var da_jxtype: String? = null


    /**
     * 外委单位
     */
    var da_jxwwdw: String? = null


    /**
     * 联动车间技术员
     */
    var da_ldcjperson: String? = null


    /**
     * 联动设备部专工签字
     */
    var da_ldsbperson: String? = null


    /**
     * 联动调试记录
     */
    var da_ldtscontent: String? = null


    /**
     * 联动调试人员
     */
    var da_ldtsperson: String? = null


    /**
     * 规格型号
     */
    var da_model: String? = null


    /**
     * 现工作类型
     */
    var da_njxtype: String? = null


    /**
     * 备注
     */
    var da_note: String? = null


    /**
     * 数量
     */
    var da_number: Int? = null


    /**
     * 油品检测子表部件对应ID
     */
    var da_oildetectionid: Long? = null


    /**
     * 原工作类型
     */
    var da_ojxtype: String? = null


    /**
     * 润滑部位
     */
    var da_part: String? = null


    /**
     * 巡检异常单
     */
    var da_patrolycdata: String? = null


    /**
     * 遗留问题及解决方案
     */
    var da_problem: String? = null


    /**
     * 专业
     */
    var da_profession: String? = null


    /**
     * 配合专业一
     */
    var da_profession1: String? = null


    /**
     * 配合专业二
     */
    var da_profession2: String? = null


    /**
     * 安全员
     */
    var da_recordperson: String? = null


    /**
     * 润滑工单类型
     */
    var da_rhgdtype: String? = null


    /**
     * 润滑类型
     */
    var da_rhtype: String? = null


    /**
     * 申请时间
     */
    var da_sqdate: Date? = null


    /**
     * 申请部门
     */
    var da_sqdepartment: String? = null


    /**
     * 申请人
     */
    var da_sqperson: String? = null


    /**
     * 实际开工时间
     */
    var da_startdate: Date? = null


    /**
     * 检修人数
     */
    var da_workcyqty: Int? = null


    /**
     * 维修性质
     */
    var da_worktype: String? = null


    /**
     * 委外原因及标准
     */
    var da_wwreason: String? = null


    /**
     * 详情设备
     */
    var da_xxlocation: String? = null


    /**
     * 仪表是否合格
     */
    var da_ybishg: String? = null


    /**
     * 工单年份
     */
    var da_year: String? = null


    /**
     * 是否油品检测
     */
    var da_ypjc: Boolean? = null


    /**
     * 延期原因
     */
    var da_yqreason: String? = null


    /**
     * 延期详情
     */
    var da_yqremark: String? = null


    /**
     * 已用年限
     */
    var da_yyyear: String? = null


    /**
     * 制造年月
     */
    var da_zzdate: Date? = null


    /**
     * 描述
     */
    open var description: String? = null


    /**
     * 直接发放物料状态
     */
    var dirissuemtlstatus: String? = null


    /**
     * 禁用
     */
    var disabled: Boolean? = null


    /**
     * 停工时间
     */
    var downtime: Boolean? = null


    /**
     * 环境
     */
    var environment: String? = null


    /**
     * 内部员工的批准成本
     */
    var estatapprintlabcost: Double? = null


    /**
     * 内部员工的估算时数
     */
    var estatapprintlabhrs: Double? = null


    /**
     * 批准时估算员工成本
     */
    var estatapprlabcost: Double? = null


    /**
     * 批准时估算工时数
     */
    var estatapprlabhrs: Double? = null


    /**
     * 估计批准时的物料成本
     */
    var estatapprmatcost: Double? = null


    /**
     * 外部员工的估算时数
     */
    var estatapproutlabcost: Double? = null


    /**
     * 外部员工的估算成本
     */
    var estatapproutlabhrs: Double? = null


    /**
     * 批准时估计服务成本
     */
    var estatapprservcost: Double? = null


    /**
     * 估计批准时的工具成本
     */
    var estatapprtoolcost: Double? = null


    /**
     * 持续时间
     */
    var estdur: Double? = null


    /**
     * 内部员工的估算成本
     */
    var estintlabcost: Double? = null


    /**
     * 内部员工的估算时数
     */
    var estintlabhrs: Double? = null


    /**
     * 估算员工成本
     */
    var estlabcost: Double? = null


    /**
     * 估算的工时
     */
    var estlabhrs: Double? = null


    /**
     * 估算的物料成本
     */
    var estmatcost: Double? = null


    /**
     * 外部员工的估算成本
     */
    var estoutlabcost: Double? = null


    /**
     * 外部员工的估算时数
     */
    var estoutlabhrs: Double? = null


    /**
     * 估算的服务成本
     */
    var estservcost: Double? = null


    /**
     * 估算的工具成本
     */
    var esttoolcost: Double? = null


    /**
     * 外部引用标识
     */
    var externalrefid: String? = null


    /**
     * 故障日期
     */
    var faildate: Date? = null


    /**
     * 故障类
     */
    var failurecode: String? = null


    /**
     * 财务控制标识
     */
    var fincntrlid: String? = null


    /**
     * 首个批准状态
     */
    var firstapprstatus: String? = null


    /**
     * 流程操作
     */
    var flowaction: String? = null


    /**
     * 流程操作辅助
     */
    var flowactionassist: Boolean? = null


    /**
     * 在流控制下
     */
    var flowcontrolled: Boolean? = null


    /**
     * 最晚完成日期
     */
    var fnlconstraint: Date? = null


    /**
     * PO
     */
    var generatedforpo: String? = null


    /**
     * PO 行标识
     */
    var genforpolineid: Long? = null


    /**
     * PO 修订
     */
    var genforporevision: Int? = null


    /**
     * GL 科目
     */
    var glaccount: String? = null


    /**
     * 有子级
     */
    var haschildren: Boolean? = null


    /**
     * 是否有后续工作
     */
    var hasfollowupwork: Boolean? = null


    /**
     * 具有详细描述
     */
    var hasld: Boolean? = null


    /**
     * 历史记录
     */
    var historyflag: Boolean? = null


    /**
     * 针对工单状态忽略直接发放可用性
     */
    var ignorediavail: Boolean? = null


    /**
     * 针对工单状态忽略库房可用性
     */
    var ignoresrmavail: Boolean? = null


    /**
     * 在调度中包含任务
     */
    var inctasksinsched: Boolean? = null


    /**
     * 检验员
     */
    var inspector: String? = null


    /**
     * 可中断
     */
    var interruptible: Boolean? = null


    /**
     * 是任务
     */
    open var istask: Boolean? = null


    /**
     * 是否调试
     */
    var ists: String? = null


    /**
     * 作业任务标识
     */
    var jobtaskid: Long? = null


    /**
     * 作业计划
     */
    var jpnum: String? = null


    /**
     * 优先级理由
     */
    var justifypriority: String? = null


    /**
     * 语言代码
     */
    var langcode: String? = null


    /**
     * 上次复制文档链接的时间
     */
    var lastcopylinkdate: Date? = null


    /**
     * 启动条目名称
     */
    var launchentryname: String? = null


    /**
     * 负责人
     */
    var lead: String? = null


    /**
     * 需要专用的位置维护窗口
     */
    var lms: Boolean? = null


    /**
     * 位置
     */
    var location: String? = null


    /**
     * 要求位置停工
     */
    var los: Boolean? = null


    /**
     * 测量日期
     */
    var measuredate: Date? = null


    /**
     * 测量结果
     */
    var measurementvalue: Double? = null


    /**
     * 嵌套的作业计划处理
     */
    var nestedjpinprocess: Boolean? = null


    /**
     * 新子类
     */
    var newchildclass: String? = null


    /**
     * 观测
     */
    var observation: String? = null


    /**
     * 代表
     */
    var onbehalfof: String? = null


    /**
     * 组织
     */
    override var orgid: String? = null


    /**
     * 原始记录的类
     */
    var origrecordclass: String? = null


    /**
     * 原始记录
     */
    var origrecordid: String? = null


    /**
     * 外部员工成本
     */
    var outlabcost: Double? = null


    /**
     * 外部物料成本
     */
    var outmatcost: Double? = null


    /**
     * 外部工具成本
     */
    var outtoolcost: Double? = null


    /**
     * 所有者
     */
    var owner: String? = null


    /**
     * 所有者组
     */
    var ownergroup: String? = null


    /**
     * 所有者系统标识
     */
    var ownersysid: String? = null


    /**
     * 父工单
     */
    open var parent: String? = null


    /**
     * 继承状态变更
     */
    var parentchgsstatus: Boolean? = null


    /**
     * 工作组
     */
    var persongroup: String? = null


    /**
     * 电话
     */
    var phone: String? = null


    /**
     * 频率字段
     */
    var pluscfrequency: Int? = null


    /**
     * 频率单位
     */
    var pluscfrequnit: String? = null


    /**
     * 是否移动
     */
    var pluscismobile: Boolean? = null


    /**
     * 作业计划修订版号
     */
    var pluscjprevnum: Int? = null


    /**
     * 循环校准
     */
    var pluscloop: Boolean? = null


    /**
     * 下一个校准到期日期
     */
    var pluscnextdate: Date? = null


    /**
     * 校准过期日期
     */
    var pluscoverduedate: Date? = null


    /**
     * 实际位置
     */
    var pluscphyloc: String? = null


    /**
     * PM 截止日期
     */
    var pmduedate: Date? = null


    /**
     * PM 延长日期
     */
    var pmextdate: Date? = null


    /**
     * PM 下一截止日期
     */
    var pmnextduedate: Date? = null


    /**
     * PM
     */
    var pmnum: String? = null


    /**
     * 测点
     */
    var pointnum: String? = null


    /**
     * 问题代码
     */
    var problemcode: String? = null


    /**
     * 变更的原因
     */
    var reasonforchange: String? = null


    /**
     * 剩余时间
     */
    var remdur: Double? = null


    /**
     * 维修设施
     */
    var repairfacility: String? = null


    /**
     * 维修设施地点
     */
    var repfacsiteid: String? = null


    /**
     * 报告日期
     */
    var reportdate: Date? = null


    /**
     * 报告人
     */
    var reportedby: String? = null


    /**
     * 要求资产停工
     */
    var reqasstdwntime: Boolean? = null


    /**
     * 响应人
     */
    var respondby: Date? = null


    /**
     * 风险评估
     */
    var risk: String? = null


    /**
     * 检修路线
     */
    var route: String? = null


    /**
     * 检修路线站点
     */
    var routestopid: Long? = null


    /**
     * 计划完成时间
     */
    var schedfinish: Date? = null


    /**
     * 调度开始时间
     */
    var schedstart: Date? = null


    /**
     * 发送者系统标识
     */
    var sendersysid: String? = null


    /**
     * 地点
     */
    override var siteid: String? = null


    /**
     * 最早开始日期
     */
    var sneconstraint: Date? = null


    /**
     * 源系统标识
     */
    var sourcesysid: String? = null


    /**
     * 状态
     */
    override var status: String? = null


    /**
     * 状态日期
     */
    var statusdate: Date? = null


    /**
     * 库房物料状态
     */
    var storeroommtlstatus: String? = null


    /**
     * 主管人
     */
    var supervisor: String? = null


    /**
     * 中止流控制
     */
    var suspendflow: Boolean? = null


    /**
     * 目标完成时间
     */
    var targcompdate: Date? = null


    /**
     * 目标描述
     */
    var targetdesc: String? = null


    /**
     * 目标开始时间
     */
    var targstartdate: Date? = null


    /**
     * 任务
     */
    open var taskid: Int? = null


    /**
     * 供应商
     */
    var vendor: String? = null


    /**
     * 验证
     */
    var verification: String? = null


    /**
     * 为谁进行此变更？
     */
    var whomischangefor: String? = null


    /**
     * 接受费用
     */
    var woacceptscharges: Boolean? = null


    /**
     * 类
     */
    open var woclass: String? = null


    /**
     * Woeq1
     */
    var woeq1: String? = null


    /**
     * Woeq10
     */
    var woeq10: String? = null


    /**
     * Woeq11
     */
    var woeq11: String? = null


    /**
     * Woeq12
     */
    var woeq12: Double? = null


    /**
     * Woeq13
     */
    var woeq13: Date? = null


    /**
     * 实际维修时间
     */
    var woeq14: Double? = null


    /**
     * Woeq2
     */
    var woeq2: String? = null


    /**
     * Woeq3
     */
    var woeq3: String? = null


    /**
     * Woeq4
     */
    var woeq4: String? = null


    /**
     * Woeq5
     */
    var woeq5: Double? = null


    /**
     * Woeq6
     */
    var woeq6: Date? = null


    /**
     * Woeq7
     */
    var woeq7: Double? = null


    /**
     * Woeq8
     */
    var woeq8: String? = null


    /**
     * Woeq9
     */
    var woeq9: String? = null


    /**
     * 工单组
     */
    var wogroup: String? = null


    /**
     * 这是资产交换吗
     */
    var woisswap: Boolean? = null


    /**
     * WOJO1
     */
    var wojo1: String? = null


    /**
     * WOJO2
     */
    var wojo2: String? = null


    /**
     * WOJO3
     */
    var wojo3: String? = null


    /**
     * WOJO4
     */
    var wojo4: Double? = null


    /**
     * WOJO5
     */
    var wojo5: String? = null


    /**
     * WOJO6
     */
    var wojo6: String? = null


    /**
     * WOJO7
     */
    var wojo7: String? = null


    /**
     * WOJO8
     */
    var wojo8: String? = null


    /**
     * Wojp1
     */
    var wojp1: String? = null


    /**
     * Wojp2
     */
    var wojp2: String? = null


    /**
     * Wojp3
     */
    var wojp3: String? = null


    /**
     * Wojp4
     */
    var wojp4: Double? = null


    /**
     * 安全员审批日期
     */
    var wojp5: Date? = null


    /**
     * Wol1
     */
    var wol1: String? = null


    /**
     * Wol2
     */
    var wol2: String? = null


    /**
     * Wol3
     */
    var wol3: Double? = null


    /**
     * Wol4
     */
    var wol4: Date? = null


    /**
     * 员工
     */
    var wolablnk: String? = null


    /**
     * 故障原因及故障现象
     */
    var wolo1: String? = null


    /**
     * Wolo10
     */
    var wolo10: Int? = null


    /**
     * Wolo2
     */
    var wolo2: String? = null


    /**
     * Wolo3
     */
    var wolo3: String? = null


    /**
     * Wolo4
     */
    var wolo4: String? = null


    /**
     * Wolo5
     */
    var wolo5: String? = null


    /**
     * Wolo6
     */
    var wolo6: Double? = null


    /**
     * Wolo7
     */
    var wolo7: Date? = null


    /**
     * Wolo8
     */
    var wolo8: Double? = null


    /**
     * Wolo9
     */
    var wolo9: String? = null


    /**
     * 工单
     */
    open var wonum: String? = null


    /**
     * 优先级
     */
    var wopriority: Int? = null


    /**
     * 工作位置
     */
    var worklocation: String? = null


    /**
     * 工作票编号
     */
    var worknum: String? = null


    /**
     * 工作人员组
     */
    var workorperson: String? = null


    /**
     * 工作包物料状态
     */
    var workpackmtlstatus: String? = null


    /**
     * Worts1
     */
    var worts1: String? = null


    /**
     * Worts2
     */
    var worts2: String? = null


    /**
     * Worts3
     */
    var worts3: String? = null


    /**
     * Worts4
     */
    var worts4: Date? = null


    /**
     * Worts5
     */
    var worts5: Double? = null


    /**
     * 序号
     */
    var wosequence: Int? = null


    /**
     * 故障问题
     */
    @SnowField(isPersistent = false)
    var failurereport_gzwt: String? = null


    /**
     * 故障描述
     */
    @SnowField(isPersistent = false)
    var failurereport_bjcs: String? = null

    //工作类型
    @SnowField(isRequired = true)
    var worktype: String? = null
    @SnowField(isInsertIgnore = true)
    override var rowstamp: Long? = null

    @SnowField(isPrimary = true)
    open var workorderid: Long? = null

    override fun ifNullDefaultValueMap(): java.util.HashMap<String, Any> {
        // TODO Auto-generated method stub
        val defvalmap = super.ifNullDefaultValueMap()
        /**
         */
        defvalmap.put("WORKTYPE", "WO")
        defvalmap.put("WOISSWAP", false)
        defvalmap.put("STATUS", "等待核准")
        defvalmap.put("WOCLASS", "工单")
        defvalmap.put("STATUSDATE", "&SYSDATE&")
        defvalmap.put("SITEID", "&SITEID&")
        defvalmap.put("OUTTOOLCOST", 0.00)
        defvalmap.put("OUTMATCOST", 0.00)
        defvalmap.put("OUTLABCOST", 0.00)
        defvalmap.put("ORGID", "&ORGID&")
        defvalmap.put("NEWCHILDCLASS", "工单")
        defvalmap.put("LANGCODE", "ZH")
        defvalmap.put("ISTASK", false)
        defvalmap.put("HISTORYFLAG", false)
        defvalmap.put("HASFOLLOWUPWORK", false)
        defvalmap.put("HASCHILDREN", false)
        defvalmap.put("ESTTOOLCOST", 0.0)
        defvalmap.put("ESTSERVCOST", 0.0)
        defvalmap.put("ESTMATCOST", 0.00)
        defvalmap.put("ESTLABHRS", 0)
        defvalmap.put("ESTLABCOST", 0)
        defvalmap.put("ESTDUR", 0)
        defvalmap.put("ESTATAPPRSERVCOST", 0)
        defvalmap.put("ESTATAPPRMATCOST", 0)
        defvalmap.put("ESTATAPPRLABHRS", 0)
        defvalmap.put("ESTATAPPRLABCOST", 0)
        defvalmap.put("DOWNTIME", 0)
        defvalmap.put("DISABLED", 0)
        defvalmap.put("CHARGESTORE", 0)
        defvalmap.put("ESTATAPPRTOOLCOST", 0)
        defvalmap.put("ACTLABCOST", 0)
        defvalmap.put("ACTTOOLCOST", 0)
        defvalmap.put("ACTSERVCOST", 0)
        defvalmap.put("ACTMATCOST", 0)
        defvalmap.put("ACTLABHRS", 0)
        return defvalmap
    }


    override fun hasNewSavePermissions(personid: String): Boolean {
        // TODO Auto-generated method stub
        val status = status

        //新建的 reporteby 为登录人 则允许新建保存
        return ("新建" == status || "退回修改" == status || "等待核准" == status) && personid.equals(reportedby!!, ignoreCase = true)
    }


    override fun noSavePermissionsMessage(): String {
        val sb = StringBuffer()
        sb.append("").append(showMaxTableName()).append(".")
        sb.append("WONUM")
        sb.append("=").append(wonum)
        sb.append(";")
        return sb.toString()
    }

    /**
     * 故障原因
     */
    @SnowField(isPersistent = false)
    var failurereport_gzyy: String? = null

    override fun toInsertMapAfter(map: MutableMap<String, Any>) {
        // TODO Auto-generated method stub
        failurereport_gzwt?.let { map.put("PROBLEMCODE", it) }
    }

//    override fun showMaxUniqueIDValue(): Long? {
//        return workorderid
//    }

    override fun showBaseModelByUniqueID(paras:Any):BaseModel?{
        var sql = SqlReadConfig.getSql("workorder.findwotrackbywoid", paras)
        val record: Record = Db.findFirst(sql)
        var obj= BaseModel.Companion.recordTo(record, javaClass)

        return obj
    }
}

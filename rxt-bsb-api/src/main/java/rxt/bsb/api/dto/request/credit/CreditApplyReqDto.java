package rxt.bsb.api.dto.request.credit;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * 3.1.1授信申请接受请求报文（实时模式）
 * Created by ChenLiXin on 2019/9/17 0017 16:40
 */
public class CreditApplyReqDto implements Serializable {

    @NotBlank(message = "渠道编号不能空")
    @Size(max = 20, message = "渠道编号长度不能超过{max}位")
    private String ChannelNo;//渠道编号

    @NotBlank(message = "平台会员号不能空")
    @Size(max = 20, message = "平台会员号长度不能超过{max}位")
    private String CustNo;//平台会员号

    @NotBlank(message = "平台申请编号不能空")
    @Size(max = 32, message = "平台申请编号长度不能超过{max}位")
    private String PlatApplyNo;//平台申请编号

    @NotBlank(message = "客户名称不能空")
    @Size(max = 40, message = "客户名称长度不能超过{max}位")
    private String CustName;//客户名称

    @NotBlank(message = "证件类型不能空")
    @Size(max = 2, message = "证件类型长度不能超过{max}位")
    private String CertType;//证件类型  01 身份证02 军官证03 警官证 04 士兵证

    @NotBlank(message = "证件号码不能空")
    @Size(max = 20, message = "证件号码长度不能超过{max}位")
    private String CertNo;//证件号码

    //@NotBlank(message="证件有效期不能空")
    @Size(max = 5, message = "证件有效期长度不能超过{max}位")
    private String CertValidDate;//证件有效期

    @Size(max = 8, message = "证件起始日长度不能超过{max}位")
    private String CertStartDate;//证件起始日

    @Size(max = 8, message = "证件到期日长度不能超过{max}位")
    private String CertLengthDate;//证件到期日

    @NotBlank(message = "客户类型不能空")
    @Size(max = 3, message = "客户类型长度不能超过{max}位")
    private String CustType;//客户类型

    @Size(max = 2, message = "是否我行员工长度不能超过{max}位")
    private String IsBankStaff;//是否我行员工

    private String Age;//年龄

    @NotBlank(message = "出生日期不能空")
    @Size(max = 8, message = "出生日期长度不能超过{max}位")
    private String BirthDate;//出生日期

    @NotBlank(message = "手机号码不能空")
    @Size(max = 15, message = "手机号码长度不能超过{max}位")
    private String MobileNo;//手机号码

    @NotBlank(message = "性别不能空")
    @Size(max = 1, message = "性别长度不能超过{max}位")
    private String Gender;//性别 M 男 F 女

    @NotBlank(message = "国籍不能空")
    @Size(max = 3, message = "国籍长度不能超过{max}位")
    private String Country;//国籍 01 中华人民共和国 02 中国台湾 03 香港 04 澳门

    @NotBlank(message = "住宅地址行政区划编号不能空")
    @Size(max = 10, message = "住宅地址行政区划编号长度不能超过{max}位")
    private String AddressCode;// 住宅地址行政区划编号

    @NotBlank(message = "住宅地址行政区划不能空")
    @Size(max = 40, message = "住宅地址行政区划长度不能超过{max}位")
    private String AddressStr;//住宅地址行政区划

    @NotBlank(message = "住宅地址不能空")
    @Size(max = 400, message = "住宅地址长度不能超过{max}位")
    private String AddressInfo;//住宅地址

    @NotBlank(message = "住宅电话不能空")
    @Size(max = 30, message = "住宅电话长度不能超过{max}位")
    private String HomeTel;//住宅电话 不能加入横杠

    @NotBlank(message = "婚姻状况不能空")
    @Size(max = 2, message = "婚姻状况长度不能超过{max}位")
    private String Marriage;//婚姻状况  U 未婚 M 已婚 D 离婚 W 丧偶

    //@NotBlank(message="婚姻状况不能空")
    @Size(max = 50, message = "配偶姓名长度不能超过{max}位")
    private String SpouseName;//配偶姓名 当婚姻状况为已婚时，则必填

    @NotBlank(message = "最高学历不能空")
    @Size(max = 2, message = "最高学历长度不能超过{max}位")
    private String Education;//最高学历 0 无 1 小学 2 初中 3 高中 4 大专 5 本科 6 硕士 7 博士

    @Size(max = 30, message = "电子邮箱长度不能超过{max}位")
    private String Email;//电子邮箱

    @NotBlank(message = "居住状况不能空")
    @Size(max = 10, message = "居住状况长度不能超过{max}位")
    private String LivingStatus;//居住状况

    @Size(max = 100, message = "户籍长度不能超过{max}位")
    private String RegisteredHouse;//户籍

    @Size(max = 100, message = "户籍所在地长度不能超过{max}位")
    private String RegisteredPlace;//户籍所在地

    @Size(max = 10, message = "本地居住时长长度不能超过{max}位")
    private String CheckDate;//本地居住时长

    @NotBlank(message = "通讯地址类型不能空")
    @Size(max = 2, message = "通讯地址类型况长度不能超过{max}位")
    private String AddressType;//通讯地址类型 01  住宅 02  单位

    //@NotBlank(message="配偶证件类型不能空")
    @Size(max = 2, message = "配偶证件类型长度不能超过{max}位")
    private String SpouseCertType;//配偶证件类型

    //@NotBlank(message="配偶证件号码不能空")
    @Size(max = 20, message = "配偶证件号码长度不能超过{max}位")
    private String SpouseCertNo;//配偶证件号码

    @Size(max = 15, message = "配偶手机号长度不能超过{max}位")
    private String SpouseMobile;//配偶手机号

    @NotBlank(message = "客户标识不能空")
    @Size(max = 2, message = "客户标识长度不能超过{max}位")
    private String CustFlag;//客户标识  01 自雇  02 受薪

    @Size(max = 20, message = "工商登记证号长度不能超过{max}位")
    private String RegCertCode;//工商登记证号 客户标识为 1 自雇时，录入

    @Size(max = 50, message = "经营实体名称长度不能超过{max}位")
    private String ManageName;//经营实体名称 客户标识为 1 自雇时，录入

    @Size(max = 2, message = "经营场所所有权长度不能超过{max}位")
    private String ManageOwner;//经营场所所有权 客户标识为 1 自雇时，录入

    @Size(max = 10, message = "经营地址行政区划编号长度不能超过{max}位")
    private String ManageAddressId;//经营地址行政区划编号 客户标识为 1 自雇时，录入

    @Size(max = 5, message = "经营年限长度不能超过{max}位")
    private String ManageYear;//经营年限 客户标识为 1 自雇时，录入

    @Size(max = 400, message = "经营地址长度不能超过{max}位")
    private String ManageAddress;//经营地址 客户标识为 1 自雇时，录入

    @Size(max = 5, message = "经营行业长度不能超过{max}位")
    private String ManageTrade;//经营行业 客户标识为 1 自雇时，录入

    @Size(max = 100, message = "经营行业名称长度不能超过{max}位")
    private String ManageTradeName;//经营行业名称 客户标识为 1 自雇时，录入

    @Size(max = 16, message = "企业年收入长度不能超过{max}位")
    private String ManageIncome;//企业年收入 客户标识为 1 自雇时，录入

    @Size(max = 20, message = "员工人数长度不能超过{max}位")
    private String ManageEmployee;//员工人数 客户标识为 1 自雇时，录入

    @Size(max = 50, message = "单位名称长度不能超过{max}位")
    private String CommpannyName;//单位名称 客户标识为 2 受薪时，录入

    @Size(max = 10, message = "单位所属行业长度不能超过{max}位")
    private String CommpannyTrade;//单位所属行业 客户标识为 2 受薪时，录入

    @Size(max = 100, message = "单位所属行业名称长度不能超过{max}位")
    private String CommpannyTradeName;//单位所属行业名称 客户标识为 2 受薪时，录入

    @Size(max = 10, message = "单位性质长度不能超过{max}位")
    private String CommpannyType;//单位性质 客户标识为 2 受薪时，录入

    @Size(max = 10, message = "单位地址行政区划编号长度不能超过{max}位")
    private String CommpannyAddressId;//单位地址行政区划编号 客户标识为 2 受薪时，录入

    @Size(max = 40, message = "单位地址行政区划长度不能超过{max}位")
    private String CommpannyStr;//单位地址行政区划 客户标识为 2 受薪时，录入

    @Size(max = 400, message = "单位地址长度不能超过{max}位")
    private String CommpannyAddress;//单位地址 客户标识为 2 受薪时，录入

    @Size(max = 15, message = "单位电话长度不能超过{max}位")
    private String CommpannyPhone;//单位电话 客户标识为 2 受薪时，录入

    @Size(max = 16, message = "借款人年收入长度不能超过{max}位")
    private String CommLoanIncome;//借款人年收入 客户标识为 2 受薪时，录入

    @Size(max = 5, message = "本单位工作年限长度不能超过{max}位")
    private String CommpannyYear;//本单位工作年限 客户标识为 2 受薪时，录入

    @Size(max = 5, message = "职务长度不能超过{max}位")
    private String CommpannyJob;//职务 客户标识为 2 受薪时，录入

    @Size(max = 5, message = "职称长度不能超过{max}位")
    private String CommpannyTitle;//职称 客户标识为 2 受薪时，录入

    @Size(max = 5, message = "职业长度不能超过{max}位")
    private String CommpannyVocation;//职业 客户标识为 2 受薪时，录入

    @Size(max = 10, message = "岗位长度不能超过{max}位")
    private String CommpannyPost;//岗位 客户标识为 2 受薪时，录入

    @NotBlank(message = "产品编号不能空")
    @Size(max = 2, message = "产品编号长度不能超过{max}位")
    private String Product;//产品编号

    @NotBlank(message = "授信金额不能空")
    @Size(max = 16, message = "授信金额长度不能超过{max}位")
    private String CreditAmt;//授信金额

    @NotBlank(message = "还款方式不能空")
    @Size(max = 4, message = "还款方式长度不能超过{max}位")
    private String RepayType;//还款方式

    private String ApplyTerm;//期限  单位月

    @NotBlank(message = "还款来源不能空")
    @Size(max = 64, message = "还款来源长度不能超过{max}位")
    private String RepaySource;//还款来源

    private String PayDay;//还款日

    private String PayDistance;//还款间隔

    @NotBlank(message = "担保方式不能空")
    @Size(max = 2, message = "担保方式长度不能超过{max}位")
    private String AssureMeansMain;//担保方式

    @NotBlank(message = "支付方式不能空")
    @Size(max = 2, message = "支付方式长度不能超过{max}位")
    private String PayType;//支付方式

    @NotBlank(message = "贷款用途不能空")
    @Size(max = 3, message = "贷款用途长度不能超过{max}位")
    private String LoanUse;//贷款用途

    @NotBlank(message = "进件渠道不能空")
    @Size(max = 2, message = "进件渠道长度不能超过{max}位")
    private String ApplyChannel;//进件渠道

    private List<CustRelReqDto> CustRelDto; //关系人列表

    private List<OrderInfoReqDto> OrderInfoDto;  //订单列表

    private List<EntrustReqDto> EntrustDto; //受托列表

    private List<FileReqDto> FileDto; //附件列表

    @NotBlank(message = "授信申请利率不能空")
    @Size(max = 6, message = "授信申请利率长度不能超过{max}位")
    private String FinancRate;//授信申请利率

    @NotBlank(message = "是否循环合同不能空")
    @Size(max = 1, message = "是否循环合同长度不能超过{max}位")
    private String IsCircle;//是否循环合同 0否 1是

    @NotBlank(message = "是否多次放款不能空")
    @Size(max = 1, message = "是否多次放款长度不能超过{max}位")
    private String IsMultiLoan;//是否多次放款 0否 1是

    private String AuditDatas;//资质审核数据

    @Size(max = 32, message = "放款账号长度不能超过{max}位")
    private String LoanNo;//放款账号

    @JSONField(name = "ChannelNo")
    public String getChannelNo() {
        return ChannelNo;
    }

    public void setChannelNo(String channelNo) {
        ChannelNo = channelNo;
    }

    @JSONField(name = "CustNo")
    public String getCustNo() {
        return CustNo;
    }

    public void setCustNo(String custNo) {
        CustNo = custNo;
    }

    @JSONField(name = "PlatApplyNo")
    public String getPlatApplyNo() {
        return PlatApplyNo;
    }

    public void setPlatApplyNo(String platApplyNo) {
        PlatApplyNo = platApplyNo;
    }

    @JSONField(name = "CustName")
    public String getCustName() {
        return CustName;
    }

    public void setCustName(String custName) {
        CustName = custName;
    }

    @JSONField(name = "CertType")
    public String getCertType() {
        return CertType;
    }

    public void setCertType(String certType) {
        CertType = certType;
    }

    @JSONField(name = "CertNo")
    public String getCertNo() {
        return CertNo;
    }

    public void setCertNo(String certNo) {
        CertNo = certNo;
    }

    @JSONField(name = "CertValidDate")
    public String getCertValidDate() {
        return CertValidDate;
    }

    public void setCertValidDate(String certValidDate) {
        CertValidDate = certValidDate;
    }

    @JSONField(name = "CertStartDate")
    public String getCertStartDate() {
        return CertStartDate;
    }

    public void setCertStartDate(String certStartDate) {
        CertStartDate = certStartDate;
    }

    @JSONField(name = "CertLengthDate")
    public String getCertLengthDate() {
        return CertLengthDate;
    }

    public void setCertLengthDate(String certLengthDate) {
        CertLengthDate = certLengthDate;
    }

    @JSONField(name = "CustType")
    public String getCustType() {
        return CustType;
    }

    public void setCustType(String custType) {
        CustType = custType;
    }

    @JSONField(name = "IsBankStaff")
    public String getIsBankStaff() {
        return IsBankStaff;
    }

    public void setIsBankStaff(String isBankStaff) {
        IsBankStaff = isBankStaff;
    }

    @JSONField(name = "Age")
    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    @JSONField(name = "BirthDate")
    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    @JSONField(name = "MobileNo")
    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    @JSONField(name = "Gender")
    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    @JSONField(name = "Country")
    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    @JSONField(name = "AddressCode")
    public String getAddressCode() {
        return AddressCode;
    }

    public void setAddressCode(String addressCode) {
        AddressCode = addressCode;
    }

    @JSONField(name = "AddressStr")
    public String getAddressStr() {
        return AddressStr;
    }

    public void setAddressStr(String addressStr) {
        AddressStr = addressStr;
    }

    @JSONField(name = "AddressInfo")
    public String getAddressInfo() {
        return AddressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        AddressInfo = addressInfo;
    }

    @JSONField(name = "HomeTel")
    public String getHomeTel() {
        return HomeTel;
    }

    public void setHomeTel(String homeTel) {
        HomeTel = homeTel;
    }

    @JSONField(name = "Marriage")
    public String getMarriage() {
        return Marriage;
    }

    public void setMarriage(String marriage) {
        Marriage = marriage;
    }

    @JSONField(name = "SpouseName")
    public String getSpouseName() {
        return SpouseName;
    }

    public void setSpouseName(String spouseName) {
        SpouseName = spouseName;
    }

    @JSONField(name = "Education")
    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    @JSONField(name = "Email")
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @JSONField(name = "LivingStatus")
    public String getLivingStatus() {
        return LivingStatus;
    }

    public void setLivingStatus(String livingStatus) {
        LivingStatus = livingStatus;
    }

    @JSONField(name = "RegisteredHouse")
    public String getRegisteredHouse() {
        return RegisteredHouse;
    }

    public void setRegisteredHouse(String registeredHouse) {
        RegisteredHouse = registeredHouse;
    }

    @JSONField(name = "RegisteredPlace")
    public String getRegisteredPlace() {
        return RegisteredPlace;
    }

    public void setRegisteredPlace(String registeredPlace) {
        RegisteredPlace = registeredPlace;
    }

    @JSONField(name = "CheckDate")
    public String getCheckDate() {
        return CheckDate;
    }

    public void setCheckDate(String checkDate) {
        CheckDate = checkDate;
    }

    @JSONField(name = "AddressType")
    public String getAddressType() {
        return AddressType;
    }

    public void setAddressType(String addressType) {
        AddressType = addressType;
    }

    @JSONField(name = "SpouseCertType")
    public String getSpouseCertType() {
        return SpouseCertType;
    }

    public void setSpouseCertType(String spouseCertType) {
        SpouseCertType = spouseCertType;
    }

    @JSONField(name = "SpouseCertNo")
    public String getSpouseCertNo() {
        return SpouseCertNo;
    }

    public void setSpouseCertNo(String spouseCertNo) {
        SpouseCertNo = spouseCertNo;
    }

    @JSONField(name = "SpouseMobile")
    public String getSpouseMobile() {
        return SpouseMobile;
    }

    public void setSpouseMobile(String spouseMobile) {
        SpouseMobile = spouseMobile;
    }

    @JSONField(name = "CustFlag")
    public String getCustFlag() {
        return CustFlag;
    }

    public void setCustFlag(String custFlag) {
        CustFlag = custFlag;
    }

    @JSONField(name = "RegCertCode")
    public String getRegCertCode() {
        return RegCertCode;
    }

    public void setRegCertCode(String regCertCode) {
        RegCertCode = regCertCode;
    }

    @JSONField(name = "ManageName")
    public String getManageName() {
        return ManageName;
    }

    public void setManageName(String manageName) {
        ManageName = manageName;
    }

    @JSONField(name = "ManageOwner")
    public String getManageOwner() {
        return ManageOwner;
    }

    public void setManageOwner(String manageOwner) {
        ManageOwner = manageOwner;
    }

    @JSONField(name = "ManageAddressId")
    public String getManageAddressId() {
        return ManageAddressId;
    }

    public void setManageAddressId(String manageAddressId) {
        ManageAddressId = manageAddressId;
    }

    @JSONField(name = "ManageYear")
    public String getManageYear() {
        return ManageYear;
    }

    public void setManageYear(String manageYear) {
        ManageYear = manageYear;
    }

    @JSONField(name = "ManageAddress")
    public String getManageAddress() {
        return ManageAddress;
    }

    public void setManageAddress(String manageAddress) {
        ManageAddress = manageAddress;
    }

    @JSONField(name = "ManageTrade")
    public String getManageTrade() {
        return ManageTrade;
    }

    public void setManageTrade(String manageTrade) {
        ManageTrade = manageTrade;
    }

    @JSONField(name = "ManageTradeName")
    public String getManageTradeName() {
        return ManageTradeName;
    }

    public void setManageTradeName(String manageTradeName) {
        ManageTradeName = manageTradeName;
    }

    @JSONField(name = "ManageIncome")
    public String getManageIncome() {
        return ManageIncome;
    }

    public void setManageIncome(String manageIncome) {
        ManageIncome = manageIncome;
    }

    @JSONField(name = "ManageEmployee")
    public String getManageEmployee() {
        return ManageEmployee;
    }

    public void setManageEmployee(String manageEmployee) {
        ManageEmployee = manageEmployee;
    }

    @JSONField(name = "CommpannyName")
    public String getCommpannyName() {
        return CommpannyName;
    }

    public void setCommpannyName(String commpannyName) {
        CommpannyName = commpannyName;
    }

    @JSONField(name = "CommpannyTrade")
    public String getCommpannyTrade() {
        return CommpannyTrade;
    }

    public void setCommpannyTrade(String commpannyTrade) {
        CommpannyTrade = commpannyTrade;
    }

    @JSONField(name = "CommpannyTradeName")
    public String getCommpannyTradeName() {
        return CommpannyTradeName;
    }

    public void setCommpannyTradeName(String commpannyTradeName) {
        CommpannyTradeName = commpannyTradeName;
    }

    @JSONField(name = "CommpannyType")
    public String getCommpannyType() {
        return CommpannyType;
    }

    public void setCommpannyType(String commpannyType) {
        CommpannyType = commpannyType;
    }

    @JSONField(name = "CommpannyAddressId")
    public String getCommpannyAddressId() {
        return CommpannyAddressId;
    }

    public void setCommpannyAddressId(String commpannyAddressId) {
        CommpannyAddressId = commpannyAddressId;
    }

    @JSONField(name = "CommpannyStr")
    public String getCommpannyStr() {
        return CommpannyStr;
    }

    public void setCommpannyStr(String commpannyStr) {
        CommpannyStr = commpannyStr;
    }

    @JSONField(name = "CommpannyAddress")
    public String getCommpannyAddress() {
        return CommpannyAddress;
    }

    public void setCommpannyAddress(String commpannyAddress) {
        CommpannyAddress = commpannyAddress;
    }

    @JSONField(name = "CommpannyPhone")
    public String getCommpannyPhone() {
        return CommpannyPhone;
    }

    public void setCommpannyPhone(String commpannyPhone) {
        CommpannyPhone = commpannyPhone;
    }

    @JSONField(name = "CommLoanIncome")
    public String getCommLoanIncome() {
        return CommLoanIncome;
    }

    public void setCommLoanIncome(String commLoanIncome) {
        CommLoanIncome = commLoanIncome;
    }

    @JSONField(name = "CommpannyYear")
    public String getCommpannyYear() {
        return CommpannyYear;
    }

    public void setCommpannyYear(String commpannyYear) {
        CommpannyYear = commpannyYear;
    }

    @JSONField(name = "CommpannyJob")
    public String getCommpannyJob() {
        return CommpannyJob;
    }

    public void setCommpannyJob(String commpannyJob) {
        CommpannyJob = commpannyJob;
    }

    @JSONField(name = "CommpannyTitle")
    public String getCommpannyTitle() {
        return CommpannyTitle;
    }

    public void setCommpannyTitle(String commpannyTitle) {
        CommpannyTitle = commpannyTitle;
    }

    @JSONField(name = "CommpannyVocation")
    public String getCommpannyVocation() {
        return CommpannyVocation;
    }

    public void setCommpannyVocation(String commpannyVocation) {
        CommpannyVocation = commpannyVocation;
    }

    @JSONField(name = "CommpannyPost")
    public String getCommpannyPost() {
        return CommpannyPost;
    }

    public void setCommpannyPost(String commpannyPost) {
        CommpannyPost = commpannyPost;
    }

    @JSONField(name = "Product")
    public String getProduct() {
        return Product;
    }

    public void setProduct(String product) {
        Product = product;
    }

    @JSONField(name = "CreditAmt")
    public String getCreditAmt() {
        return CreditAmt;
    }

    public void setCreditAmt(String creditAmt) {
        CreditAmt = creditAmt;
    }

    @JSONField(name = "RepayType")
    public String getRepayType() {
        return RepayType;
    }

    public void setRepayType(String repayType) {
        RepayType = repayType;
    }

    @JSONField(name = "ApplyTerm")
    public String getApplyTerm() {
        return ApplyTerm;
    }

    public void setApplyTerm(String applyTerm) {
        ApplyTerm = applyTerm;
    }

    @JSONField(name = "RepaySource")
    public String getRepaySource() {
        return RepaySource;
    }

    public void setRepaySource(String repaySource) {
        RepaySource = repaySource;
    }

    @JSONField(name = "PayDay")
    public String getPayDay() {
        return PayDay;
    }

    public void setPayDay(String payDay) {
        PayDay = payDay;
    }

    @JSONField(name = "PayDistance")
    public String getPayDistance() {
        return PayDistance;
    }

    public void setPayDistance(String payDistance) {
        PayDistance = payDistance;
    }

    @JSONField(name = "AssureMeansMain")
    public String getAssureMeansMain() {
        return AssureMeansMain;
    }

    public void setAssureMeansMain(String assureMeansMain) {
        AssureMeansMain = assureMeansMain;
    }

    @JSONField(name = "PayType")
    public String getPayType() {
        return PayType;
    }

    public void setPayType(String payType) {
        PayType = payType;
    }

    @JSONField(name = "LoanUse")
    public String getLoanUse() {
        return LoanUse;
    }

    public void setLoanUse(String loanUse) {
        LoanUse = loanUse;
    }

    @JSONField(name = "ApplyChannel")
    public String getApplyChannel() {
        return ApplyChannel;
    }

    public void setApplyChannel(String applyChannel) {
        ApplyChannel = applyChannel;
    }

    @JSONField(name = "CustRelDto")
    public List<CustRelReqDto> getCustRelDto() {
        return CustRelDto;
    }

    public void setCustRelDto(List<CustRelReqDto> custRelDto) {
        CustRelDto = custRelDto;
    }

    @JSONField(name = "OrderInfoDto")
    public List<OrderInfoReqDto> getOrderInfoDto() {
        return OrderInfoDto;
    }

    public void setOrderInfoDto(List<OrderInfoReqDto> orderInfoDto) {
        OrderInfoDto = orderInfoDto;
    }

    @JSONField(name = "EntrustDto")
    public List<EntrustReqDto> getEntrustDto() {
        return EntrustDto;
    }

    public void setEntrustDto(List<EntrustReqDto> entrustDto) {
        EntrustDto = entrustDto;
    }

    @JSONField(name = "FileDto")
    public List<FileReqDto> getFileDto() {
        return FileDto;
    }

    public void setFileDto(List<FileReqDto> fileDto) {
        FileDto = fileDto;
    }

    @JSONField(name = "FinancRate")
    public String getFinancRate() {
        return FinancRate;
    }

    public void setFinancRate(String financRate) {
        FinancRate = financRate;
    }

    @JSONField(name = "IsCircle")
    public String getIsCircle() {
        return IsCircle;
    }

    public void setIsCircle(String isCircle) {
        IsCircle = isCircle;
    }

    @JSONField(name = "IsMultiLoan")
    public String getIsMultiLoan() {
        return IsMultiLoan;
    }

    public void setIsMultiLoan(String isMultiLoan) {
        IsMultiLoan = isMultiLoan;
    }

    @JSONField(name = "AuditDatas")
    public String getAuditDatas() {
        return AuditDatas;
    }

    public void setAuditDatas(String auditDatas) {
        AuditDatas = auditDatas;
    }

    @JSONField(name = "LoanNo")
    public String getLoanNo() {
        return LoanNo;
    }

    public void setLoanNo(String loanNo) {
        LoanNo = loanNo;
    }
}

package rxt.bsb.front.test;

import com.alibaba.fastjson.JSONObject;
import constant.BankTransInfoEnum;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rxt.bsb.api.dto.request.*;
import rxt.bsb.api.dto.request.credit.*;
import rxt.bsb.api.dto.request.entity.*;
import rxt.bsb.api.dto.request.notice.ContractSignReqDto;
import rxt.bsb.api.dto.request.query.*;
import rxt.bsb.api.dto.response.credit.CreditApplyResDto;
import rxt.bsb.api.dto.response.notice.NotifyResultResDto;
import rxt.bsb.front.RxtBsbFrontApplication;
import rxt.bsb.front.server.RxtBsbOperatorServerImp;
import rxt.bsb.front.service.LogService;
import vo.InterfaceRespVo;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:wangjian@rokesoft.com">alw</a>
 * @Copyright (c)</ b> 2012融信通-版权所有<br/>
 * @createTime: 2019/9/17 15:17
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RxtBsbFrontApplication.class})// 指定启动类
public class rxtBsbTest {

    public String subAcctNoPersonal = "9956760999679500000003";//个人资金账号
    public String subAcctNoEnterprise = "9956760999679500000007";//企业资金账号
    public String acctNo = "";//银行卡号

    @Autowired
    public RxtBsbOperatorServerImp rxtBsbOperatorServerImp;

    @Autowired
    public LogService logService;


    /**
     * @功能描述：开个人账户
     * @developer：zhanggaoqun
     * @date：2019年1月30日 上午10:35:33
     * void
     */
    @Test
    public void openPersonalAcct() {
//        OpenPersonalAcctReqDto openPersonalAcct = new OpenPersonalAcctReqDto();
//        openPersonalAcct.setCertType("01");
//        openPersonalAcct.setEmail("876733048@qq.com");
//        openPersonalAcct.setCustName("宋小");
//        openPersonalAcct.setMobileNo("13525677809");
//        openPersonalAcct.setCertNo("150429198606152126");
//        openPersonalAcct.setCustNo("01240113");
//        openPersonalAcct.setRepayAcctFlag("");
//        OpenPersonalAcctReqDto openPersonalAcct = new OpenPersonalAcctReqDto();
//        openPersonalAcct.setCertType("01");
//        openPersonalAcct.setEmail("876733048@qq.com");
//        openPersonalAcct.setCustName("全渠道");
//        openPersonalAcct.setMobileNo("13552535506");
//        openPersonalAcct.setCertNo("341126197709218366");
//        openPersonalAcct.setCustNo("01240114");
//        openPersonalAcct.setRepayAcctFlag("");
        OpenPersonalAcctReqDto openPersonalAcct = new OpenPersonalAcctReqDto();
        openPersonalAcct.setCustNo("01240113");
        openPersonalAcct.setCustName("宋小");
        openPersonalAcct.setCertType("01");
        openPersonalAcct.setCertNo("150429198606152126");
        openPersonalAcct.setMobileNo("13525677809");
        openPersonalAcct.setEmail("876733048@qq.com");
        openPersonalAcct.setRepayAcctFlag("1");
        openPersonalAcct.setCertValidDate("20221230");//证件有效期
        openPersonalAcct.setRegisteredPlace("");//注册地
        openPersonalAcct.setBusinessPlace("");//
        openPersonalAcct.setNationality("01");//国籍
        openPersonalAcct.setAcctType("");//


//        OpenPersonalAcctReqDto openPersonalAcct = new OpenPersonalAcctReqDto();
//        openPersonalAcct.setCertType("01");//证件类型
//        openPersonalAcct.setEmail("876733048@qq.com");//邮箱
//        openPersonalAcct.setCustName("全渠道");//用户姓名
//        openPersonalAcct.setMobileNo("13552535506");//手机号
//        openPersonalAcct.setCertNo("341126197709218366");//证件号码
//        openPersonalAcct.setCustNo("01240110");//平台会员号
//        openPersonalAcct.setRepayAcctFlag("1");//是否开通回款账户 0否 1是
        InterfaceRespVo<OpenPersonalAcctReqDto> response =
                rxtBsbOperatorServerImp.openPersonalAcct(openPersonalAcct);

        //OpenPersonalAcctRespBody respBody = JSONObject.parseObject(response.getBody(),OpenPersonalAcctRespBody.class);
        //System.out.println("AuthTokenID："+response.getHead().getAuthTokenID());
        //System.out.println("AuthURL："+response.getHead().getAuthURL());
        //System.out.println("ChanCode："+response.getHead().getChanCode());
        //System.out.println("CustCode："+response.getHead().getCustCode());
        //System.out.println("FunCode："+response.getHead().getFunCode());
        //System.out.println("MerAcctNo："+response.getHead().getMerAcctNo());
        //System.out.println("MerCode："+response.getHead().getMerCode());
        //System.out.println("MerCurrCode："+response.getHead().getMerCurrCode());
        //System.out.println("RetCode："+response.getHead().getRetCode());
        //System.out.println("RetInfo："+response.getHead().getRetInfo());
        //System.out.println("SerialNo："+response.getHead().getSerialNo());
        //System.out.println("TransDate："+response.getHead().getTransDate());
        //System.out.println("TransTime："+response.getHead().getTransTime());
        //System.out.println("respBody.getAuthTokenID："+respBody.getAuthTokenID());
        //System.out.println("respBody.getAuthURL："+respBody.getAuthURL());
        //System.out.println("respBody.getRetCode："+respBody.getRetCode());
        //System.out.println("respBody.getRetInfo："+respBody.getRetInfo());
        System.out.println("参数校验完毕");
    }

    /**
     * @功能描述：个人会员交易密码重置
     * @developer：zhanggaoqun
     * @date：2019年1月30日 上午10:36:21
     * void
     */
    @Test
    public void personalResetPwd() {
        ResetPwdReqDto resetPwdReqDto = new ResetPwdReqDto();
        resetPwdReqDto.setSubAcctNo("9956760999679500000013");//资金账号
        InterfaceRespVo<ResetPwdReqDto> response =
                rxtBsbOperatorServerImp.resetPwd(resetPwdReqDto, BankTransInfoEnum.个人密码重置);
        //OpenPersonalAcctRespBody respBody = JSONObject.parseObject(response.getBody(),OpenPersonalAcctRespBody.class);
    }

    /**
     * @功能描述：个人会员手机号码修改
     * @developer：zhanggaoqun
     * @date：2019年1月30日 上午10:36:21
     * void
     */
    @Test
    public void personalModifyMobile() {
        ModifyMobileReqDto modifyMobileReqDto = new ModifyMobileReqDto();
        modifyMobileReqDto.setSubAcctNo("9956760999679500000013");//资金账号
        modifyMobileReqDto.setNewMobileNo("13525677809");//新手机号
        InterfaceRespVo<ModifyMobileReqDto> response =
                rxtBsbOperatorServerImp.modifyMobile(modifyMobileReqDto, BankTransInfoEnum.个人手机号码修改);
        //OpenPersonalAcctRespBody respBody = JSONObject.parseObject(response.getBody(),OpenPersonalAcctRespBody.class);
    }

    //个人会员支付认证
    @Test
    public void personPayAuthentication() {
        PersonPayAuthenticationReqDto personPayAuthenticationReqDto = new PersonPayAuthenticationReqDto();
        personPayAuthenticationReqDto.setSubAcctNo("9956760999679500000013"); //资金账号
        personPayAuthenticationReqDto.setBindAcctNo("6216261000000009274");  //认证卡号
        InterfaceRespVo<NotifyResultResDto> response =
                rxtBsbOperatorServerImp.personPayAuthentication(personPayAuthenticationReqDto);
        //OpenPersonalAcctRespBody respBody = JSONObject.parseObject(response.getBody(),OpenPersonalAcctRespBody.class);
    }

    /**
     * @功能描述：个人会员银行卡绑定
     * @developer：zhanggaoqun
     * @date：2019年1月31日 上午10:38:36
     * void
     */
    @Test
    public void personalBindAcctNo() {
        BindAcctNoReqDto bindAcctNoReqDto = new BindAcctNoReqDto();
        bindAcctNoReqDto.setSubAcctNo("9956760999679500000013");//资金账号
//        bindAcctNoReqDto.setBank("平安银行");//开户银行
        bindAcctNoReqDto.setBindAcctNo("6216261000000009274");//绑定卡号
        bindAcctNoReqDto.setBindBankName("平安银行");//绑定卡行名
        bindAcctNoReqDto.setBindBankNo("307584007998");//绑定卡行号
//        bindAcctNoReqDto.setSubAcctNo("9956760999679500000011");//资金账号
//        bindAcctNoReqDto.setBank("平安银行");//开户银行
//        bindAcctNoReqDto.setBindAcctNo("6216261000000009274");//绑定卡号
//        bindAcctNoReqDto.setBindBankName("平安银行");//绑定卡行名
//        bindAcctNoReqDto.setBindBankNo("307584007998");//绑定卡行号
        InterfaceRespVo<BindAcctNoReqDto> response =
                rxtBsbOperatorServerImp.bindAcctNo(bindAcctNoReqDto, BankTransInfoEnum.个人会员银行卡绑定);
        //OpenPersonalAcctRespBody respBody = JSONObject.parseObject(response.getBody(),OpenPersonalAcctRespBody.class);
    }

    //个人会员代扣协议签约
    @Test
    public void personMemberAgreementSign() {
        PersonPayAuthenticationReqDto personPayAuthenticationReqDto = new PersonPayAuthenticationReqDto();
        personPayAuthenticationReqDto.setSubAcctNo("9956760999679500000013");
        personPayAuthenticationReqDto.setBindAcctNo("6216261000000009274");

        InterfaceRespVo<NotifyResultResDto> response =
                rxtBsbOperatorServerImp.personMemberAgreementSign(personPayAuthenticationReqDto);
        //OpenPersonalAcctRespBody respBody = JSONObject.parseObject(response.getBody(),OpenPersonalAcctRespBody.class);
    }

    //个人会员银行卡解绑
    @Test
    public void unBindAcctNoPersonal() {
        UnBindAcctNoReqDto unBindAcctNoReqDto = new UnBindAcctNoReqDto();
//        unBindAcctNoReqDto.setSubAcctNo("9956760999679500000006");//资金账号
//        unBindAcctNoReqDto.setBindAcctNo("62176022090190044");//解绑银行卡号
        unBindAcctNoReqDto.setSubAcctNo("9956760999679500000013");//资金账号
        unBindAcctNoReqDto.setBindAcctNo("6216261000000009274");//解绑银行卡号
        InterfaceRespVo<UnBindAcctNoReqDto> response = rxtBsbOperatorServerImp.unbindAcctNo(unBindAcctNoReqDto,
                BankTransInfoEnum.个人会员银行卡解绑);
    }

    /**
     * 个人会员充值入金
     */
    @Test
    public void rechargePersonal() {
//		RechargePersonalReqDto rechargePersonalReqDto = new RechargePersonalReqDto();
//		rechargePersonalReqDto.setSubAcctNo("9956760999679500000003");//资金账号
//		rechargePersonalReqDto.setOppAcctNo("6228480783031210225");//出金方账号
//		rechargePersonalReqDto.setOppAcctName("王二");//出金方户名
//		rechargePersonalReqDto.setOppBankNo("103126080105");//出金方行号
//		rechargePersonalReqDto.setOppBankName("中国农业银行");//出金方银行名称
//		rechargePersonalReqDto.setRealPayAmt("100");//入金金额
//		rechargePersonalReqDto.setPostScript("入金测试");//附言
        RechargePersonalReqDto rechargePersonalReqDto = new RechargePersonalReqDto();
//        rechargePersonalReqDto.setSubAcctNo("9956760999679500000006");//资金账号
//        rechargePersonalReqDto.setOppAcctNo("62176022090190044");//出金方账号
//        rechargePersonalReqDto.setOppAcctName("包商金融0022");//出金方户名
//        rechargePersonalReqDto.setOppBankNo("313192000013");//出金方行号
//        rechargePersonalReqDto.setOppBankName("包商银行股份有限公司");//出金方银行名称
//        rechargePersonalReqDto.setRealPayAmt("100");//入金金额
//        rechargePersonalReqDto.setPostScript("入金测试");//附言
        rechargePersonalReqDto.setSubAcctNo("9956760999679500000011");//资金账号
        rechargePersonalReqDto.setOppAcctNo("6216261000000009274");//出金方账号
        rechargePersonalReqDto.setOppAcctName("宋小");//出金方户名
        rechargePersonalReqDto.setOppBankNo("307584007998");//出金方行号
        rechargePersonalReqDto.setOppBankName("平安银行");//出金方银行名称
        rechargePersonalReqDto.setRealPayAmt("100");//入金金额
        rechargePersonalReqDto.setPostScript("入金测试");//附言
        InterfaceRespVo<RechargePersonalReqDto> response =
                rxtBsbOperatorServerImp.rechargePersonal(rechargePersonalReqDto,
                        BankTransInfoEnum.个人会员资金账户线上转账充值入金);
    }

    /**
     * 个人会员体现出金
     */
    @Test
    public void cashWithdrawalPersonal() {
        List<FeeList> feeList = new ArrayList<>();
        FeeList fee = new FeeList();
        fee.setFeeCode("030301");//费用编号
        fee.setFeeAmt("1.00");//费用金额
        feeList.add(fee);
        CashWithdrawalReqDto cashWithdrawalReqDto = new CashWithdrawalReqDto();
        cashWithdrawalReqDto.setSubAcctNo("9956760999679500000011");//资金账号
        cashWithdrawalReqDto.setRcvAcctNo("6216261000000009274");//收款账号
        cashWithdrawalReqDto.setRcvAcctName("宋小");//收款户名
        cashWithdrawalReqDto.setRcvBankNo("307584007998");//收款行号
        cashWithdrawalReqDto.setRcvBankName("平安银行");//收款行名
        cashWithdrawalReqDto.setOperFlag("0");//提现类型(0:实时提现,1:提现申请（暂不支持）)
        cashWithdrawalReqDto.setAmount("10.00");//交易金额
        cashWithdrawalReqDto.setFeeList(feeList);//
        cashWithdrawalReqDto.setPostScript("");//交易附言
        InterfaceRespVo<CashWithdrawalReqDto> response =
                rxtBsbOperatorServerImp.cashWithdrawal(cashWithdrawalReqDto, BankTransInfoEnum.个人会员资金账户提现出金);
    }

    /**
     * 会员批量出金
     */
    @Test
    public void batchPayment() {
        BatchPaymentReqDto batchPaymentReqDto = new BatchPaymentReqDto();
        batchPaymentReqDto.setSubAcctNo("9956760999679500000011");  //付款资金账号
        batchPaymentReqDto.setOperFlag("0");  //操作标识
        batchPaymentReqDto.setAmount("20.02");  //批量出金总金额
        batchPaymentReqDto.setCount("2");  //批量出金收款方总个数

        ArrayList<BatchPaymentReqDto.BatchWithdrawInfoListBean> list1 = new ArrayList<>();
        BatchPaymentReqDto.BatchWithdrawInfoListBean batchWithdrawInfoListBean1 = new BatchPaymentReqDto.BatchWithdrawInfoListBean();
        batchWithdrawInfoListBean1.setBatchAcctNo("6216261000000009274");  //收款账号
        batchWithdrawInfoListBean1.setBatchAcctName("宋小");  //收款账户名
        batchWithdrawInfoListBean1.setBatchAmt("10.01");  //批次金额
        batchWithdrawInfoListBean1.setBatchOrderNo("232132131231231232");  //批次流水号
        batchWithdrawInfoListBean1.setBatchBankNo("307584007998");  //行号
        batchWithdrawInfoListBean1.setBatchBankName("平安银行");  //行名
        batchWithdrawInfoListBean1.setBatchPostScript("交易附言1");  //交易附言
        BatchPaymentReqDto.BatchWithdrawInfoListBean.FeeListBean feeListBean1 = new BatchPaymentReqDto.BatchWithdrawInfoListBean.FeeListBean();
        feeListBean1.setFeeCode("030301");
        feeListBean1.setFeeAmt("1.01");
        ArrayList<BatchPaymentReqDto.BatchWithdrawInfoListBean.FeeListBean> list2 = new ArrayList<>();
        list2.add(feeListBean1);
        batchWithdrawInfoListBean1.setFeeList(list2);
        list1.add(batchWithdrawInfoListBean1);

        BatchPaymentReqDto.BatchWithdrawInfoListBean batchWithdrawInfoListBean2 = new BatchPaymentReqDto.BatchWithdrawInfoListBean();
        batchWithdrawInfoListBean2.setBatchAcctNo("6216261000000009274");  //收款账号
        batchWithdrawInfoListBean2.setBatchAcctName("宋小");  //收款账户名
        batchWithdrawInfoListBean2.setBatchAmt("10.01");  //批次金额
        batchWithdrawInfoListBean2.setBatchOrderNo("2321321312312312321");  //批次流水号
        batchWithdrawInfoListBean2.setBatchBankNo("307584007998");  //行号
        batchWithdrawInfoListBean2.setBatchBankName("平安银行");  //行名
        batchWithdrawInfoListBean2.setBatchPostScript("交易附言2");  //交易附言
        BatchPaymentReqDto.BatchWithdrawInfoListBean.FeeListBean feeListBean2 = new BatchPaymentReqDto.BatchWithdrawInfoListBean.FeeListBean();
        feeListBean2.setFeeCode("030301");
        feeListBean2.setFeeAmt("1.01");
        ArrayList<BatchPaymentReqDto.BatchWithdrawInfoListBean.FeeListBean> list3 = new ArrayList<>();
        list3.add(feeListBean2);
        batchWithdrawInfoListBean2.setFeeList(list3);
        list1.add(batchWithdrawInfoListBean2);

        batchPaymentReqDto.setBatchWithdrawInfoList(list1);
        InterfaceRespVo<BatchPaymentReqDto> batchPaymentReqDtoInterfaceRespVo =
                rxtBsbOperatorServerImp.batchPayment(batchPaymentReqDto,
                        BankTransInfoEnum.会员批量出金);

    }

    /**
     * 个人订单单笔即时支付
     */
    @Test
    public void personalSingleOrderPayDown() {
        SingleOrderPayDownReqDto singleOrderPayDownReqDto = new SingleOrderPayDownReqDto();
        singleOrderPayDownReqDto.setPaySubAcctNo("9956760999679500000011");//付款资金账号,最大长度32
        singleOrderPayDownReqDto.setRcvSubAcctNo("9956760999679500000012");//收款资金账号,最大长度32

        List<SingleOrderGood> goodList = new ArrayList<>();
        SingleOrderGood singleOrderGood = new SingleOrderGood();
        singleOrderGood.setGoodsSpec("短期10天");//商品规格,最大长度64
        singleOrderGood.setGoodsName("易支付");//商品名称,最大长度200
        singleOrderGood.setPostScript("商品交易");//交易附言,最大长度10
        singleOrderGood.setGoodsNum("1");//商品数量,最大长度16,2位
        String b4 = "1.01";
        singleOrderGood.setGoodsPrice(b4);//商品单价,最大长度16,2位
        String b3 = Double.parseDouble(b4) * 1 + "";
        singleOrderGood.setGoodsAmt(b3);//商品金额,最大长度100
        singleOrderGood.setGoodsRemark("低风险");//商品备注,最大长度255
        singleOrderGood.setGoodsID("001");//商品编号,最大长度255
        goodList.add(singleOrderGood);
        singleOrderPayDownReqDto.setGoodList(goodList);

        List<SingleOrderFee> feeList = new ArrayList<>();
        SingleOrderFee singleOrderFee = new SingleOrderFee();
        singleOrderFee.setFeeCode("030301");//费用编号,最大长度6
        String b5 = "1.01";
        singleOrderFee.setFeeAmt(b5);//费用金额,最大长度16,2位
        feeList.add(singleOrderFee);
        singleOrderPayDownReqDto.setFeeList(feeList);
        String b1 = b3;
        singleOrderPayDownReqDto.setTotalAmt(b1);//订单总额,最大长度16,2位
        singleOrderPayDownReqDto.setBPAmt("");//积分抵扣金额,最大长度16,2位
        singleOrderPayDownReqDto.setRedPackAmt("");//红包抵扣金额,最大长度16,2位
        singleOrderPayDownReqDto.setCouponAmt("");//卡券抵扣金额,最大长度16,2位
        String b2 = b1 + b5;
        singleOrderPayDownReqDto.setRealPayAmt(b2);//实付金额,最大长度16,2位
        InterfaceRespVo<SingleOrderPayDownReqDto> response =
                rxtBsbOperatorServerImp.singleOrderPayDown(singleOrderPayDownReqDto,
                        BankTransInfoEnum.个人订单单笔即时支付);
    }

    /**
     * 个人订单批量即时支付
     */
    @Test
    public void personalBatchOrderPayDown() {
        PersonalBatchOrderPayDownReqDto personalBatchOrderPayDownReqDto = new PersonalBatchOrderPayDownReqDto();
        personalBatchOrderPayDownReqDto.setPaySubAcctNo("9956760999679500000011");//付款资金账号,最大长度32
        List<BatchOrderGood> goodList = new ArrayList<>();
        BatchOrderGood batchOrderGood = new BatchOrderGood();
        batchOrderGood.setGoodsID("000123");//商品编号,最大长度255
        batchOrderGood.setGoodsSpec("灰色");//商品规格,最大长度64
        batchOrderGood.setGoodsName("鼠标");//商品名称,最大长度200
        batchOrderGood.setGoodsNum("1");//商品数量,最大长度16,2位
        BigDecimal b1 = new BigDecimal("1.01");
        batchOrderGood.setGoodsPrice(b1);//商品单价,最大长度16,2位
        BigDecimal b2 = b1.multiply(new BigDecimal("1"));
        batchOrderGood.setGoodsAmt(b2);//商品金额,最大长度100
        batchOrderGood.setGoodsRemark("");//商品备注,最大长度255
        goodList.add(batchOrderGood);
        personalBatchOrderPayDownReqDto.setGoodList(goodList);
        List<BatchOrderFee> feeList = new ArrayList<>();
        BatchOrderFee batchOrderFee = new BatchOrderFee();
        batchOrderFee.setFeeCode("");//费用编号,最大长度6
        String b3 = "";
        batchOrderFee.setFeeAmt(b3);//费用金额,最大长度16,2位
        batchOrderFee.setPostScript("");//交易附言,最大长度10
        feeList.add(batchOrderFee);
        personalBatchOrderPayDownReqDto.setFeeList(feeList);
        List<PersonalBatchColInfoList> batchColInfoList = new ArrayList<>();
        PersonalBatchColInfoList personalBatchColInfoList = new PersonalBatchColInfoList();
        personalBatchColInfoList.setRecFundAcctNo("9956760999679500000012");//收款账户,最大长度32
        personalBatchColInfoList.setSubOrderNo("000147");//商户子订单号,最大长度32
        personalBatchColInfoList.setRedPackAmt(null);//红包抵扣金额,最大长度16,2位
        personalBatchColInfoList.setCouponAmt(null);//卡券抵扣金额,最大长度16,2位
        personalBatchColInfoList.setBPAmt(null);//积分抵扣金额,最大长度16,2位
        personalBatchColInfoList.setAmt(b2);//订单总额,最大长度16,2位
        batchColInfoList.add(personalBatchColInfoList);
        personalBatchOrderPayDownReqDto.setBatchColInfoList(batchColInfoList);
        personalBatchOrderPayDownReqDto.setTotalAmt(b2);//订单总额,最大长度16,2位
        personalBatchOrderPayDownReqDto.setRealPayAmt(b2);//实付金额,最大长度16,2位
        InterfaceRespVo<PersonalBatchOrderPayDownReqDto> response =
                rxtBsbOperatorServerImp.personalBatchOrderPayDown(personalBatchOrderPayDownReqDto,
                        BankTransInfoEnum.个人订单批量即时支付);
    }

    /**
     * @功能描述：开企业账户
     * @developer：zhanggaoqun
     * @date：2019年1月30日 上午10:35:45
     * void
     */
    @Test
    public void openEnterpriseAcct() {
//		//开商户
//		OpenEnterpriseAcctReqDto openEnterpriseAcctReqDto = new OpenEnterpriseAcctReqDto();
//		openEnterpriseAcctReqDto.setCustNo("2200014460");//企业代码
//		openEnterpriseAcctReqDto.setCustName("极速云测试账户");//企业名称
//		openEnterpriseAcctReqDto.setCertType("01");//企业证件类型
//		openEnterpriseAcctReqDto.setCertNo("201812268593884072");//企业证件号码
//		openEnterpriseAcctReqDto.setLegalRealName("极速云");//法人代表
//		openEnterpriseAcctReqDto.setLegalCertType("01");//法人证件类型
//		openEnterpriseAcctReqDto.setLegalCertNo("110108196312260135");//法人证件号码
//		openEnterpriseAcctReqDto.setAgentName("赵明");//经办人
//		openEnterpriseAcctReqDto.setAgentCertType("01");//经办人证件类型
//		openEnterpriseAcctReqDto.setAgentCertNo("110101199411070037");//经办人证件号码
//		openEnterpriseAcctReqDto.setAgentMobileNo("18566654484");//经办人手机号码
//		openEnterpriseAcctReqDto.setEmail("954607907@qq.com");//邮箱
//		openEnterpriseAcctReqDto.setRepayAcctFlag("");//还款账户开立标志
        //开监管账户
//        OpenEnterpriseAcctReqDto openEnterpriseAcctReqDto = new OpenEnterpriseAcctReqDto();
//        openEnterpriseAcctReqDto.setCustNo("2200014459");//企业代码
//        openEnterpriseAcctReqDto.setCustName("极速云测试账户");//企业名称
//        openEnterpriseAcctReqDto.setCertType("06");//企业证件类型 01 营业执照 06 组织机构代码 07 社会统一信用证
//        openEnterpriseAcctReqDto.setCertNo("57314776-3");//企业证件号码
//        openEnterpriseAcctReqDto.setLegalRealName("极速云");//法人代表
//        openEnterpriseAcctReqDto.setLegalCertType("01");//法人证件类型
//        openEnterpriseAcctReqDto.setLegalCertNo("110108196312260098");//法人证件号码
//        openEnterpriseAcctReqDto.setAgentName("赵明");//经办人
//        openEnterpriseAcctReqDto.setAgentCertType("01");//经办人证件类型
//        openEnterpriseAcctReqDto.setAgentCertNo("110101199411070037");//经办人证件号码
//        openEnterpriseAcctReqDto.setAgentMobileNo("18566654484");//经办人手机号码
//        openEnterpriseAcctReqDto.setEmail("954607907@qq.com");//邮箱
//        openEnterpriseAcctReqDto.setRepayAcctFlag("");//还款账户开立标志
        //开企业户
        OpenEnterpriseAcctReqDto openEnterpriseAcctReqDto = new OpenEnterpriseAcctReqDto();
        openEnterpriseAcctReqDto.setCustNo("2200014461");//企业代码
        openEnterpriseAcctReqDto.setCustName("极速云企业用户1");//企业名称
        openEnterpriseAcctReqDto.setCertType("01");//企业证件类型
        openEnterpriseAcctReqDto.setCertNo("201812263088311693");//企业证件号码
        openEnterpriseAcctReqDto.setLegalRealName("极速云法人001");//法人代表
        openEnterpriseAcctReqDto.setLegalCertType("01");//法人证件类型
        openEnterpriseAcctReqDto.setLegalCertNo("110108196312260151");//法人证件号码
        openEnterpriseAcctReqDto.setAgentName("赵明");//经办人
        openEnterpriseAcctReqDto.setAgentCertType("01");//经办人证件类型
        openEnterpriseAcctReqDto.setAgentCertNo("110101199411070037");//经办人证件号码
        openEnterpriseAcctReqDto.setAgentMobileNo("18566654484");//经办人手机号码
        openEnterpriseAcctReqDto.setEmail("954607907@qq.com");//邮箱
        openEnterpriseAcctReqDto.setRepayAcctFlag("1");//还款账户开立标志
        InterfaceRespVo<OpenEnterpriseAcctReqDto> response =
                rxtBsbOperatorServerImp.openEnterpriseAcct(openEnterpriseAcctReqDto);
        //OpenPersonalAcctRespBody respBody = JSONObject.parseObject(response.getBody(),OpenPersonalAcctRespBody.class);
    }


    /**
     * @功能描述：企业会员交易密码重置
     * @developer：zhanggaoqun
     * @date：2019年1月30日 上午10:36:21
     * void
     */
    @Test
    public void enterpriseResetPwd() {
        ResetPwdReqDto resetPwdReqDto = new ResetPwdReqDto();
        resetPwdReqDto.setSubAcctNo("9956760999679500000015");//资金账号
        InterfaceRespVo<ResetPwdReqDto> response =
                rxtBsbOperatorServerImp.resetPwd(resetPwdReqDto,
                        BankTransInfoEnum.企业密码重置);
        //OpenPersonalAcctRespBody respBody = JSONObject.parseObject(response.getBody(),OpenPersonalAcctRespBody.class);
    }

    /**
     * @功能描述：企业会员手机号码修改
     * @developer：zhanggaoqun
     * @date：2019年1月30日 上午10:36:21
     * void
     */
    @Test
    public void enterpriseModifyMobile() {
        ModifyMobileReqDto modifyMobileReqDto = new ModifyMobileReqDto();
        modifyMobileReqDto.setSubAcctNo("9956760999679500000015");//资金账号
        modifyMobileReqDto.setNewMobileNo("18566654484");//新手机号
        InterfaceRespVo<ModifyMobileReqDto> response =
                rxtBsbOperatorServerImp.modifyMobile(modifyMobileReqDto, BankTransInfoEnum.企业手机号码修改);
        //OpenPersonalAcctRespBody respBody = JSONObject.parseObject(response.getBody(),OpenPersonalAcctRespBody.class);
    }


    /**
     * @功能描述：企业会员银行卡绑定
     * @developer：zhanggaoqun
     * @date：2019年1月31日 上午10:38:36
     * void
     */
    @Test
    public void enterpriseBindAcctNo() {
//        BindAcctNoReqDto bindAcctNoReqDto = new BindAcctNoReqDto();
//        bindAcctNoReqDto.setBank("包商银行股份有限公司");//开户银行
//        bindAcctNoReqDto.setBindAcctNo("609996800");//绑定卡号
//        bindAcctNoReqDto.setBindBankName("包商银行股份有限公司");//绑定卡行名
//        bindAcctNoReqDto.setBindBankNo("313192000013");//绑定卡行号
//        bindAcctNoReqDto.setSubAcctNo("9956760999679500000008");//资金账号
        BindAcctNoReqDto bindAcctNoReqDto = new BindAcctNoReqDto();
//        bindAcctNoReqDto.setBank("包商银行股份有限公司");//开户银行
        bindAcctNoReqDto.setBindAcctNo("609996818");//绑定卡号
        bindAcctNoReqDto.setBindBankName("包商银行股份有限公司");//绑定卡行名
        bindAcctNoReqDto.setBindBankNo("313192000013");//绑定卡行号
        bindAcctNoReqDto.setSubAcctNo("9956760999679500000015");//资金账号
        InterfaceRespVo<BindAcctNoReqDto> response =
                rxtBsbOperatorServerImp.bindAcctNo(bindAcctNoReqDto, BankTransInfoEnum.企业会员结算账户绑定);
        //OpenPersonalAcctRespBody respBody = JSONObject.parseObject(response.getBody(),OpenPersonalAcctRespBody.class);
    }

    /**
     * @功能描述：线上首笔支付认证
     * @developer：zhanggaoqun
     * @date：2019年1月31日 上午10:38:36
     * void
     */
    @Test
    public void firstPayAuthentication() {
//        FirstPayAuthenticationReqDto firstPayAuthenticationReqDto = new FirstPayAuthenticationReqDto();
//        firstPayAuthenticationReqDto.setSubAcctNo("9956760999679500000008");//资金账号
//        firstPayAuthenticationReqDto.setOppAcctName("极速云测试账户");//出金方户名
//        firstPayAuthenticationReqDto.setOppAcctNo("609996800");//出金方账号
//        firstPayAuthenticationReqDto.setOppBankName("包商银行股份有限公司");//出金方银行名称
//        firstPayAuthenticationReqDto.setOppBankNo("313192000013");//出金方行号
        FirstPayAuthenticationReqDto firstPayAuthenticationReqDto = new FirstPayAuthenticationReqDto();
        firstPayAuthenticationReqDto.setSubAcctNo("9956760999679500000015");//资金账号
        firstPayAuthenticationReqDto.setOppAcctName("极速云企业用户1");//出金方户名
        firstPayAuthenticationReqDto.setOppAcctNo("609996818");//出金方账号
        firstPayAuthenticationReqDto.setOppBankName("包商银行股份有限公司");//出金方银行名称
        firstPayAuthenticationReqDto.setOppBankNo("313192000013");//出金方行号
        InterfaceRespVo<FirstPayAuthenticationReqDto> response =
                rxtBsbOperatorServerImp.firstPayAuthentication(firstPayAuthenticationReqDto);
        //OpenPersonalAcctRespBody respBody = JSONObject.parseObject(response.getBody(),OpenPersonalAcctRespBody.class);
    }


    //企业会员结算账户解绑
    @Test
    public void unBindAcctNoEnterprise() {
//        UnBindAcctNoReqDto unBindAcctNoReqDto = new UnBindAcctNoReqDto();
//        unBindAcctNoReqDto.setSubAcctNo("9956760999679500000008");//资金账号
//        unBindAcctNoReqDto.setBindAcctNo("609996800");//解绑银行卡号
        UnBindAcctNoReqDto unBindAcctNoReqDto = new UnBindAcctNoReqDto();
        unBindAcctNoReqDto.setSubAcctNo("9956760999679500000015");//资金账号
        unBindAcctNoReqDto.setBindAcctNo("609996818");//解绑银行卡号
        InterfaceRespVo<UnBindAcctNoReqDto> response =
                rxtBsbOperatorServerImp.unbindAcctNo(unBindAcctNoReqDto, BankTransInfoEnum.企业会员结算账户解绑);
    }


    /**
     * 企业会员充值入金
     */
    @Test
    public void rechargeEnterprise() {
        //企业会员
        RechargeEnterpriseReqDto rechargeEnterpriseReqDto = new RechargeEnterpriseReqDto();
        rechargeEnterpriseReqDto.setSubAcctNo("9956760999679500000015");//资金账号
        rechargeEnterpriseReqDto.setOppAcctNo("609996818");//出金方账号
        rechargeEnterpriseReqDto.setOppAcctName("极速云企业用户1");//出金方户名
        rechargeEnterpriseReqDto.setOppBankNo("313192000013");//出金方行号
        rechargeEnterpriseReqDto.setOppBankName("包商银行股份有限公司");//出金方银行名称
        //商户
//        RechargeEnterpriseReqDto rechargeEnterpriseReqDto = new RechargeEnterpriseReqDto();
//        rechargeEnterpriseReqDto.setSubAcctNo("9956760999679500000008");//资金账号
//        rechargeEnterpriseReqDto.setOppAcctNo("609996800");//出金方账号
//        rechargeEnterpriseReqDto.setOppAcctName("极速云测试账户");//出金方户名
//        rechargeEnterpriseReqDto.setOppBankNo("313192000013");//出金方行号
//        rechargeEnterpriseReqDto.setOppBankName("包商银行股份有限公司");//出金方银行名称
        InterfaceRespVo<RechargeEnterpriseReqDto> response =
                rxtBsbOperatorServerImp.rechargeEnterprise(rechargeEnterpriseReqDto,
                        BankTransInfoEnum.企业会员资金账户线上转账充值入金);
    }


    /**
     * 企业会员提现出金
     */
    @Test
    public void cashWithdrawalEnterprise() {
        List<FeeList> feeList = new ArrayList<>();
        FeeList fee = new FeeList();
        fee.setFeeCode("030301");//费用编号
        fee.setFeeAmt("1.00");//费用金额
        feeList.add(fee);
        CashWithdrawalReqDto cashWithdrawalReqDto = new CashWithdrawalReqDto();
        cashWithdrawalReqDto.setSubAcctNo("9956760999679500000015");//资金账号
        cashWithdrawalReqDto.setRcvAcctNo("609996818");//收款账号
        cashWithdrawalReqDto.setRcvAcctName("极速云企业用户1");//收款户名
        cashWithdrawalReqDto.setRcvBankNo("313192000013");//收款行号
        cashWithdrawalReqDto.setRcvBankName("包商银行股份有限公司");//收款行名
        cashWithdrawalReqDto.setOperFlag("0");//提现类型(0:实时提现,1:提现申请（暂不支持）)
        cashWithdrawalReqDto.setAmount("10.00");//交易金额
        cashWithdrawalReqDto.setFeeList(feeList);//
        cashWithdrawalReqDto.setPostScript("");//交易附言
        InterfaceRespVo<CashWithdrawalReqDto> response =
                rxtBsbOperatorServerImp.cashWithdrawal(cashWithdrawalReqDto, BankTransInfoEnum.企业会员资金账户提现出金);
    }

    /**
     * 商户资金账户提现出金
     */
    @Test
    public void cashWithdrawalMerchant() {
        CashWithdrawalMerchantReqDto cashWithdrawalMerchantReqDto = new CashWithdrawalMerchantReqDto();
        cashWithdrawalMerchantReqDto.setSubAcctNo("9956760999679500000008");//资金账号
        cashWithdrawalMerchantReqDto.setRcvAcctNo("609996800");//收款账号
        cashWithdrawalMerchantReqDto.setRcvAcctName("极速云测试账户");//收款户名
        cashWithdrawalMerchantReqDto.setRcvBankNo("313192000013");//收款行号
        cashWithdrawalMerchantReqDto.setRcvBankName("包商银行股份有限公司");//收款行名
        cashWithdrawalMerchantReqDto.setAmount("10.01");//交易金额
        cashWithdrawalMerchantReqDto.setPostScript("商户提现10.01元");//交易附言
        InterfaceRespVo<CashWithdrawalMerchantReqDto> response =
                rxtBsbOperatorServerImp.cashWithdrawalMerchant(cashWithdrawalMerchantReqDto, BankTransInfoEnum.商户资金账户提现出金);
    }

    /**
     * 企业订单单笔即时支付
     */
    @Test
    public void enterpriseSingleOrderPayDown() {
        SingleOrderPayDownReqDto singleOrderPayDownReqDto = new SingleOrderPayDownReqDto();
        singleOrderPayDownReqDto.setPaySubAcctNo("9956760999679500000008");//付款资金账号,最大长度32
        singleOrderPayDownReqDto.setRcvSubAcctNo("9956760999679500000007");//收款资金账号,最大长度32
        singleOrderPayDownReqDto.setTotalAmt("10.01");//订单总额,最大长度16,2位
        singleOrderPayDownReqDto.setRealPayAmt("10.01");//实付金额,最大长度16,2位
//        singleOrderPayDownReqDto.setBPAmt(null);//积分抵扣金额,最大长度16,2位
//        singleOrderPayDownReqDto.setRedPackAmt(null);//红包抵扣金额,最大长度16,2位
//        singleOrderPayDownReqDto.setCouponAmt(null);//卡券抵扣金额,最大长度16,2位
        List<SingleOrderGood> goodList = new ArrayList<>();
        SingleOrderGood singleOrderGood = new SingleOrderGood();
        singleOrderGood.setGoodsID("002");//商品编号,最大长度255
        singleOrderGood.setGoodsSpec("深空灰 8G 2556SSD");//商品规格,最大长度64
        singleOrderGood.setGoodsName("苹果Macbook Pro");//商品名称,最大长度200
        singleOrderGood.setGoodsAmt("10.01");//商品金额,最大长度100
        singleOrderGood.setGoodsNum("1");//商品数量,最大长度16,2位
        singleOrderGood.setGoodsPrice("10.01");//商品单价,最大长度16,2位
        singleOrderGood.setGoodsRemark("全新");//商品备注,最大长度255
        singleOrderGood.setPostScript("");//交易附言,最大长度10
        goodList.add(singleOrderGood);
        singleOrderPayDownReqDto.setGoodList(goodList);
        List<SingleOrderFee> feeList = new ArrayList<>();
        SingleOrderFee singleOrderFee = new SingleOrderFee();
        singleOrderFee.setFeeCode("030302");//费用编号,最大长度6
        singleOrderFee.setFeeAmt("1.01");//费用金额,最大长度16,2位
        feeList.add(singleOrderFee);
        singleOrderPayDownReqDto.setFeeList(feeList);
        InterfaceRespVo<SingleOrderPayDownReqDto> response =
                rxtBsbOperatorServerImp.singleOrderPayDown(singleOrderPayDownReqDto,
                        BankTransInfoEnum.企业订单单笔即时支付);
    }


    /**
     * 企业订单批量即时支付
     */
    @Test
    public void enterpriseBatchOrderPayDown() {
        EnterpriseBatchOrderPayDownReqDto enterpriseBatchOrderPayDownReqDto = new EnterpriseBatchOrderPayDownReqDto();
        enterpriseBatchOrderPayDownReqDto.setPaySubAcctNo("9956760999679500000008");//付款资金账号,最大长度32
        enterpriseBatchOrderPayDownReqDto.setTotalAmt(new BigDecimal("10.02"));//订单总额,最大长度16,2位
        enterpriseBatchOrderPayDownReqDto.setRealPayAmt(new BigDecimal("10.02"));//实付金额,最大长度16,2位
        List<EnterpriseBatchColInfoList> batchColInfoList = new ArrayList<>();
        EnterpriseBatchColInfoList enterpriseBatchColInfoList = new EnterpriseBatchColInfoList();
        EnterpriseBatchColInfoList enterpriseBatchColInfoList2 = new EnterpriseBatchColInfoList();
        enterpriseBatchColInfoList.setPostScript("");//交易附言,最大长度10
        enterpriseBatchColInfoList.setRecFundAcctNo("9956760999679500000007");//收款账户,最大长度32
        enterpriseBatchColInfoList.setAmt(new BigDecimal("5.01"));//订单总额,最大长度16,2位
        enterpriseBatchColInfoList.setSubOrderNo("0000123");//商户子订单号,最大长度32
        enterpriseBatchColInfoList2.setPostScript("");//交易附言,最大长度10
        enterpriseBatchColInfoList2.setRecFundAcctNo("9956760999679500000007");//收款账户,最大长度32
        enterpriseBatchColInfoList2.setAmt(new BigDecimal("5.01"));//订单总额,最大长度16,2位
        enterpriseBatchColInfoList2.setSubOrderNo("0000124");//商户子订单号,最大长度32
        batchColInfoList.add(enterpriseBatchColInfoList);
        batchColInfoList.add(enterpriseBatchColInfoList2);
        enterpriseBatchOrderPayDownReqDto.setBatchColInfoList(batchColInfoList);
        List<BatchOrderFee> feeList = new ArrayList<>();
        BatchOrderFee batchOrderFee = new BatchOrderFee();
        batchOrderFee.setFeeCode("030302");//费用编号,最大长度6
        batchOrderFee.setFeeAmt("1.01");//费用金额,最大长度16,2位
        batchOrderFee.setPostScript("");//交易附言,最大长度10
        feeList.add(batchOrderFee);
        enterpriseBatchOrderPayDownReqDto.setFeeList(feeList);
        List<BatchOrderGood> good = new ArrayList<>();
        BatchOrderGood batchOrderGood = new BatchOrderGood();
        batchOrderGood.setGoodsID("002");//商品编号,最大长度255
        batchOrderGood.setGoodsName("苹果Macbook Pro");//商品名称,最大长度200
        batchOrderGood.setGoodsSpec("深空灰 8G 256SSD");//商品规格,最大长度64
        batchOrderGood.setGoodsAmt(new BigDecimal("10.02"));//商品金额,最大长度100
        batchOrderGood.setGoodsNum("1");//商品数量,最大长度16,2位
        batchOrderGood.setGoodsPrice(new BigDecimal("10.02"));//商品单价,最大长度16,2位
        batchOrderGood.setGoodsRemark("全新");//商品备注,最大长度255
        good.add(batchOrderGood);
        enterpriseBatchOrderPayDownReqDto.setGoodList(good);
        InterfaceRespVo<EnterpriseBatchOrderPayDownReqDto> response =
                rxtBsbOperatorServerImp.enterpriseBatchOrderPayDown(enterpriseBatchOrderPayDownReqDto,
                        BankTransInfoEnum.企业订单批量即时支付);
    }

    /**
     * 会员订单批量担保支付预付
     */
    @Test
    public void orderBatchGuaranteePrepayment() {
        OrderBatchGuaranteePrepaymentReqDto orderBatchGuaranteePrepaymentReqDto = new OrderBatchGuaranteePrepaymentReqDto();
        orderBatchGuaranteePrepaymentReqDto.setSubAcctNo("9956760999679500000008");//付款资金账号
        orderBatchGuaranteePrepaymentReqDto.setTotalAmt(new BigDecimal("15.01"));//订单总额,最大长度16,2位
        List<BatchGuaranteePrepaymentList> batchColTransList = new ArrayList<>();
        BatchGuaranteePrepaymentList batchGuaranteePrepaymentList = new BatchGuaranteePrepaymentList();
        batchGuaranteePrepaymentList.setRecFundAcctNo("9956760999679500000012");//收款账户,最大长度32
        batchGuaranteePrepaymentList.setBatchAmt(new BigDecimal("15.01"));//批次总额,最大长度16,2位
        batchGuaranteePrepaymentList.setSubOrderNo("123456");//商户子订单号,最大长度32
        batchGuaranteePrepaymentList.setRealPayAmt(new BigDecimal("15.01"));//实付金额,最大长度16,2位
        batchGuaranteePrepaymentList.setPrepayType("0");//预付方式,0:付款冻结（圈存）;1:收款冻结（支付并圈存）
        //batchGuaranteePrepaymentList.setCouponAmt("");//卡券抵扣金额,最大长度16,2位
        //batchGuaranteePrepaymentList.setRedPackAmt("");//红包抵扣金额,最大长度16,2位
        //batchGuaranteePrepaymentList.setBPAmt("");//积分抵扣金额,最大长度16,2位
        batchColTransList.add(batchGuaranteePrepaymentList);
        List<SingleOrderGood> good = new ArrayList<>();
        SingleOrderGood singleOrderGood = new SingleOrderGood();
        singleOrderGood.setGoodsID("333");//商品编号,最大长度255
        singleOrderGood.setGoodsName("周大福2");//商品名称,最大长度200
        singleOrderGood.setGoodsSpec("001");//商品规格,最大长度64
        singleOrderGood.setGoodsAmt("15.01");//商品金额,最大长度100
        singleOrderGood.setGoodsNum("1");//商品数量,最大长度16,2位
        singleOrderGood.setGoodsPrice("15.01");//商品单价,最大长度16,2位
        singleOrderGood.setGoodsRemark("备注");//商品备注,最大长度255
        good.add(singleOrderGood);
        batchGuaranteePrepaymentList.setGoodList(good);
        List<SingleOrderFee> fee = new ArrayList<>();
        SingleOrderFee singleOrderFee = new SingleOrderFee();
        singleOrderFee.setFeeCode("030302");//费用编号,最大长度6
        singleOrderFee.setFeeAmt("1.01");//费用金额,最大长度16,2位
        fee.add(singleOrderFee);
        batchGuaranteePrepaymentList.setFeeList(fee);
        orderBatchGuaranteePrepaymentReqDto.setBatchColTransList(batchColTransList);
        InterfaceRespVo<OrderBatchGuaranteePrepaymentReqDto> response =
                rxtBsbOperatorServerImp.orderBatchGuaranteePrepayment(orderBatchGuaranteePrepaymentReqDto,
                        BankTransInfoEnum.会员订单批量担保支付预付);
    }

    /**
     * 会员订单担保支付确认
     */
    @Test
    public void orderGuaranteedPaymentConfirm() {
        OrderGuaranteedPaymentConfirmReqDto orderGuaranteedPaymentConfirmReqDto = new OrderGuaranteedPaymentConfirmReqDto();
//        orderGuaranteedPaymentConfirmReqDto.setSubAcctNo("9956760999679500000006");//付款资金账号,变长32
//        orderGuaranteedPaymentConfirmReqDto.setOrderNo("20190218114609132");//订单流水号,变长32
//        orderGuaranteedPaymentConfirmReqDto.setSubOrderNo("123456");//订单子流水号,变长32
//        orderGuaranteedPaymentConfirmReqDto.setOrderDate("20190218");//订单流水日期,定长8
//        orderGuaranteedPaymentConfirmReqDto.setPostScript("测试");//交易附言,变长128
        orderGuaranteedPaymentConfirmReqDto.setSubAcctNo("9956760999679500000007");//付款资金账号,变长32
        orderGuaranteedPaymentConfirmReqDto.setOrderNo("20191012105436794");//订单流水号,变长32
        orderGuaranteedPaymentConfirmReqDto.setSubOrderNo("000123");//订单子流水号,变长32
        orderGuaranteedPaymentConfirmReqDto.setOrderDate("20191012");//订单流水日期,定长8
        orderGuaranteedPaymentConfirmReqDto.setPostScript("测试");//交易附言,变长128

        rxtBsbOperatorServerImp.orderGuaranteedPaymentConfirm(orderGuaranteedPaymentConfirmReqDto,
                BankTransInfoEnum.会员订单担保支付确认);
    }


    /**
     * 会员订单担保支付撤销
     */
    @Test
    public void orderGuaranteedPaymentRevoke() {
        OrderGuaranteedPaymentRevokeReqDto orderGuaranteedPaymentRevokeReqDto = new OrderGuaranteedPaymentRevokeReqDto();
        orderGuaranteedPaymentRevokeReqDto.setOrderNo("20191008170426289");//商户流水号,变长32
        orderGuaranteedPaymentRevokeReqDto.setSubOrderNo("123456");//商户子流水号,变长32
        orderGuaranteedPaymentRevokeReqDto.setOrderDate("20191008");//商户交易日期,格式：yyyyMMdd,定长8
        orderGuaranteedPaymentRevokeReqDto.setPostScript("测试");//交易附言,变长128
        InterfaceRespVo<OrderGuaranteedPaymentRevokeReqDto> response =
                rxtBsbOperatorServerImp.orderGuaranteedPaymentRevoke(orderGuaranteedPaymentRevokeReqDto,
                        BankTransInfoEnum.会员订单担保支付撤销);
    }


    //====================================4.4 会员订单加强型 ===========================================

    /**
     * 会员订单加强型单笔即时支付
     */
    @Test
    public void strongSingleOrderPayDown() {
        SingleOrderPayDownReqDto singleOrderPayDownReqDto = new SingleOrderPayDownReqDto();
        singleOrderPayDownReqDto.setOppAcctNo("6216261000000009274"); //银行卡号
        singleOrderPayDownReqDto.setPayType("2"); //支付类型 1、虚账户支付 2、银行卡支付
        singleOrderPayDownReqDto.setPaySubAcctNo("9956760999679500000011");//付款资金账号
        singleOrderPayDownReqDto.setRcvSubAcctNo("9956760999679500000012");//收款资金账号
        singleOrderPayDownReqDto.setTotalAmt("10.01");//订单总额
        singleOrderPayDownReqDto.setRealPayAmt("11.02");//实付金额
//        singleOrderPayDownReqDto.setBPAmt(new BigDecimal("0"));//积分抵扣金额
//        singleOrderPayDownReqDto.setRedPackAmt(new BigDecimal("0"));//红包抵扣金额
//        singleOrderPayDownReqDto.setCouponAmt(new BigDecimal("0"));//卡券抵扣金额

        ArrayList<SingleOrderFee> list1 = new ArrayList<>();
        SingleOrderFee singleOrderFee = new SingleOrderFee();
        singleOrderFee.setFeeCode("030301");//费用编号
        singleOrderFee.setFeeAmt("1.01");//费用金额
        list1.add(singleOrderFee);
        singleOrderPayDownReqDto.setFeeList(list1);

        ArrayList<SingleOrderGood> list2 = new ArrayList<>();
        SingleOrderGood singleOrderGood = new SingleOrderGood();
        singleOrderGood.setGoodsID("002");//商品编号
        singleOrderGood.setGoodsName("MacbookPro");//商品名称
        singleOrderGood.setGoodsSpec("深空灰 8G 256SSD");//商品规格
        singleOrderGood.setGoodsNum("1");//商品数量
        singleOrderGood.setGoodsPrice("10.01");//商品单价
        singleOrderGood.setGoodsAmt("10.01");//商品金额= 商品单价*商品数量
        singleOrderGood.setGoodsRemark("全新");//商品备注
        singleOrderGood.setPostScript("");//交易附言
        list2.add(singleOrderGood);
        singleOrderPayDownReqDto.setGoodList(list2);

        rxtBsbOperatorServerImp.strongSingleOrderPayDown(singleOrderPayDownReqDto,
                BankTransInfoEnum.会员订单加强型单笔即时支付);

    }

    /**
     * 会员订单加强型批量担保支付预付
     */
    @Test
    public void strongOrderBatchGuaranteePrepayment() {
        OrderBatchGuaranteePrepaymentReqDto orderBatchGuaranteePrepaymentReqDto = new OrderBatchGuaranteePrepaymentReqDto();
        orderBatchGuaranteePrepaymentReqDto.setOppAcctNo("609996818");//银行卡号
        orderBatchGuaranteePrepaymentReqDto.setPayType("2");//支付类型 1、虚账户支付 2、银行卡支付
        orderBatchGuaranteePrepaymentReqDto.setSubAcctNo("9956760999679500000007");//付款资金账号
        orderBatchGuaranteePrepaymentReqDto.setTotalAmt(new BigDecimal("10.01"));//订单总金额

        ArrayList<BatchGuaranteePrepaymentList> lists = new ArrayList<>();
        BatchGuaranteePrepaymentList batchGuaranteePrepaymentList = new BatchGuaranteePrepaymentList();
        batchGuaranteePrepaymentList.setRecFundAcctNo("9956760999679500000008");//收款资金账号
        batchGuaranteePrepaymentList.setBatchAmt(new BigDecimal("10.01")); //批次总额
        batchGuaranteePrepaymentList.setSubOrderNo("000123");//商户子订单号
        batchGuaranteePrepaymentList.setRealPayAmt(new BigDecimal("10.01"));//实付金额
//        batchGuaranteePrepaymentList.setRedPackAmt(new BigDecimal("0"));//红包金额
//        batchGuaranteePrepaymentList.setBPAmt(new BigDecimal("0"));//积分金额
//        batchGuaranteePrepaymentList.setCouponAmt(new BigDecimal("0"));//卡券金额
        batchGuaranteePrepaymentList.setPrepayType("1");//预付方式,0:付款冻结（圈存）;1:收款冻结（支付并圈存）

        ArrayList<SingleOrderFee> list1 = new ArrayList<>();
        SingleOrderFee singleOrderFee = new SingleOrderFee();
        singleOrderFee.setFeeCode("030302");//费用编号
        singleOrderFee.setFeeAmt("1.01");//费用金额
        list1.add(singleOrderFee);
        batchGuaranteePrepaymentList.setFeeList(list1);

        ArrayList<SingleOrderGood> list2 = new ArrayList<>();
        SingleOrderGood singleOrderGood = new SingleOrderGood();
        singleOrderGood.setGoodsID("002");//商品编号
        singleOrderGood.setGoodsName("MacbookPro");//商品名称
        singleOrderGood.setGoodsSpec("深空灰 8G 256SSD");//商品规格
        singleOrderGood.setGoodsNum("1");//商品数量
        singleOrderGood.setGoodsPrice("10.01");//商品单价
        singleOrderGood.setGoodsAmt("10.01");//商品金额= 商品单价*商品数量
        singleOrderGood.setGoodsRemark("全新");//商品备注
        singleOrderGood.setPostScript("");//交易附言
        list2.add(singleOrderGood);
        batchGuaranteePrepaymentList.setGoodList(list2);

        lists.add(batchGuaranteePrepaymentList);
        orderBatchGuaranteePrepaymentReqDto.setBatchColTransList(lists);

        rxtBsbOperatorServerImp.strongOrderBatchGuaranteePrepayment(orderBatchGuaranteePrepaymentReqDto,
                BankTransInfoEnum.会员订单加强型批量担保支付预付);

    }

    /**
     * 会员订单加强型批量即时支付
     */
    @Test
    public void strongBatchOrderPayDown() {
        EnterpriseBatchOrderPayDownReqDto enterpriseBatchOrderPayDownReqDto = new EnterpriseBatchOrderPayDownReqDto();
        enterpriseBatchOrderPayDownReqDto.setPaySubAcctNo("9956760999679500000011");//付款资金账号,最大长度32
        enterpriseBatchOrderPayDownReqDto.setPayType("2");
        enterpriseBatchOrderPayDownReqDto.setOppAcctNo("6216261000000009274");
        enterpriseBatchOrderPayDownReqDto.setTotalAmt(new BigDecimal("10.02"));//订单总额,最大长度16,2位
        enterpriseBatchOrderPayDownReqDto.setRealPayAmt(new BigDecimal("10.02"));//实付金额,最大长度16,2位
        List<EnterpriseBatchColInfoList> batchColInfoList = new ArrayList<>();
        EnterpriseBatchColInfoList enterpriseBatchColInfoList = new EnterpriseBatchColInfoList();
        EnterpriseBatchColInfoList enterpriseBatchColInfoList2 = new EnterpriseBatchColInfoList();
        enterpriseBatchColInfoList.setPostScript("");//交易附言,最大长度10
        enterpriseBatchColInfoList.setRecFundAcctNo("9956760999679500000008");//收款账户,最大长度32
        enterpriseBatchColInfoList.setAmt(new BigDecimal("5.01"));//订单总额,最大长度16,2位
        enterpriseBatchColInfoList.setSubOrderNo("0000123");//商户子订单号,最大长度32
        enterpriseBatchColInfoList2.setPostScript("");//交易附言,最大长度10
        enterpriseBatchColInfoList2.setRecFundAcctNo("9956760999679500000008");//收款账户,最大长度32
        enterpriseBatchColInfoList2.setAmt(new BigDecimal("5.01"));//订单总额,最大长度16,2位
        enterpriseBatchColInfoList2.setSubOrderNo("0000124");//商户子订单号,最大长度32
        batchColInfoList.add(enterpriseBatchColInfoList);
        batchColInfoList.add(enterpriseBatchColInfoList2);
        enterpriseBatchOrderPayDownReqDto.setBatchColInfoList(batchColInfoList);
        List<BatchOrderFee> feeList = new ArrayList<>();
        BatchOrderFee batchOrderFee = new BatchOrderFee();
        batchOrderFee.setFeeCode("030302");//费用编号,最大长度6
        batchOrderFee.setFeeAmt("1.01");//费用金额,最大长度16,2位
        batchOrderFee.setPostScript("");//交易附言,最大长度10
        feeList.add(batchOrderFee);
        enterpriseBatchOrderPayDownReqDto.setFeeList(feeList);
        List<BatchOrderGood> good = new ArrayList<>();
        BatchOrderGood batchOrderGood = new BatchOrderGood();
        batchOrderGood.setGoodsID("002");//商品编号,最大长度255
        batchOrderGood.setGoodsName("苹果Macbook Pro");//商品名称,最大长度200
        batchOrderGood.setGoodsSpec("深空灰 8G 256SSD");//商品规格,最大长度64
        batchOrderGood.setGoodsAmt(new BigDecimal("10.02"));//商品金额,最大长度100
        batchOrderGood.setGoodsNum("1");//商品数量,最大长度16,2位
        batchOrderGood.setGoodsPrice(new BigDecimal("10.02"));//商品单价,最大长度16,2位
        batchOrderGood.setGoodsRemark("全新");//商品备注,最大长度255
        good.add(batchOrderGood);
        enterpriseBatchOrderPayDownReqDto.setGoodList(good);

        rxtBsbOperatorServerImp.strongBatchOrderPayDown(enterpriseBatchOrderPayDownReqDto,
                BankTransInfoEnum.会员订单加强型批量即时支付);

    }

    /**
     * 4.5 企业开户Ukey绑定修改
     */
    @Test
    public void enterpriseOpenUkeyBinding() {
        AcctBindInfoQueryReqDto acctBindInfoQueryReqDto = new AcctBindInfoQueryReqDto();
        acctBindInfoQueryReqDto.setSubAcctNo("9956760999679500000008");  //商户资金账号
        rxtBsbOperatorServerImp.enterpriseOpenUkeyBinding(acctBindInfoQueryReqDto,
                BankTransInfoEnum.企业开户Ukey绑定修改);

    }


    //===================================4.6 商户管理 开始==============================================

    /**
     * 商户资金账户白名单查询
     */
    @Test
    public void buinessAcctWhiteListQuery() {
        BuinessAcctQueryReqDto buinessAcctQueryReqDto = new BuinessAcctQueryReqDto();
        buinessAcctQueryReqDto.setSubAcctNo("");//资金账号,为空时分页返回所有商户自有资金账户信息,变长32
        buinessAcctQueryReqDto.setFileFlag("0");//文件标志,0-分页模式;1-文件模式(暂未实现)
        buinessAcctQueryReqDto.setPageId("1");//页码,分页模式有效
        buinessAcctQueryReqDto.setPageSize("10");//每页记录数,每页记录数最大 100 条,分页模式有效,变长10
        rxtBsbOperatorServerImp.buinessAcctQuery(buinessAcctQueryReqDto,
                BankTransInfoEnum.商户资金账户白名单查询);
    }

    /**
     * 商户资金账户明细查询
     */
    @Test
    public void buinessAcctDetailQuery() {
        BuinessAcctDetailQueryReqDto buinessAcctDetailQueryReqDto = new BuinessAcctDetailQueryReqDto();
        buinessAcctDetailQueryReqDto.setStartDate("20190916");//起始日期,格式：yyyyMMdd,银行交易起止日期不能大于 90 天,定长8
        buinessAcctDetailQueryReqDto.setEndDate("20191009");//截止日期,格式：yyyyMMdd,银行交易起止日期不能大于 90 天,定长8
        buinessAcctDetailQueryReqDto.setSubAcctNo("9956760999679599997001");//资金账号,变长32
        buinessAcctDetailQueryReqDto.setSerialNo("");//交易流水号,变长32
        buinessAcctDetailQueryReqDto.setSubSerialNo("");//交易子流水号,变长32
        buinessAcctDetailQueryReqDto.setOrderNo("");//商户流水号,变长32
        buinessAcctDetailQueryReqDto.setSubOrderNo("");//商户子流水号,变长32
        buinessAcctDetailQueryReqDto.setOrderStartDate("20190916");//商户交易起始日期,格式：yyyyMMdd,银行交易起止日期不能大于 90 天,定长8
        buinessAcctDetailQueryReqDto.setOrderEndDate("20191009");//商户交易起始日期,格式：yyyyMMdd,银行交易起止日期不能大于 90 天,定长8
        buinessAcctDetailQueryReqDto.setFileFlag("0");//文件标志,0-分页模式;1-文件模式(暂未实现)
        buinessAcctDetailQueryReqDto.setPageId("1");//页码,分页模式有效,变长10
        buinessAcctDetailQueryReqDto.setPageSize("10");//每页记录数,每页记录数最大 100 条,分页模式有效,变长10
        InterfaceRespVo<BuinessAcctDetailQueryReqDto> response =
                rxtBsbOperatorServerImp.buinessAcctDetailQuery(buinessAcctDetailQueryReqDto,
                        BankTransInfoEnum.商户资金账户明细查询);
    }

    /**
     * 商户资金账户余额查询
     */
    @Test
    public void buinessAcctBalanceQuery() {
        BuinessAcctQueryReqDto buinessAcctQueryReqDto = new BuinessAcctQueryReqDto();
        buinessAcctQueryReqDto.setSubAcctNo("");//资金账号,为空时分页返回所有商户自有资金账户信息,变长32
        buinessAcctQueryReqDto.setFileFlag("0");//文件标志,0-分页模式;1-文件模式(暂未实现)
        buinessAcctQueryReqDto.setPageId("1");//页码,分页模式有效
        buinessAcctQueryReqDto.setPageSize("10");//每页记录数,每页记录数最大 100 条,分页模式有效,变长10
        InterfaceRespVo<BuinessAcctQueryReqDto> response =
                rxtBsbOperatorServerImp.buinessAcctQuery(buinessAcctQueryReqDto,
                        BankTransInfoEnum.商户资金账户余额查询);
    }

    /**
     * 商户资金账户信息查询
     */
    @Test
    public void buinessAcctInfoQuery() {
        BuinessAcctQueryReqDto buinessAcctQueryReqDto = new BuinessAcctQueryReqDto();
        buinessAcctQueryReqDto.setSubAcctNo("");//资金账号,为空时分页返回所有商户自有资金账户信息,变长32
        buinessAcctQueryReqDto.setFileFlag("0");//文件标志,0-分页模式;1-文件模式(暂未实现)
        buinessAcctQueryReqDto.setPageId("1");//页码,分页模式有效
        buinessAcctQueryReqDto.setPageSize("10");//每页记录数,每页记录数最大 100 条,分页模式有效,变长10
        InterfaceRespVo<BuinessAcctQueryReqDto> response =
                rxtBsbOperatorServerImp.buinessAcctQuery(buinessAcctQueryReqDto,
                        BankTransInfoEnum.商户资金账户信息查询);
    }


    //======================================4.6 商户管理 结束===============================================

    //======================================4.7 会员管理 开始===============================================

    /**
     * 会员资金账户绑定信息查询
     */
    @Test
    public void acctBindInfoQuery() {
        AcctBindInfoQueryReqDto acctBindInfoQueryReqDto = new AcctBindInfoQueryReqDto();
//        acctBindInfoQueryReqDto.setSubAcctNo("9956760999679500000008");////资金账好,变长32
//        acctBindInfoQueryReqDto.setSubAcctNo("9956760999679500000011");////资金账好,变长32
        acctBindInfoQueryReqDto.setSubAcctNo("9956760999679500000013");////资金账号,变长32
        InterfaceRespVo<AcctBindInfoQueryReqDto> response =
                rxtBsbOperatorServerImp.acctBindInfoQuery(acctBindInfoQueryReqDto, BankTransInfoEnum.会员资金账户绑定信息查询);
    }

    /**
     * 通用查询
     */
    @Test
    public void generalQuery() {
        GeneralQueryReqDto generalQueryReqDto = new GeneralQueryReqDto();
//        generalQueryReqDto.setOrderNo("20190201105245653");//商户平台流水号,变长32
        generalQueryReqDto.setOrderNo("20191107145208255");//商户平台流水号,变长32
        InterfaceRespVo<GeneralQueryReqDto> response =
                rxtBsbOperatorServerImp.generalQuery(generalQueryReqDto, BankTransInfoEnum.通用查询);
    }

    /**
     * 会员资金账户信息查询
     */
    @Test
    public void acctInfoQuery() {
        AcctInfoQueryReqDto acctInfoQueryReqDto = new AcctInfoQueryReqDto();
        acctInfoQueryReqDto.setSubAcctNo("9956760999679500000011");//资金账号,变长32
//        acctInfoQueryReqDto.setSubAcctNo("9956760999679500000011");//资金账号,变长32
        InterfaceRespVo<AcctInfoQueryReqDto> response =
                rxtBsbOperatorServerImp.acctInfoQuery(acctInfoQueryReqDto, BankTransInfoEnum.会员资金账户信息查询);
    }

    /**
     * 会员资金账户明细查询
     */
    @Test
    public void acctDetailQuery() {
        AcctDetailQueryReqDto acctDetailQueryReqDto = new AcctDetailQueryReqDto();
        acctDetailQueryReqDto.setStartDate("20190910");//起始日期,格式：yyyyMMdd,银行交易起止日期时间段不能大于 90 天,定长8
        acctDetailQueryReqDto.setEndDate("20191008");//截止日期,格式：yyyyMMdd,银行交易起止日期时间段不能大于 90 天,定长8
        acctDetailQueryReqDto.setSubAcctNo("9956760999679500000008");//会员资金账号
        acctDetailQueryReqDto.setSerialNo("56700201909290000187835567187835");//银行交易流水号
        acctDetailQueryReqDto.setSubSerialNo("");//银行交易子流水号
        acctDetailQueryReqDto.setOrderNo("20191008183838328");//商户流水号或订单号
        acctDetailQueryReqDto.setSubOrderNo("");//商户子流水号或子订单号
        acctDetailQueryReqDto.setOrderStartDate("20190910");//商户交易起始日期,格式：yyyyMMdd,商户交易起止日期时间段不能大于 90 天
        acctDetailQueryReqDto.setOrderEndDate("20191008");//商户交易截止日期,格式：yyyyMMdd,商户交易起止日期时间段不能大于 90 天
        acctDetailQueryReqDto.setFileFlag("0");//文件标志,0-分页模式,1-文件模式（暂未实现）
        acctDetailQueryReqDto.setPageId(1);//页码，第几页，分页模式有效
        acctDetailQueryReqDto.setPageSize(10);//每页记录数，每页记录数最大 100 条，分页模式有效
        InterfaceRespVo<AcctDetailQueryReqDto> response =
                rxtBsbOperatorServerImp.acctDetailQuery(acctDetailQueryReqDto, BankTransInfoEnum.会员资金账户明细查询);
    }

    /**
     * 会员资金账户余额查询
     */
    @Test
    public void acctBalanceQuery() {
        AcctInfoQueryReqDto acctInfoQueryReqDto = new AcctInfoQueryReqDto();
//        acctInfoQueryReqDto.setSubAcctNo("9956760999679500000008");//资金账好,变长32
        acctInfoQueryReqDto.setSubAcctNo("9956760999679500000011");//资金账好,变长32
        InterfaceRespVo<AcctInfoQueryReqDto> response =
                rxtBsbOperatorServerImp.acctInfoQuery(acctInfoQueryReqDto, BankTransInfoEnum.会员资金账户余额查询);
    }

    //========================================4.7 会员管理 结束============================================


    //========================================4.8 通知管理 开始============================================

    /**
     * 商户交易结果通知
     */
    @Test
    public void buinessTransResultNotify() {
        BuinessTransResultNotifyReqDto buinessTransResultNotifyReqDto = new BuinessTransResultNotifyReqDto();
        buinessTransResultNotifyReqDto.setMerchantSerialCode("");  //商户请求流水号
        buinessTransResultNotifyReqDto.setPlatformSerialCode("");  //银行交易流水号
        buinessTransResultNotifyReqDto.setTradeCode("");  //业务功能码
        buinessTransResultNotifyReqDto.setReturnCode("");  //交易状态码
        buinessTransResultNotifyReqDto.setReturnMessage("");  //交易状态信息
        buinessTransResultNotifyReqDto.setReturnInfo("");  //交易返回内容
        rxtBsbOperatorServerImp.buinessTransResultNotify(buinessTransResultNotifyReqDto, BankTransInfoEnum.商户交易结果通知);

    }

    /**
     * 资金账户动账通知
     */
    @Test
    public void acctDynamicNotify() {
        AcctDynamicNotifyReqDto acctDynamicNotifyReqDto = new AcctDynamicNotifyReqDto();
        acctDynamicNotifyReqDto.setSerialNo("");//银行交易流水号,公共报文头取值,最大长度32
        acctDynamicNotifyReqDto.setSubSerialNo("");//银行子交易流水号,公共报文头取值,最大长度32
        acctDynamicNotifyReqDto.setTransDate("20190924");//交易日期,格式：yyyyMMdd,公共报文头取值,固定长度8
        acctDynamicNotifyReqDto.setTransTime("165920");//交易时间,格式：HHmmss,公共报文头取值,固定长度6
        acctDynamicNotifyReqDto.setOrderNo("");//商户流水号,公共报文头取值
        acctDynamicNotifyReqDto.setSubOrderNo("");//商户子流水号,公共报文头取值,最大长度32
        acctDynamicNotifyReqDto.setOrderDate("");//商户交易日期,格式：yyyyMMdd,公共报文头取值,固定长度8
        acctDynamicNotifyReqDto.setOrderTime("");//商户交易时间,格式：HHmmss,公共报文头取值,固定长度6
        acctDynamicNotifyReqDto.setSubAcctNo("");//资金账号,最大长度32
        acctDynamicNotifyReqDto.setCdFlag("");//借贷类型,C-贷;D-借
        acctDynamicNotifyReqDto.setAmount(null);//交易金额,最大长度16
        acctDynamicNotifyReqDto.setTransType("");//交易类型,02-收费;03-结息;12-充值入金;13-提现出金;14-交易;15-退款;99-其它
        InterfaceRespVo<AcctDynamicNotifyReqDto> response =
                rxtBsbOperatorServerImp.acctDynamicNotify(acctDynamicNotifyReqDto,
                        BankTransInfoEnum.资金账户动账通知);
    }
    //=============================4.8.1 通知管理 结束=================================================

    /**
     * 商户交易流水对账
     */
    @Test
    public void businessTransactionFlowReconciliation() {
        BusinessTransactionReqDto businessTransactionReqDto = new BusinessTransactionReqDto();
        businessTransactionReqDto.setCheckDate("20190924");  //对帐日期
        rxtBsbOperatorServerImp.businessTransactionFlowReconciliation(businessTransactionReqDto,
                BankTransInfoEnum.商户交易流水对账);

    }

    /**
     * 商户资金账户余额对账
     */
    @Test
    public void businessTransactionFlowReconciliation1() {
        BusinessTransactionReqDto businessTransactionReqDto = new BusinessTransactionReqDto();
        businessTransactionReqDto.setCheckDate("20190924");  //对帐日期
        rxtBsbOperatorServerImp.businessTransactionFlowReconciliation(businessTransactionReqDto,
                BankTransInfoEnum.商户资金账户余额对账);

    }

    /**
     * 商户资金账户明细对账
     */
    @Test
    public void businessTransactionFlowReconciliation2() {
        BusinessTransactionReqDto businessTransactionReqDto = new BusinessTransactionReqDto();
        businessTransactionReqDto.setCheckDate("20190924");  //对帐日期
        rxtBsbOperatorServerImp.businessTransactionFlowReconciliation(businessTransactionReqDto,
                BankTransInfoEnum.商户资金账户明细对账);

    }

    /**
     * 商户文件下载
     */
    @Test
    public void businessDocumentDownload() {
        BusinessDocumentReqDto businessDocumentReqDto = new BusinessDocumentReqDto();
        businessDocumentReqDto.setFileName("/20190924/virdetail20190924.dat");  //文件名称

        rxtBsbOperatorServerImp.businessDocumentDownload(businessDocumentReqDto,
                BankTransInfoEnum.商户文件下载);

    }

    /**
     * 商户文件上传
     */
    @Test
    public void businessDocument() {
        BusinessDocumentReqDto businessDocumentReqDto = new BusinessDocumentReqDto();
        businessDocumentReqDto.setFileName("/20191015/virdetail20191015.dat");  //文件名称
        businessDocumentReqDto.setFileData("20191015"); //文件内容

        rxtBsbOperatorServerImp.businessDocument(businessDocumentReqDto,
                BankTransInfoEnum.商户文件上传);

    }

    /**
     * 回单查询
     */
    @Test
    public void backOrderQuery() {
        BackOrderQueryReqDto backOrderQueryReqDto = new BackOrderQueryReqDto();
        backOrderQueryReqDto.setSubAcctNo("9956760999679500000011");//账号
        backOrderQueryReqDto.setSerialNo("20191009164433854");//商户请求流水号
        backOrderQueryReqDto.setSubSerialNo("20191009164433854");//商户请求子流水号
        backOrderQueryReqDto.setIsPath("Y");//补打标志

        rxtBsbOperatorServerImp.backOrderQuery(backOrderQueryReqDto,
                BankTransInfoEnum.回单查询);

    }


    /**
     * 回单打印
     */
    @Test
    public void backOrderPrin() {
        BackOrderPrinReqDto backOrderPrinReqDto = new BackOrderPrinReqDto();
        backOrderPrinReqDto.setInnerNo("");//回单唯一编号
        backOrderPrinReqDto.setFileName("");//回单文件名称

        rxtBsbOperatorServerImp.backOrderPrin(backOrderPrinReqDto,
                BankTransInfoEnum.回单打印);

    }

    //@Test
    public String queryTradeInfo(RequestHead requestHead) {
        QueryTradeAcctInfoReqDto dto = new QueryTradeAcctInfoReqDto();
        dto.setFileFlag("0");
        dto.setPageId("1");
        dto.setPageSize("10");
        dto.setSubAcctNo("609996795");

        String head = JSONObject.toJSONString(requestHead);
        String body = JSONObject.toJSONString(dto);
        System.out.println(head);
        System.out.println(body);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("body", body);
        jsonObject.put("head", requestHead);
        String req = jsonObject.toJSONString();
        System.out.println(req);
        return req;
    }


//    public void testNotify(){
//        String	resp ="36B1AE011000000062080101308201FC0221009A0FF74B9B8B8569E4A98A690869D7D8C11DC4A5111C5A514400482982FEE6CE0220198EBFE46CDCD52FE900940B464576F38472308BDA33143E30F87A1E254F3BD104207A117B23C8810BE95EE71985520FC7A4DBBFE90ADEF49F5B08732E64B3C2472A04820191A3C5EFA427D61D294441710ADB484108B1C4A3E4A1808D2A593A0B5B933B03DECD9E9AEBDC86C584EA984FAF2E8B9F268F8C61A2341ADE707B605B9326AABF296161227CA003D87AAA7C0858520147B8053AF7F064F5FB0E219B14EA746E3ED9E5B93832C04690C0C534181093A21031E7623E49BFBEE76BBD791FE5E0020903E7D85EBC5F46D1951162A02C66C8E0BD0B2BFB9D27F7CC2BE4B5325F615C05236F5D1F46D05AE8F9F45350D89AD9AEF5BE23E9FE076BE963579866F26DB0E71A2F0B1D0ACE4B56126501FF3C26B390D362449ADBB564F1C9D9842166769AF889B6AE2E535753EF76213215954869EDC261EB972383D0DF07249504B481947C6D000FC84A912C2E3DA63952964C6F3DD0162AB5E47BBEA89DF52BD500EA2E76F664C3A2B7613B58CC7F6BAE3924A2F3F964B9995EE5362180CD33DAF764EDF88382EA9094BA993298D52C8BDE00E3FF5A6AE415061C2EEAF7DFD40E0306ACDEB8F08EF6A9ED062C750278FAA0F7E0DD3F864AF825148008B49180190CD4EF40075067D4E3A57BD704D38349A1C16482E368|2363EA20B4762B33D24A949AC521231720B4F34DC85CBBD394CD8535494A9E3E5D9D478F65220C212F475AB6FCB7078B406E48F7828F015D559F27399C2AB23D064BEA3318A9C4E7B6CBAFE2B6AD530F0B15FDF1D15E04ABCF07E90322E63204470C572EA00F5A85CBC9558AC1CE1FA983234468DD39B74473D3788D2C691AC4";
//        try {
//            resp = EncrAndDecryptForClient.decryptAndVertify(resp);
//            System.out.println(resp);
//            NotifyResultResDto response  = JSONObject.parseObject(resp, NotifyResultResDto.class);
//            String merchantCode = response.getHead().getMerchantCode();
//            String platformSerialCode = response.getBody().getMerchantSerialCode();
//            System.out.println("getMerchantCode："+response.getHead().getMerchantCode());
//            System.out.println("getPlatformSerialCode："+response.getHead().getPlatformSerialCode());
//            System.out.println("getTradeCode："+response.getHead().getTradeCode());
//            System.out.println("getTransDate："+response.getHead().getTransDate());
//            System.out.println("getReturnCode："+response.getBody().getReturnCode());
//            System.out.println("getReturnMessage："+response.getBody().getReturnMessage());
//            System.out.println("getPlatformSerialCode："+response.getBody().getPlatformSerialCode());
//            System.out.println("getMerchantSerialCode："+response.getBody().getMerchantSerialCode());
//            String returnCode = response.getBody().getReturnCode();
////				if(BankReturnCode.RETURN_CODE_SUCSS.equals(returnCode)){//交易成功
//            NotifyOpenPersonalAcctEntity entity =JSONObject.parseObject(response.getBody().getReturnInfo(),NotifyOpenPersonalAcctEntity.class);
//            System.out.println("getSubAcctNo："+entity.getSubAcctNo());
//            System.out.println("getSubAcctNoStatus："+entity.getSubAcctNoStatus());
//            System.out.println("getRepayNo："+entity.getRepayNo());
//            System.out.println("getRepayNoStatus："+entity.getRepayNoStatus());
////				}
//
//            NotifyRespondDto notifyRespondDto = new NotifyRespondDto();
//            NotifyRespondHead head = new NotifyRespondHead();
//            head.setMerchantCode(merchantCode);
//            head.setPlatformSerialCode(platformSerialCode);
//            NotifyRespondBody body = new NotifyRespondBody();
//            body.setRetCode(BankReturnCode.RETURN_CODE_SUCSS);
//            body.setRetInfo("");
//            notifyRespondDto.setBody(body);
//            notifyRespondDto.setHead(head);
//            String notifyContext = JSONObject.toJSONString(notifyRespondDto);
//            System.out.println("通知返回内容："+notifyContext);
//            String message = EncrAndDecryptForClient.encryptAndSign(notifyContext);
//            System.out.println("通知返回"+message);
//
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }

    //======================================在线授信申请文档接口============================================
    //3.1.1.授信申请接受（实时模式）
    @Test
    public void creditApplyNotifyTime() {
        CreditApplyReqDto creditApplyReqDto = new CreditApplyReqDto();
        creditApplyReqDto.setChannelNo("1");
        creditApplyReqDto.setCustNo("1");
        creditApplyReqDto.setPlatApplyNo("1");
        creditApplyReqDto.setCustName("1");
        creditApplyReqDto.setCertType("1");
        creditApplyReqDto.setCertNo("1");
        creditApplyReqDto.setCertValidDate("1");
        creditApplyReqDto.setCertStartDate("1");
        creditApplyReqDto.setCertLengthDate("1");
        creditApplyReqDto.setCustType("1");
        creditApplyReqDto.setIsBankStaff("1");
        creditApplyReqDto.setAge("");
        creditApplyReqDto.setBirthDate("1");
        creditApplyReqDto.setMobileNo("1");
        creditApplyReqDto.setGender("1");
        creditApplyReqDto.setCountry("1");
        creditApplyReqDto.setAddressCode("1");
        creditApplyReqDto.setAddressStr("1");
        creditApplyReqDto.setAddressInfo("1");
        creditApplyReqDto.setHomeTel("1");
        creditApplyReqDto.setMarriage("1");
        creditApplyReqDto.setSpouseName("1");
        creditApplyReqDto.setEducation("1");
        creditApplyReqDto.setEmail("1");
        creditApplyReqDto.setLivingStatus("1");
        creditApplyReqDto.setRegisteredHouse("1");
        creditApplyReqDto.setRegisteredPlace("1");
        creditApplyReqDto.setCheckDate("1");
        creditApplyReqDto.setAddressType("1");
        creditApplyReqDto.setSpouseCertType("1");
        creditApplyReqDto.setSpouseCertNo("1");
        creditApplyReqDto.setSpouseMobile("1");
        creditApplyReqDto.setCustFlag("1");
        creditApplyReqDto.setRegCertCode("1");
        creditApplyReqDto.setManageName("1");
        creditApplyReqDto.setManageOwner("1");
        creditApplyReqDto.setManageAddressId("1");
        creditApplyReqDto.setManageYear("1");
        creditApplyReqDto.setManageAddress("1");
        creditApplyReqDto.setManageTrade("1");
        creditApplyReqDto.setManageTradeName("1");
        creditApplyReqDto.setManageIncome("1");
        creditApplyReqDto.setManageEmployee("1");
        creditApplyReqDto.setCommpannyName("1");
        creditApplyReqDto.setCommpannyTrade("1");
        creditApplyReqDto.setCommpannyTradeName("1");
        creditApplyReqDto.setCommpannyType("1");
        creditApplyReqDto.setCommpannyAddressId("1");
        creditApplyReqDto.setCommpannyStr("1");
        creditApplyReqDto.setCommpannyAddress("1");
        creditApplyReqDto.setCommpannyPhone("1");
        creditApplyReqDto.setCommLoanIncome("1");
        creditApplyReqDto.setCommpannyYear("1");
        creditApplyReqDto.setCommpannyJob("1");
        creditApplyReqDto.setCommpannyTitle("1");
        creditApplyReqDto.setCommpannyVocation("1");
        creditApplyReqDto.setCommpannyPost("1");
        creditApplyReqDto.setProduct("1");
        creditApplyReqDto.setCreditAmt("1");
        creditApplyReqDto.setRepayType("1");
        creditApplyReqDto.setApplyTerm("");
        creditApplyReqDto.setRepaySource("1");
        creditApplyReqDto.setPayDay("");
        creditApplyReqDto.setPayDistance("");
        creditApplyReqDto.setAssureMeansMain("1");
        creditApplyReqDto.setPayType("1");
        creditApplyReqDto.setLoanUse("1");
        creditApplyReqDto.setApplyChannel("1");

        CustRelReqDto custRelReqDto = new CustRelReqDto();
        custRelReqDto.setRelType("1");
        custRelReqDto.setRelName("1");
        custRelReqDto.setRelCustRelation("1");
        custRelReqDto.setRelPhone("1");
        custRelReqDto.setRelAddress("1");
        custRelReqDto.setRelComName("1");
        custRelReqDto.setRelComAddress("1");
        custRelReqDto.setRelComPhone("1");

        OrderInfoReqDto orderInfoReqDto = new OrderInfoReqDto();
        orderInfoReqDto.setOrderNo("1");

        EntrustReqDto entrustReqDto = new EntrustReqDto();
        entrustReqDto.setAssetNo("1");
        entrustReqDto.setBankNo("1");
        entrustReqDto.setBankName("1");
        entrustReqDto.setAssetName("1");
        entrustReqDto.setIsBaoShang("1");
        entrustReqDto.setAmount("1");

        FileReqDto fileReqDto = new FileReqDto();
        fileReqDto.setSerialNo("1");
        fileReqDto.setBussTime("1");

        creditApplyReqDto.setCustRelDto(new ArrayList<CustRelReqDto>());
        creditApplyReqDto.setOrderInfoDto(new ArrayList<>());
        creditApplyReqDto.setEntrustDto(new ArrayList<>());
        creditApplyReqDto.setFileDto(new ArrayList<>());
        creditApplyReqDto.setFinancRate("1");
        creditApplyReqDto.setIsCircle("1");
        creditApplyReqDto.setIsMultiLoan("1");
        creditApplyReqDto.setAuditDatas("1");
        creditApplyReqDto.setLoanNo("1");

        InterfaceRespVo<CreditApplyResDto> res =
                rxtBsbOperatorServerImp.creditApplyNotifyTime(creditApplyReqDto, BankTransInfoEnum.授信申请接受_实时模式);

    }


    //3.1.3.提款申请(实时模式)
    @Test
    public void withdrawalApplyTime() {
        WithdrawalApplyReqDto withdrawalApplyReqDto = new WithdrawalApplyReqDto();
        withdrawalApplyReqDto.setChnlNo("1");
        withdrawalApplyReqDto.setDwmAplyNo("1");
        withdrawalApplyReqDto.setCrgAplyNp("1");
        withdrawalApplyReqDto.setCstNo("1");
        withdrawalApplyReqDto.setCstNm("1");
        withdrawalApplyReqDto.setLoanAmt("100.00");
        withdrawalApplyReqDto.setCcy("1");
        withdrawalApplyReqDto.setLoanTrm("0");
        withdrawalApplyReqDto.setLoanTrmUnit("1");
        withdrawalApplyReqDto.setPyMd("1");
        withdrawalApplyReqDto.setRepyDy("");
        withdrawalApplyReqDto.setRepyItrv("0");
        withdrawalApplyReqDto.setRepyCyc("1");
        withdrawalApplyReqDto.setRpMd("1");
        withdrawalApplyReqDto.setModeNumber("1");
        withdrawalApplyReqDto.setPdNo("1");
        withdrawalApplyReqDto.setDocumentType("1");
        withdrawalApplyReqDto.setDocumentNumber("1");
        withdrawalApplyReqDto.setAccNo("1");
        withdrawalApplyReqDto.setRepaymentAccount("1");
        //withdrawalApplyReqDto.setEntrstdPayList(new ArrayList<>());
        withdrawalApplyReqDto.setOrederList(new ArrayList<>());

        rxtBsbOperatorServerImp.withdrawalApplyTime(withdrawalApplyReqDto,
                BankTransInfoEnum.提款申请_实时模式);

    }


//    /**
//     * 3.3.2.在线授信申请 确认 结果通知（实时模式）
//     */
//    @Test
//    public void onlineCreditApplicationConfirm(){
//        NotifyResultReqDto notifyReqDto = new NotifyResultReqDto();
//        notifyReqDto.setMerchantSerialCode("1");
//        notifyReqDto.setPlatformSerialCode("1");
//        notifyReqDto.setTradeCode("1");
//        notifyReqDto.setReturnCode("1");
//        notifyReqDto.setReturnMessage("1");
//        notifyReqDto.setReturnInfo("1");
//        notifyReqDto.setApplyNo("1");
//        notifyReqDto.setContractNo("1");
//
//        InterfaceRespVo<NotifyResultResDto> res =
//                rxtBsbOperatorServerImp.onlineCreditApplicationConfirm(notifyReqDto, BankTransInfoEnum.在线授信申请确认结果通知);
//
//        System.out.println(res);
//    }
//
//    /**
//     * 3.3.3.在线授信申请 受理 结果通知（实时模式）
//     */
//    @Test
//    public void onlineCreditApplicationAccept(){
//        NotifyResultReqDto notifyReqDto = new NotifyResultReqDto();
//        notifyReqDto.setMerchantSerialCode("1");
//        notifyReqDto.setPlatformSerialCode("1");
//        notifyReqDto.setTradeCode("1");
//        notifyReqDto.setReturnCode("1");
//        notifyReqDto.setReturnMessage("1");
//        notifyReqDto.setReturnInfo("1");
//        notifyReqDto.setApplyNo("1");
//        notifyReqDto.setContractNo("1");
//
//        InterfaceRespVo<NotifyResultResDto> res =
//                rxtBsbOperatorServerImp.onlineCreditApplicationAccept(notifyReqDto, BankTransInfoEnum.在线授信申请受理结果通知);
//
//        System.out.println(res);
//    }
//
//    /**
//     * 3.3.4.在线授信申请 审批 结果通知（实时模式）
//     */
//    @Test
//    public void onlineCreditApplicationApproval(){
//        NotifyResultReqDto notifyReqDto = new NotifyResultReqDto();
//        notifyReqDto.setMerchantSerialCode("1");
//        notifyReqDto.setPlatformSerialCode("1");
//        notifyReqDto.setTradeCode("1");
//        notifyReqDto.setReturnCode("1");
//        notifyReqDto.setReturnMessage("1");
//        notifyReqDto.setReturnInfo("1");
//        notifyReqDto.setApplyNo("1");
//        notifyReqDto.setContractNo("1");
//
//        InterfaceRespVo<NotifyResultResDto> res =
//                rxtBsbOperatorServerImp.onlineCreditApplicationApproval(notifyReqDto, BankTransInfoEnum.在线授信申请审批结果通知);
//
//        System.out.println(res);
//    }
//
//    /**
//     * 3.3.5.在线 提款申请 确认 结果通知（实时模式）
//     */
//    @Test
//    public void onlineWithdrawalApplicationConfirm(){
//        NotifyResultReqDto notifyReqDto = new NotifyResultReqDto();
//        notifyReqDto.setMerchantSerialCode("1");
//        notifyReqDto.setPlatformSerialCode("1");
//        notifyReqDto.setTradeCode("1");
//        notifyReqDto.setReturnCode("1");
//        notifyReqDto.setReturnMessage("1");
//        notifyReqDto.setReturnInfo("1");
//        notifyReqDto.setApplyNo("1");
//        notifyReqDto.setContractNo("1");
//
//        InterfaceRespVo<NotifyResultResDto> res =
//                rxtBsbOperatorServerImp.onlineWithdrawalApplicationConfirm(notifyReqDto, BankTransInfoEnum.在线提款申请确认结果通知);
//
//        System.out.println(res);
//    }
//
//    /**
//     * 3.3.6.在线 提款申请 受理 结果通知（实时模式）
//     */
//    @Test
//    public void onlineWithdrawalApplicationAccept(){
//        NotifyResultReqDto notifyReqDto = new NotifyResultReqDto();
//        notifyReqDto.setMerchantSerialCode("1");
//        notifyReqDto.setPlatformSerialCode("1");
//        notifyReqDto.setTradeCode("1");
//        notifyReqDto.setReturnCode("1");
//        notifyReqDto.setReturnMessage("1");
//        notifyReqDto.setReturnInfo("1");
//        notifyReqDto.setApplyNo("1");
//        notifyReqDto.setContractNo("1");
//
//        InterfaceRespVo<NotifyResultResDto> res =
//                rxtBsbOperatorServerImp.onlineWithdrawalApplicationAccept(notifyReqDto, BankTransInfoEnum.在线提款申请受理结果通知);
//
//        System.out.println(res);
//    }
//
//    /**
//     * 3.3.7.合同签署 结果通知（实时模式）
//     */
//    @Test
//    public void contractSignResult(){
//        NotifyResultReqDto notifyReqDto = new NotifyResultReqDto();
//        notifyReqDto.setMerchantSerialCode("1");
//        notifyReqDto.setPlatformSerialCode("1");
//        notifyReqDto.setTradeCode("1");
//        notifyReqDto.setReturnCode("1");
//        notifyReqDto.setReturnMessage("1");
//        notifyReqDto.setReturnInfo("1");
//        notifyReqDto.setApplyNo("1");
//        notifyReqDto.setContractNo("1");
//
//        InterfaceRespVo<NotifyResultResDto> res =
//                rxtBsbOperatorServerImp.contractSignResult(notifyReqDto, BankTransInfoEnum.合同签署结果通知);
//
//        System.out.println(res);
//    }

    /**
     * 3.4.1 贷款信息查询（实时模式）
     */
    @Test
    public void loanInformation() {
        LoanInformationReqDto loanInformationReqDto = new LoanInformationReqDto();
        loanInformationReqDto.setPlatCustNo("01240113");//申请客户号
        loanInformationReqDto.setChannelNo("rongxin");//渠道编号
        loanInformationReqDto.setFinancApplyNo("000886");//提款申请编号
        loanInformationReqDto.setBegDate("");//开始日期 格式：yyyyMMdd
        loanInformationReqDto.setEndDate("");//结束日期 格式：yyyyMMdd
        loanInformationReqDto.setStat("");//贷款状态

        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageNo("1");//页码
        pageRequest.setPageSize("10");//每页记录数
        //pageRequest.setCount(1);
        loanInformationReqDto.setPageRequest(pageRequest);

        rxtBsbOperatorServerImp.loanInformation(loanInformationReqDto, BankTransInfoEnum.贷款信息查询);

    }

    /**
     * 3.4.2 还款计划详情查询（实时模式）
     */
    @Test
    public void paymentInformation() {
        PaymentInformationReqDto paymentInformationReqDto = new PaymentInformationReqDto();
        paymentInformationReqDto.setFinancApplyNo("000992");//融资申请编号

        rxtBsbOperatorServerImp.paymentInformation(paymentInformationReqDto, BankTransInfoEnum.还款计划详情查询);

    }

    /**
     * 3.4.3 还款计划明细查询（实时模式）
     */
    @Test
    public void paymentDetailList() {
        PaymentInformationReqDto paymentInformationReqDto = new PaymentInformationReqDto();
        paymentInformationReqDto.setFinancApplyNo("000993");//融资申请编号

        rxtBsbOperatorServerImp.paymentDetailList(paymentInformationReqDto,
                BankTransInfoEnum.还款计划明细查询);
    }

    /**
     * 3.4.4 合同协议列表查询（实时模式）
     */
    @Test
    public void contractAgreementList() {
        ContractAgreementReqDto contractAgreementReqDto = new ContractAgreementReqDto();
        contractAgreementReqDto.setBusinessNode("");//业务节点
        contractAgreementReqDto.setStat("");//合同状态
        contractAgreementReqDto.setIsCore("");//是否核心企业
        contractAgreementReqDto.setPlatCustNo("2200014461");//第三方平台客户号
        contractAgreementReqDto.setApplySubChannel("rongxin");//第三方渠道号
        contractAgreementReqDto.setPlatApplyNo("000989");//第三方申请编号
        contractAgreementReqDto.setStartDate("");//查询开始日期
        contractAgreementReqDto.setEndDate("");//查询结束日期

        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageNo("1");//当前页数
        pageRequest.setPageSize("10");//每页显示条数
        //pageRequest.setCount(1);
        contractAgreementReqDto.setPageRequest(pageRequest);

        rxtBsbOperatorServerImp.contractAgreementList(contractAgreementReqDto, BankTransInfoEnum.合同协议列表查询);

    }

    /**
     * 3.4.5 合同协议详情查询（实时模式）
     */
    @Test
    public void contractAgreementDetail() {
        ContractAgreementDetailReqDto contractAgreementDetailReqDto = new ContractAgreementDetailReqDto();
        contractAgreementDetailReqDto.setContractNo("20191401GR221418");//合同编号

        rxtBsbOperatorServerImp.contractAgreementDetail(contractAgreementDetailReqDto);

    }

    /**
     * 3.4.6 授信额度查询（实时模式）
     */
    @Test
    public void creditLine() {
        CreditLineReqDto creditLineReqDto = new CreditLineReqDto();
        creditLineReqDto.setPlatApplyNo("000993");//授信申请编号

        rxtBsbOperatorServerImp.creditLine(creditLineReqDto, BankTransInfoEnum.授信额度查询);

    }

    /**
     * 3.4.7 还款结果 查询（实时模式）
     */
    @Test
    public void repaymentResult() {
        RepaymentResultReqDto repaymentResultReqDto = new RepaymentResultReqDto();
        repaymentResultReqDto.setPlatCustNo("01240113");//申请客户号
        repaymentResultReqDto.setChannelNo("rongxin");//渠道编号
        repaymentResultReqDto.setFinancApplyNo("000993");//融资申请编号
        repaymentResultReqDto.setRepayType("");//还款范围
        repaymentResultReqDto.setRepayStat("");//还款状态
        repaymentResultReqDto.setRepayStartDate("");//开始日期
        repaymentResultReqDto.setRepayEndDate("");//结束日期

        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageNo("1");//页码
        pageRequest.setPageSize("10");//每页记录数
        //pageRequest.setCount(1);
        repaymentResultReqDto.setPageRequest(pageRequest);

        rxtBsbOperatorServerImp.repaymentResult(repaymentResultReqDto, BankTransInfoEnum.还款结果查询);

    }

    /**
     * 3.4.8 项目信息查询（实时模式）
     */
    @Test
    public void projectInfo() {
        ProjectInfoReqDto projectInfoReqDto = new ProjectInfoReqDto();
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageNo("1");
        pageRequest.setPageSize("10");
        projectInfoReqDto.setPageRequest(pageRequest);

        projectInfoReqDto.setProjNo("0000801");//项目编号

        rxtBsbOperatorServerImp.projectInfo(projectInfoReqDto, BankTransInfoEnum.项目信息查询);

    }

    /**
     * 3.4.9 模式查询（实时模式）
     */
    @Test
    public void patternQuery() {
        PatternQueryReqDto patternQueryReqDto = new PatternQueryReqDto();
//        patternQueryReqDto.setPatternNo("MSCJ201910110000002242");//模式编号
        patternQueryReqDto.setPatternNo("MSCJ201909290000002240");//模式编号

        rxtBsbOperatorServerImp.patternQuery(patternQueryReqDto, BankTransInfoEnum.模式查询);

    }

    /**
     * 3.2.1.附件上传（实时模式）
     */
    @Test
    public void uploadAttachments() {
        UploadAttachmentsReqDto uploadAttachmentsReqDto = new UploadAttachmentsReqDto();

        String str;
        byte[] strBuffer = null;
        int flen = 0;
        File xmlfile = new File("/Users/chenlixin/Downloads/20181224.xlsx");
        try {
            InputStream in = new FileInputStream(xmlfile);
            flen = (int) xmlfile.length();
            strBuffer = new byte[flen];
            in.read(strBuffer, 0, flen);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        str = new String(strBuffer); //构建String时，可用byte[]类型，
        //bae64加密
        str = new String(Base64.encodeBase64(str.getBytes()));

        uploadAttachmentsReqDto.setUploadFile(str);//上传文件字节流
        uploadAttachmentsReqDto.setFileName("20181224.xlsx");//文件名称
        uploadAttachmentsReqDto.setFileType("JY01");//文件类型
        uploadAttachmentsReqDto.setRelNo("000987");//关联编号 为授信、提款申请编号，授信、提款申请接口中的申请编号保持一致

        rxtBsbOperatorServerImp.uploadAttachments(uploadAttachmentsReqDto);

    }

    /**
     * 3.2.2.订单信息推送接口（实时模式）
     */
    @Test
    public void orderPush() {
        OrderPushReqDto orderPushReqDto = new OrderPushReqDto();
        ArrayList<OrderListReqDto> orderListReqDtos = new ArrayList<>();
        OrderListReqDto orderListReqDto = new OrderListReqDto();
        orderListReqDto.setBillCode("111197"); //单据编号
        orderListReqDto.setBillName("企业会员订单");//单据名称
        orderListReqDto.setBillType("01");//单据类型 01单据 02仓库 03发票 04应收 05汇总
        orderListReqDto.setBillTotalMoney("200.00");//单据总金额
        orderListReqDto.setBillSummary("摘要");//摘要
        orderListReqDto.setBuyerName("宋小");//买方名称
        orderListReqDto.setBuyerNo("001");//买方编号
        orderListReqDto.setSellerName("全渠道");//卖方名称
        orderListReqDto.setSellerNo("002");//卖方编号
        orderListReqDto.setPaidAmount("50.00");//已付金额
        orderListReqDto.setPayableAmount("100.00");//应付金额
        orderListReqDto.setTailAmount("50.00");//尾款金额

        OrderAdditionalParam orderAdditionalParam = new OrderAdditionalParam();
        orderAdditionalParam.setOrderStatus("已完成");//订单状态
        orderAdditionalParam.setOrderTime("20191011");//下单时间
        orderAdditionalParam.setBuyerMobile("13525677809");//买方手机号
        orderAdditionalParam.setBuyerDate("20191011");//买方付款日
        orderAdditionalParam.setBuyerAddress("北京昌平天通苑5本");//买方收货地址
        orderAdditionalParam.setSellerMobile("13552535506");//卖方手机号
        orderAdditionalParam.setSellerDate("20191011");//卖方发货日期
        orderAdditionalParam.setSellerAddress("北京海淀上地");//卖方地址
        orderAdditionalParam.setContractNo("000123");//合同号*
        orderAdditionalParam.setShipOrderNo("62369890");//物流单号
        orderAdditionalParam.setPayStatus("已支付");//支付状态
        orderAdditionalParam.setCheckTime("20191011");//审核时间
        orderAdditionalParam.setPayTime("20191011");//支付时间
        orderAdditionalParam.setConfirmRecTime("20191011");//确认收货时间
        orderAdditionalParam.setOrderRemarks("尽快发货");//订单备注
        orderAdditionalParam.setDueDate("20201011");//订单到期日期*
/*
        orderAdditionalParam.setCooperateTime("");//与平台合作时间（单位月）
        orderAdditionalParam.setLastTwoYearsMonths("");//最近24个月交易月份
        orderAdditionalParam.setLastTwoYearsAmt("");//最近24个月交易金额
        orderAdditionalParam.setLastTwoYearsOrderNum("");//最近24个月交易订单数
        orderAdditionalParam.setLastYearMonths("");//最近12个月交易月份
        orderAdditionalParam.setLastYearAmt("");//最近12个月交易金额
        orderAdditionalParam.setLastYearOrderNum("");//最近12个月交易订单数
        orderAdditionalParam.setLastSixMonths("");//最近6个月交易月份
        orderAdditionalParam.setLastSixMonthsAmt("");//最近6个月交易金额
        orderAdditionalParam.setLastSixMonthsOrderNum("");//最近6个月交易订单数
        orderAdditionalParam.setLastThreeMonths("");//最近3个月交易月份
        orderAdditionalParam.setLastThreeMonthsAmt("");//最近3个月交易金额
        orderAdditionalParam.setLastThreeMonthsOrderNum("");//最近3个月交易订单数
        orderAdditionalParam.setCooperateFSPTime("");//与平台金融合作时间（单位月）
        orderAdditionalParam.setCooperateFSPAmt("");//与平台金融结算金额
        orderAdditionalParam.setCooperateFSPTimeNum("");//与平台金融结算笔数
        orderAdditionalParam.setLastYearContactChangeNum("");//最近12个月联系人变更次数
        orderAdditionalParam.setLastYearContactInfoChangeNum("");//最近12个月联系方式变更次数
        orderAdditionalParam.setLastYearRecAddressChangeNum("");//最近12个月收货地址变更次数
        orderAdditionalParam.setLastYearRecInfoChangeNum("");//最近12个月收货信息变更次数
        orderAdditionalParam.setLastYearSupplierNum("");//最近12个月供应商数量
        orderAdditionalParam.setLastYearTopTenSupplierTransAmt("");//最近12个月前十大供应商交易额
        orderAdditionalParam.setLastYearTopTenSupplierTransPrp("");//前十大供应商交易额占比
        orderAdditionalParam.setLastYearGoodsNum("");//最近12个月采购商品数量
        orderAdditionalParam.setLastYearTopTenGoodsTransAmt("");//最近12个月前十大商品交易额
        orderAdditionalParam.setLastYearTopTenGoodsTransPrp("");//前十大商品交易额占比
        ArrayList<OrderTransList> orderTransLists = new ArrayList<>();
        OrderTransList orderTransList = new OrderTransList();
        orderTransList.setTransAmt("");//统计金额
        orderTransList.setTransCount("");//统计数量
        orderTransList.setTransMonth("");//统计月份
        orderTransLists.add(orderTransList);
        orderAdditionalParam.setOrderTransList(orderTransLists);

        ArrayList<OrderSupplierList> orderSupplierLists = new ArrayList<>();
        OrderSupplierList orderSupplierList = new OrderSupplierList();
        orderSupplierList.setSellerNo("");//卖方编号
        orderSupplierList.setSellerName("");//卖方名称
        orderSupplierList.setTransNum("");//交易笔数
        orderSupplierList.setTransAmt("");//交易金额
        orderSupplierList.setTransPrp("");//交易占比
        orderSupplierLists.add(orderSupplierList);
        orderAdditionalParam.setOrderSupplierList(orderSupplierLists);

        ArrayList<ReceiptList> receiptLists = new ArrayList<>();
        ReceiptList receiptList = new ReceiptList();
        receiptList.setReceiver("");//收货人
        receiptList.setContactInfo("");//联系方式
        receiptList.setRecAddress("");//收货地址
        receiptList.setTransNum("");//交易笔数
        receiptList.setTransAmt("");//交易金额
        receiptLists.add(receiptList);
        orderAdditionalParam.setReceiptList(receiptLists);
        */

        orderListReqDto.setJson(orderAdditionalParam);
        orderListReqDto.setOperateFlag("1");//操作标志* 1新增 2更新

        ArrayList<GoodsListDto> goodsListDtos = new ArrayList<>();
        GoodsListDto goodsListDto = new GoodsListDto();
        goodsListDto.setGoodsCode("010");//商品编号*
        goodsListDto.setGoodsName("苹果pro");//商品名称*
        goodsListDto.setGoodsPrice("10000.00");//商品单价*
        goodsListDto.setGoodsQuantity("1.00");//商品数量*
        goodsListDto.setGoodsUnit("个");//商品单位*
        goodsListDto.setGoodsTotalMoney("10000.00");//商品总价*
        goodsListDto.setGoodsSummary("全新");//摘要*

        GoodsJsonStr goodsJsonStr = new GoodsJsonStr();
        goodsJsonStr.setGoodsType("线上");//商品类型
        goodsJsonStr.setGoodsSpec("全新");//商品规格
//        goodsJsonStr.setTransNum("1.00");//交易笔数
//        goodsJsonStr.setTransAmt("10000.00");//交易金额
//        goodsJsonStr.setTransPrp("0.50");//交易额占比
        goodsListDto.setGoodsJson(goodsJsonStr);

        goodsListDtos.add(goodsListDto);
        orderListReqDto.setGoodsList(goodsListDtos);

        orderListReqDtos.add(orderListReqDto);
        orderPushReqDto.setOrderList(orderListReqDtos);

        rxtBsbOperatorServerImp.orderPush(orderPushReqDto,
                BankTransInfoEnum.订单信息推送接口);

    }

    /**
     * 4.1 授信申请接受 （网关模式）
     */
    @Test
    public void creditApplyNotify() {
//        CreditApplyReqDto creditApplyReqDto = new CreditApplyReqDto();
//        creditApplyReqDto.setChannelNo("rongxin");//渠道编号
//        creditApplyReqDto.setCustNo("01240113");//平台会员号
//        creditApplyReqDto.setPlatApplyNo("000990");//平台申请编号
//        creditApplyReqDto.setCustName("宋小");//客户名称
//        creditApplyReqDto.setCertType("01");//证件类型 01身份证 02军官证 03警官证 04士兵证 …………
//        creditApplyReqDto.setCertNo("150429198606152126");//证件号码
//        creditApplyReqDto.setCertValidDate("");//证件有效期
//        creditApplyReqDto.setCertStartDate("");//证件起始日
//        creditApplyReqDto.setCertLengthDate("");//证件到期日
//        creditApplyReqDto.setCustType("01");//客户类型 01一般自然人 02个体工商户 03企业法人 …………
//        creditApplyReqDto.setIsBankStaff("0");//是否我行员工 0否 1是
//        creditApplyReqDto.setAge("33");//年龄
//        creditApplyReqDto.setBirthDate("19860615");//出生日期
//        creditApplyReqDto.setMobileNo("13525677809");//手机号码
//        creditApplyReqDto.setGender("F");//性别 M男 F女
//        creditApplyReqDto.setCountry("01");//国籍 01中华人民共和国 02中国台湾 03香港 04澳门
//        creditApplyReqDto.setAddressCode("110114");//住宅地址行政区划编号
//        creditApplyReqDto.setAddressStr("北京昌平");//住宅地址行政区划
//        creditApplyReqDto.setAddressInfo("北京昌平天通西苑五本1号楼1单元101");//住宅地址
//        creditApplyReqDto.setHomeTel("13525677809");//住宅电话
//        creditApplyReqDto.setMarriage("U");//婚姻状况 U未婚 M已婚 D离婚 W丧偶
//        creditApplyReqDto.setSpouseName("");//配偶姓名 已婚必填
//        creditApplyReqDto.setEducation("5");//最高学历 0无 1小学 2初中 3高中 4大专 5本科 6硕士 7博士
//        creditApplyReqDto.setEmail("");//电子邮箱
//        creditApplyReqDto.setLivingStatus("03");//居住状况 01自置有贷款 02自置无贷款 03租赁 04其他
//        creditApplyReqDto.setRegisteredHouse("");//户籍
//        creditApplyReqDto.setRegisteredPlace("");//户籍所在地
//        creditApplyReqDto.setCheckDate("");//本地居住时长 单位月
//        creditApplyReqDto.setAddressType("01");//通讯地址类型 01住宅 02单位
//        creditApplyReqDto.setSpouseCertType("");//配偶证件类型 已婚必填
//        creditApplyReqDto.setSpouseCertNo("");//配偶证件号码 已婚必填
//        creditApplyReqDto.setSpouseMobile("");//配偶手机号
//        creditApplyReqDto.setCustFlag("02");//客户标识 01自雇 02受薪
//        creditApplyReqDto.setRegCertCode("");//工商登记证号 客户标识为1自雇时，录入
//        creditApplyReqDto.setManageName("");//经营实体名称 客户标识为1自雇时，录入
//        creditApplyReqDto.setManageOwner("");//经营场所所有权 客户标识为1自雇时，录入
//        creditApplyReqDto.setManageAddressId("");//经营地址行政区划编号 客户标识为1自雇时，录入
//        creditApplyReqDto.setManageYear("");//经营年限 客户标识为1自雇时，录入
//        creditApplyReqDto.setManageAddress("");//经营地址 客户标识为1自雇时，录入
//        creditApplyReqDto.setManageTrade("");//经营行业 客户标识为1自雇时，录入
//        creditApplyReqDto.setManageTradeName("");//经营行业名称 客户标识为1自雇时，录入
//        creditApplyReqDto.setManageIncome("0.00");//企业年收入 客户标识为1自雇时，录入
//        creditApplyReqDto.setManageEmployee("");//员工人数 客户标识为1自雇时，录入
//        creditApplyReqDto.setCommpannyName("融信通");  //单位名称 客户标识为2受薪时，录入
//        creditApplyReqDto.setCommpannyTrade("J");//单位所属行业 客户标识为2受薪时，录入
//        creditApplyReqDto.setCommpannyTradeName("金融业");//单位所属行业名称 客户标识为2受薪时，录入
//        creditApplyReqDto.setCommpannyType("0");//单位性质 客户标识为2受薪时，录入 0私营企业
//        creditApplyReqDto.setCommpannyAddressId("110114");//单位地址行政区划编号 客户标识为2受薪时，录入
//        creditApplyReqDto.setCommpannyStr("北京昌平");//单位地址行政区划 客户标识为2受薪时，录入
//        creditApplyReqDto.setCommpannyAddress("北京昌平北苑路北奥城荣富中心");//单位地址 客户标识为2受薪时，录入
//        creditApplyReqDto.setCommpannyPhone("0324123123");//单位电话 客户标识为2受薪时，录入
//        creditApplyReqDto.setCommLoanIncome("20000.00");//借款人年收入 客户标识为2受薪时，录入
//        creditApplyReqDto.setCommpannyYear("1");//本单位工作年限 客户标识为2受薪时，录入
//        creditApplyReqDto.setCommpannyJob("1");//职务 客户标识为2受薪时，录入 0高级领导 1一般员工 2中级领导 3其他 4未知
//        creditApplyReqDto.setCommpannyTitle("1");//职称 客户标识为2受薪时，录入 0无 1高级 2中级 3初级 4未知
//        creditApplyReqDto.setCommpannyVocation("0");//职业 客户标识为2受薪时，录入 0专业技术人员 1国家机关事业单位 2生产运输 3农林牧渔水利生产 4商业服务业 5办事人员 6军人 7不便分类 8未知
//        creditApplyReqDto.setCommpannyPost("开发");//岗位 客户标识为2受薪时，录入
//        creditApplyReqDto.setProduct("13");//产品编号 4随E贷款 5E享贷 6马上贷 11多收多贷 12丰收贷 13订单贷
//        creditApplyReqDto.setCreditAmt("100.00");//授信金额
//        creditApplyReqDto.setRepayType("3");//还款方式 1等额本息还款 2等额本金还款 3等额递增 4按期付息还本 9其他
//        creditApplyReqDto.setApplyTerm("1");//期限 单位月
//        creditApplyReqDto.setRepaySource("工资");//还款来源
//        creditApplyReqDto.setPayDay("10");//还款日
//        creditApplyReqDto.setPayDistance("30");//还款间隔
//        creditApplyReqDto.setAssureMeansMain("01");//担保方式 01信用金额保证金 02抵押 03 质押 04保证
//        creditApplyReqDto.setPayType("0");//支付方式 0自主支付 1受托支付 2组合支付
//        creditApplyReqDto.setLoanUse("01");//贷款用途 01购车 02装修 03固定资产技术改造 04无具体用途 05购房 ……
//        creditApplyReqDto.setApplyChannel("01");//进件渠道 01行内 02金蝶 03随手记 04银税平台 05国誉 06其他 07手机银行 08PAD 09平台金融
//
//        ArrayList<CustRelReqDto> custRelReqDtos = new ArrayList<>();
//        CustRelReqDto custRelReqDto = new CustRelReqDto();
//        custRelReqDto.setRelType("01");//关系类型 01直属联系人 02其他联系人
//        custRelReqDto.setRelName("全渠道");//关系人姓名
//        custRelReqDto.setRelCustRelation("08");//与申请人关系 01父母 02配偶 03子女 04兄弟姐妹 05朋友 06同事 07合伙人 08其他
//        custRelReqDto.setRelPhone("18909102364");//关系人联系电话
//        custRelReqDto.setRelAddress("北京");//关系人家庭住址
//        custRelReqDto.setRelComName("");//关系人单位名称
//        custRelReqDto.setRelComAddress("");//关系人单位地址
//        custRelReqDto.setRelComPhone("");//关系人单位电话
//        custRelReqDtos.add(custRelReqDto);
//        creditApplyReqDto.setCustRelDto(custRelReqDtos);
//
//        ArrayList<OrderInfoReqDto> orderInfoReqDtos = new ArrayList<>();
//        OrderInfoReqDto orderInfoReqDto = new OrderInfoReqDto();
//        orderInfoReqDto.setOrderNo("111220"); //订单编号 融资产品为订单贷时订单信息不能空
//        orderInfoReqDtos.add(orderInfoReqDto);
//        creditApplyReqDto.setOrderInfoDto(orderInfoReqDtos);
//
//        //受托列表
//        ArrayList<EntrustReqDto> entrustReqDtos = new ArrayList<>();
//        EntrustReqDto entrustReqDto = new EntrustReqDto();
//        entrustReqDto.setAssetNo("");//账号 支付方式是受托时必输
//        entrustReqDto.setBankNo("");//开户行号 支付方式是受托时必输
//        entrustReqDto.setBankName("");//开户行名称 支付方式是受托时必输
//        entrustReqDto.setAssetName("");//户名 支付方式是受托时必输
//        entrustReqDto.setIsBaoShang("");//是否行内 支付方式是受托时必输
//        entrustReqDto.setAmount("");//金额 支付方式是受托时必输
//        entrustReqDtos.add(entrustReqDto);
//        creditApplyReqDto.setEntrustDto(entrustReqDtos);
//
//        ArrayList<FileReqDto> fileReqDtos = new ArrayList<>();
//        FileReqDto fileReqDto = new FileReqDto();
//        fileReqDto.setSerialNo("");//业务流水
//        fileReqDto.setBussTime("");//业务时间
//        fileReqDtos.add(fileReqDto);
//        creditApplyReqDto.setFileDto(fileReqDtos);
//
//        creditApplyReqDto.setFinancRate("0.0931");//授信申请利率
//        creditApplyReqDto.setIsCircle("0");//是否循环合同 0否 1是
//        creditApplyReqDto.setIsMultiLoan("0");//是否多次放贷 0否 1是
//        creditApplyReqDto.setAuditDatas("");//资质审核数据
//        creditApplyReqDto.setLoanNo("");//放款账号

        //以上：个人会员授信申请

        //以下：企业会员授信申请

        CreditApplyReqDto creditApplyReqDto = new CreditApplyReqDto();
        creditApplyReqDto.setChannelNo("rongxin");//渠道编号
        creditApplyReqDto.setCustNo("2200014461");//平台会员号
        creditApplyReqDto.setPlatApplyNo("000987");//平台申请编号
        creditApplyReqDto.setCustName("赵明");//客户名称
        creditApplyReqDto.setCertType("01");//证件类型 01身份证 02军官证 03警官证 04士兵证 …………
        creditApplyReqDto.setCertNo("110101199411070037");//证件号码
        creditApplyReqDto.setCertValidDate("长期");//证件有效期
        creditApplyReqDto.setCertStartDate("20121230");//证件起始日
        creditApplyReqDto.setCertLengthDate("长期");//证件到期日
        creditApplyReqDto.setCustType("03");//客户类型 01一般自然人 02个体工商户 03企业法人 …………
        creditApplyReqDto.setIsBankStaff("0");//是否我行员工 0否 1是
        creditApplyReqDto.setAge("33");//年龄
        creditApplyReqDto.setBirthDate("19941107");//出生日期
        creditApplyReqDto.setMobileNo("18566654484");//手机号码
        creditApplyReqDto.setGender("M");//性别 M男 F女
        creditApplyReqDto.setCountry("01");//国籍 01中华人民共和国 02中国台湾 03香港 04澳门
        creditApplyReqDto.setAddressCode("110114");//住宅地址行政区划编号
        creditApplyReqDto.setAddressStr("北京昌平");//住宅地址行政区划
        creditApplyReqDto.setAddressInfo("北京昌平天通西苑五本1号楼1单元101");//住宅地址
        creditApplyReqDto.setHomeTel("13525677809");//住宅电话
        creditApplyReqDto.setMarriage("U");//婚姻状况 U未婚 M已婚 D离婚 W丧偶
        creditApplyReqDto.setSpouseName("");//配偶姓名 已婚必填
        creditApplyReqDto.setEducation("5");//最高学历 0无 1小学 2初中 3高中 4大专 5本科 6硕士 7博士
        creditApplyReqDto.setEmail("");//电子邮箱
        creditApplyReqDto.setLivingStatus("03");//居住状况 01自置有贷款 02自置无贷款 03租赁 04其他
        creditApplyReqDto.setRegisteredHouse("");//户籍
        creditApplyReqDto.setRegisteredPlace("");//户籍所在地
        creditApplyReqDto.setCheckDate("");//本地居住时长 单位月
        creditApplyReqDto.setAddressType("01");//通讯地址类型 01住宅 02单位
        creditApplyReqDto.setSpouseCertType("");//配偶证件类型 已婚必填
        creditApplyReqDto.setSpouseCertNo("");//配偶证件号码 已婚必填
        creditApplyReqDto.setSpouseMobile("");//配偶手机号
        creditApplyReqDto.setCustFlag("01");//客户标识 01自雇 02受薪
        creditApplyReqDto.setRegCertCode("201812263088311693");//工商登记证号 客户标识为1自雇时，录入
        creditApplyReqDto.setManageName("融信通");//经营实体名称 客户标识为1自雇时，录入
        creditApplyReqDto.setManageOwner("04");//经营场所所有权 客户标识为1自雇时，录入
        creditApplyReqDto.setManageAddressId("110114");//经营地址行政区划编号 客户标识为1自雇时，录入
        creditApplyReqDto.setManageYear("8");//经营年限 客户标识为1自雇时，录入
        creditApplyReqDto.setManageAddress("北京昌平北苑路北奥城荣富中心");//经营地址 客户标识为1自雇时，录入
        creditApplyReqDto.setManageTrade("6631");//经营行业 客户标识为1自雇时，录入  参照国标STD_GB_T4754-2011
        creditApplyReqDto.setManageTradeName("金融租赁服务");//经营行业名称 客户标识为1自雇时，录入  参照国标STD_GB_T4754-2011
        creditApplyReqDto.setManageIncome("100000.00");//企业年收入 客户标识为1自雇时，录入
        creditApplyReqDto.setManageEmployee("43");//员工人数 客户标识为1自雇时，录入
        creditApplyReqDto.setCommpannyName("");  //单位名称 客户标识为2受薪时，录入
        creditApplyReqDto.setCommpannyTrade("");//单位所属行业 客户标识为2受薪时，录入
        creditApplyReqDto.setCommpannyTradeName("");//单位所属行业名称 客户标识为2受薪时，录入
        creditApplyReqDto.setCommpannyType("");//单位性质 客户标识为2受薪时，录入 0私营企业
        creditApplyReqDto.setCommpannyAddressId("");//单位地址行政区划编号 客户标识为2受薪时，录入
        creditApplyReqDto.setCommpannyStr("");//单位地址行政区划 客户标识为2受薪时，录入
        creditApplyReqDto.setCommpannyAddress("");//单位地址 客户标识为2受薪时，录入
        creditApplyReqDto.setCommpannyPhone("");//单位电话 客户标识为2受薪时，录入
        creditApplyReqDto.setCommLoanIncome("0.00");//借款人年收入 客户标识为2受薪时，录入
        creditApplyReqDto.setCommpannyYear("");//本单位工作年限 客户标识为2受薪时，录入
        creditApplyReqDto.setCommpannyJob("");//职务 客户标识为2受薪时，录入 0高级领导 1一般员工 2中级领导 3其他 4未知
        creditApplyReqDto.setCommpannyTitle("");//职称 客户标识为2受薪时，录入 0无 1高级 2中级 3初级 4未知
        creditApplyReqDto.setCommpannyVocation("");//职业 客户标识为2受薪时，录入 0专业技术人员 1国家机关事业单位 2生产运输 3农林牧渔水利生产 4商业服务业 5办事人员 6军人 7不便分类 8未知
        creditApplyReqDto.setCommpannyPost("");//岗位 客户标识为2受薪时，录入
        creditApplyReqDto.setProduct("13");//产品编号 4随E贷款 5E享贷 6马上贷 11多收多贷 12丰收贷 13订单贷
        creditApplyReqDto.setCreditAmt("100.00");//授信金额
        creditApplyReqDto.setRepayType("3");//还款方式 1等额本息还款 2等额本金还款 3等额递增 4按期付息还本 9其他
        creditApplyReqDto.setApplyTerm("1");//期限 单位月
        creditApplyReqDto.setRepaySource("工资");//还款来源
        creditApplyReqDto.setPayDay("10");//还款日
        creditApplyReqDto.setPayDistance("30");//还款间隔
        creditApplyReqDto.setAssureMeansMain("01");//担保方式 01信用金额保证金 02抵押 03 质押 04保证
        creditApplyReqDto.setPayType("0");//支付方式 0自主支付 1受托支付 2组合支付
        creditApplyReqDto.setLoanUse("01");//贷款用途 01购车 02装修 03固定资产技术改造 04无具体用途 05购房 ……
        creditApplyReqDto.setApplyChannel("01");//进件渠道 01行内 02金蝶 03随手记 04银税平台 05国誉 06其他 07手机银行 08PAD 09平台金融

        ArrayList<CustRelReqDto> custRelReqDtos = new ArrayList<>();
        CustRelReqDto custRelReqDto = new CustRelReqDto();
        custRelReqDto.setRelType("01");//关系类型 01直属联系人 02其他联系人
        custRelReqDto.setRelName("全渠道");//关系人姓名
        custRelReqDto.setRelCustRelation("08");//与申请人关系 01父母 02配偶 03子女 04兄弟姐妹 05朋友 06同事 07合伙人 08其他
        custRelReqDto.setRelPhone("18909102364");//关系人联系电话
        custRelReqDto.setRelAddress("北京");//关系人家庭住址
        custRelReqDto.setRelComName("");//关系人单位名称
        custRelReqDto.setRelComAddress("");//关系人单位地址
        custRelReqDto.setRelComPhone("");//关系人单位电话
        custRelReqDtos.add(custRelReqDto);
        creditApplyReqDto.setCustRelDto(custRelReqDtos);

        ArrayList<OrderInfoReqDto> orderInfoReqDtos = new ArrayList<>();
        OrderInfoReqDto orderInfoReqDto = new OrderInfoReqDto();
        orderInfoReqDto.setOrderNo("111197"); //订单编号 融资产品为订单贷时订单信息不能空
        orderInfoReqDtos.add(orderInfoReqDto);
        creditApplyReqDto.setOrderInfoDto(orderInfoReqDtos);

        //受托列表
        ArrayList<EntrustReqDto> entrustReqDtos = new ArrayList<>();
        EntrustReqDto entrustReqDto = new EntrustReqDto();
        entrustReqDto.setAssetNo("");//账号 支付方式是受托时必输
        entrustReqDto.setBankNo("");//开户行号 支付方式是受托时必输
        entrustReqDto.setBankName("");//开户行名称 支付方式是受托时必输
        entrustReqDto.setAssetName("");//户名 支付方式是受托时必输
        entrustReqDto.setIsBaoShang("");//是否行内 支付方式是受托时必输
        entrustReqDto.setAmount("");//金额 支付方式是受托时必输
        entrustReqDtos.add(entrustReqDto);
        creditApplyReqDto.setEntrustDto(entrustReqDtos);

        ArrayList<FileReqDto> fileReqDtos = new ArrayList<>();
        FileReqDto fileReqDto = new FileReqDto();
        fileReqDto.setSerialNo("");//业务流水
        fileReqDto.setBussTime("");//业务时间
        fileReqDtos.add(fileReqDto);
        creditApplyReqDto.setFileDto(fileReqDtos);

        creditApplyReqDto.setFinancRate("0.0931");//授信申请利率
        creditApplyReqDto.setIsCircle("0");//是否循环合同 0否 1是
        creditApplyReqDto.setIsMultiLoan("0");//是否多次放贷 0否 1是
        creditApplyReqDto.setAuditDatas("");//资质审核数据
        creditApplyReqDto.setLoanNo("");//放款账号
        rxtBsbOperatorServerImp.creditApplyNotify(creditApplyReqDto, BankTransInfoEnum.授信申请接受);
    }

    /**
     * 3.1.2.在线授信申请状态查询（实时模式）
     */
    @Test
    public void creditApplyState() {
        CreditApplyStateReqDto creditApplyStateReqDto = new CreditApplyStateReqDto();
        creditApplyStateReqDto.setApplyNo("000988");//申请编号
        rxtBsbOperatorServerImp.creditApplyState(creditApplyStateReqDto,
                BankTransInfoEnum.在线授信申请的状态查询);

    }


    /**
     * 4.2 提款申请 （网关模式）
     */
    @Test
    public void withdrawalApply() {
        WithdrawalApplyReqDto withdrawalApplyReqDto = new WithdrawalApplyReqDto();
        withdrawalApplyReqDto.setChnlNo("rongxin");////渠道编号
        withdrawalApplyReqDto.setDwmAplyNo("000885");//提款申请编号
        withdrawalApplyReqDto.setCrgAplyNp("000988");//授信申请编号
        withdrawalApplyReqDto.setCstNo("2200014461");//客户编号
        withdrawalApplyReqDto.setCstNm("赵明");//客户名称
        withdrawalApplyReqDto.setLoanAmt("100.00");//贷款金额
        withdrawalApplyReqDto.setCcy("01");//币种
        withdrawalApplyReqDto.setLoanTrm("10");//贷款期限 1-99999
        withdrawalApplyReqDto.setLoanTrmUnit("D");//贷款期限单位 默认月 Y年 M月 D天
        withdrawalApplyReqDto.setPyMd("0");//支付方式 0自主支付 1受托支付 2组合支付
        withdrawalApplyReqDto.setRepyDy("15");//还款日
        withdrawalApplyReqDto.setRepyItrv("2");//还款间隔
        withdrawalApplyReqDto.setRepyCyc("M");//还款周期 D按日 W按周 M按月 S按季 Y按年 HY按半年
        withdrawalApplyReqDto.setRpMd("3");//还款方式 1等额本息还款 2等额本金还款 3等额递增 4按期付息还本 9其他
        withdrawalApplyReqDto.setModeNumber("");//模式编号
        withdrawalApplyReqDto.setPdNo("13");//产品编号* 4随E贷款 5E享贷 6马上贷 11多收多贷 12丰收贷 13订单贷
        withdrawalApplyReqDto.setDocumentType("");//证件类型
        withdrawalApplyReqDto.setDocumentNumber("");//证件号码
        withdrawalApplyReqDto.setAccNo("");//贷款账号
        withdrawalApplyReqDto.setRepaymentAccount("");//还款账号

        ArrayList<EntrstdPayListReqDto> list = new ArrayList<>();
        EntrstdPayListReqDto entrstdPayListReqDto = new EntrstdPayListReqDto();
        entrstdPayListReqDto.setEntrstdAccNo("");
        entrstdPayListReqDto.setDepBnkNo("");
        entrstdPayListReqDto.setDepBnkNm("");
        entrstdPayListReqDto.setEntrstdAccNm("");
        entrstdPayListReqDto.setIsBnkInsidAccNo("");
        entrstdPayListReqDto.setEntrstdAmt("");
        list.add(entrstdPayListReqDto);

        ArrayList<OrdrInfoReqDto> orderInfoReqDtos = new ArrayList<>();
        OrdrInfoReqDto ordrInfoReqDto = new OrdrInfoReqDto();
        ordrInfoReqDto.setOrdrNo("111198");//订单编号
        orderInfoReqDtos.add(ordrInfoReqDto);

        //withdrawalApplyReqDto.setEntrstdPayList(list);
        withdrawalApplyReqDto.setOrederList(orderInfoReqDtos);

        rxtBsbOperatorServerImp.withdrawalApply(withdrawalApplyReqDto,
                BankTransInfoEnum.提款申请);

    }

    /**
     * 4.3 合同签署（网关模式）
     */
    @Test
    public void contractSign() {
        ContractSignReqDto contractSignReqDto = new ContractSignReqDto();
        contractSignReqDto.setRebackURL("www.baidu.com");//商户页面回调URL
        contractSignReqDto.setNotifyURL("http://14.18.161.58:9399/bsbFront/contractSignResultServlet");//商户通知回调URL
        contractSignReqDto.setSubAcctNo("9956760999679500000015");//资金账号
        contractSignReqDto.setContractNo("20191401GR221421");//合同编号 合同协议列表查询获得

        rxtBsbOperatorServerImp.contractSign(contractSignReqDto, BankTransInfoEnum.合同签署);

    }

    /**
     * 3.1.4.提款申请状态查询（实时模式）
     */
    @Test
    public void withdrawalApplyState() {
        WithdrawalApplyStateReqDto withdrawalApplyStateReqDto = new WithdrawalApplyStateReqDto();
        withdrawalApplyStateReqDto.setApplyNo("000886");//提款申请编号

        rxtBsbOperatorServerImp.withdrawalApplyState(withdrawalApplyStateReqDto, BankTransInfoEnum.提款申请状态查询);

    }

    /**
     * 3.1.5.商户资金账户利息试算（实时模式）
     */
    @Test
    public void interestTrial() {
        InterestTrialReqDto interestTrialReqDto = new InterestTrialReqDto();
        interestTrialReqDto.setChannelNo("rongxin");//渠道编号
        interestTrialReqDto.setFinancApplyNo("000886");//融资申请编号  融资申请时的编号，用于查询融资信息
        interestTrialReqDto.setRepayType("0");//还款范围 0全额还款 1指定金额 2指定本金
        interestTrialReqDto.setRepayAssetNo("9956760999679500000013");//还款账号
        interestTrialReqDto.setRepayAmt("10.00");//还款金额

        rxtBsbOperatorServerImp.interestTrial(interestTrialReqDto, BankTransInfoEnum.商户资金账户利息试算);

    }

    /**
     * 3.1.6.商户资金账户提前还款（实时模式）
     */
    @Test
    public void earlyRepayment() {
        EarlyRepaymentReqDto earlyRepaymentReqDto = new EarlyRepaymentReqDto();
        earlyRepaymentReqDto.setChannelNo("rongxin");//渠道编号
        earlyRepaymentReqDto.setFinancApplyNo("000886");//融资申请编号 融资申请时的编号，用于查询融资信息
        earlyRepaymentReqDto.setRepayType("1");//还款范围 0全额还款 1指定金额 2指定本金
        earlyRepaymentReqDto.setRepayAssetNo("9956760999679500000013");//还款账号
        earlyRepaymentReqDto.setRepayAmt("10.00");//还款金额
        earlyRepaymentReqDto.setUnRepayPrin("");//未归还本金
        earlyRepaymentReqDto.setLoanAmt("");//贷款金额
        earlyRepaymentReqDto.setRepayPrinAmt("");//还款本金 还款本金！ 指定本金时 此为必输项
        earlyRepaymentReqDto.setMerMemberNo("01240113");//平台会员号

        rxtBsbOperatorServerImp.earlyRepayment(earlyRepaymentReqDto,
                BankTransInfoEnum.商户资金账户提前还款);

    }

}

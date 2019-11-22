package rxt.bsb.rest.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rxt.bsb.rest.common.Enums.ResultCode;
import rxt.bsb.rest.po.ContrUsercontract;
import rxt.bsb.rest.service.SignAgreementService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("sign")
public class SignAgreementController {
    private static Logger logger = LoggerFactory.getLogger(SignAgreementController.class);

    @Autowired
    private SignAgreementService signAgreementService;

    //pdf文件预览
    @RequestMapping(value = "helloPdf")
    public void showPdf(HttpServletResponse response)  {

        try {
            signAgreementService.signAgreement(response);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("文件预览异常");
        }
    }


    //提交保存数据
    @PostMapping("subInfo")
    public ResultCode subInfo(HttpServletRequest request,ContrUsercontract contrUsercontract){
        try {
            Integer count = signAgreementService.subInfo(request,contrUsercontract);
            if(count == 0){
                return ResultCode.ERROR;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("提交数据异常",e);
            return ResultCode.ERROR;
        }
        return ResultCode.SUCCESS;
    }

}

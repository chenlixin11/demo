package rxt.bsb.rest.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rxt.bsb.rest.common.Enums.ResultCode;
import rxt.bsb.rest.po.CreditApply;
import rxt.bsb.rest.service.CreditInfoService;
import rxt.bsb.rest.vo.QueryVO.QueryCreditApplyVO;
import rxt.bsb.rest.vo.showVO.ShowCreditApplyVO;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("creditInfo")
public class CreditInfoController {

    @Autowired
    private CreditInfoService creditInfoService;

    /**
     * 分页查询
     */
    @RequestMapping( value = "page" ,method = { RequestMethod.GET ,RequestMethod.POST})
    PageInfo<ShowCreditApplyVO> queryCreditApplyPage(HttpServletRequest request, QueryCreditApplyVO creditApply, @RequestParam(name = "pageNo" ,defaultValue = "1") int pageNo , @RequestParam(name = "pageSize" ,defaultValue = "10")int pageSize ){
        Page<ShowCreditApplyVO> page = creditInfoService.queryCreditApplyPage(creditApply, pageNo, pageSize);
        PageInfo<ShowCreditApplyVO> uPage=  new PageInfo<>(page);
        return uPage;
    }


    /**
     * 保存
     */
    @RequestMapping( value = "save" ,method = {RequestMethod.POST})
    public Object  saveCreditApply(CreditApply creditApply) {
        return  creditInfoService.insertCreditApply(creditApply) == 1 ? ResultCode.SUCCESS: ResultCode.ERROR;
    }

    /**
     * 修改
     */
    @RequestMapping( value = "update" ,method = {RequestMethod.POST} )
    public Object  updateCreditApply(CreditApply creditApply) {
        return creditInfoService.updateCreditApply(creditApply) == 1 ? ResultCode.SUCCESS: ResultCode.ERROR;
    }

    /**
     * 删除
     */
    @RequestMapping( value = "del" ,method = {RequestMethod.POST})
    public Object  delCreditApply(CreditApply creditApply) {
        return creditInfoService.deleteCreditApply(creditApply) == 1 ? ResultCode.SUCCESS: ResultCode.ERROR;
    }

}

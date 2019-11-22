package rxt.bsb.rest.web;

import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rxt.bsb.rest.common.Enums.ResultCode;
import rxt.bsb.rest.common.page.PageInfo;
import rxt.bsb.rest.po.MerchantAcct;
import rxt.bsb.rest.service.MerchantAcctService;

@RestController
@RequestMapping("merchant")
public class MerchantacctController {
    private static Logger logger = LoggerFactory.getLogger(MerchantacctController.class);


    @Autowired
    private MerchantAcctService merchantAcctService;

    @PostMapping("findById")
    public MerchantAcct find(Integer id) {
        MerchantAcct merchantAcct = merchantAcctService.find(id);
        return merchantAcct;

    }

    //分页+条件查询
    @GetMapping("acct")
    public PageInfo<MerchantAcct> findByPage(MerchantAcct merchant,
                                             @RequestParam(defaultValue = "1") Integer pageNo,
                                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<MerchantAcct> pageInfo = null;
        try {
            Page<MerchantAcct> merchantAcct = merchantAcctService.findByPage(merchant,pageNo, pageSize);
            pageInfo = new PageInfo<>(merchantAcct);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("分页查询商户账户异常",e);
        }
        return pageInfo;
    }

    //添加
    @PostMapping("acct")
    public ResultCode save(MerchantAcct merchantAcct) {
        try {
            Integer count = merchantAcctService.save(merchantAcct);
            if (count == 0) {
                return ResultCode.ERROR;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("添加商户账户异常",e);
            return ResultCode.ERROR;
        }
        return ResultCode.SUCCESS;
    }

    //修改
    @PutMapping("acct")
    public ResultCode update(MerchantAcct merchantAcct) {
        try {
            Integer count = merchantAcctService.update(merchantAcct);
            if (count == 0) {
                return ResultCode.ERROR;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("修改商户账户异常",e);
            return ResultCode.ERROR;
        }
        return ResultCode.SUCCESS;
    }

    //删除
    @DeleteMapping("acct/{id}")
    public ResultCode delete(@PathVariable Integer id) {
        try {
            Integer count = merchantAcctService.delete(id);
            if (count == 0) {
                return ResultCode.ERROR;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除商户账户异常",e);
            return ResultCode.ERROR;
        }
        return ResultCode.SUCCESS;
    }
}

package rxt.bsb.rest.web;

import com.github.pagehelper.Page;
import org.aspectj.weaver.ast.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rxt.bsb.rest.common.ApiResult;
import rxt.bsb.rest.common.Enums.ResultCode;
import rxt.bsb.rest.common.page.PageInfo;
import rxt.bsb.rest.common.util.ValidateUtils;
import rxt.bsb.rest.po.OrdersInfo;
import rxt.bsb.rest.service.OrderInfoService;
import rxt.bsb.rest.vo.UserVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: rxt-bsb
 * @description:
 * @author: Mr.zgq
 * @create: 2019-10-21 15:21
 **/
@RestController
@RequestMapping("order")
public class OrderInfoController {
    private static Logger logger = LoggerFactory.getLogger(MerchantacctController.class);
    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 分页查询
     */
    @RequestMapping( value = "page" ,method = { RequestMethod.GET ,RequestMethod.POST})
    PageInfo<OrdersInfo> queryOrdersInfoPage(HttpServletRequest request, OrdersInfo ordersInfo,
                                             @RequestParam(name = "pageNo" ,defaultValue = "1") int pageNo ,
                                             @RequestParam(name = "pageSize" ,defaultValue = "10")int pageSize ){
        Page<OrdersInfo> page = orderInfoService.queryOrdersInfoPage(ordersInfo,pageNo,pageSize);
        PageInfo<OrdersInfo> showPage=  new PageInfo<>(page);
        return showPage;
    }

    /**
     * 保存
     */
    @RequestMapping( value = "save" ,method = {RequestMethod.POST})
    public Object  addOrdersInfo(HttpServletRequest request,OrdersInfo ordersInfo) {
        try {
            UserVO userVO = (UserVO)request.getSession().getAttribute("userVO");
            //校验该客户下订单编号是否存在重复
            OrdersInfo info = orderInfoService.queryOrdersInfoByOrderNo(userVO.getAgentInfo().getId(),ordersInfo.getBillCode());
            if(ValidateUtils.isNotEmpty(info)){
                return ApiResult.errorOf("订单编号已存在");
            }

            //添加
            int count = orderInfoService.addOrdersInfo( ordersInfo);
            if(count == 0){
                return ResultCode.ERROR;
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("添加订单异常",e.getMessage());
            return ResultCode.SERVER_ERROR;
        }
        return ResultCode.SUCCESS;
    }

    /**
     * 修改
     */
    @RequestMapping( value = "update" ,method = {RequestMethod.POST} )
    public Object  updateOrdersInfo(OrdersInfo ordersInfo) {
        try {
            int count = orderInfoService.updateOrdersInfo( ordersInfo);
            if(count == 0){
                return ResultCode.ERROR;
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("修改订单异常",e.getMessage());
            return ResultCode.SERVER_ERROR;
        }
        return ResultCode.SUCCESS;
    }

    /**
     * 删除
     */
    @RequestMapping( value = "delete" ,method = {RequestMethod.DELETE})
    public Object  deleteOrderInfo(OrdersInfo ordersInfo) {
        try {
            int count = orderInfoService.deleteOrdersInfo(ordersInfo);
            if(count==0){
                return ResultCode.ERROR;
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("删除订单异常",e.getMessage());
            return ResultCode.SERVER_ERROR;
        }
        return ResultCode.SUCCESS;
    }

    /**
     * 删除
     */
    @RequestMapping( value = "delete1" ,method = {RequestMethod.DELETE})
    public Object  deleteOrderInfo(int id) {
        try {
            int count = orderInfoService.deleteOrdersInfo1(id);
            if(count==0){
                return ResultCode.ERROR;
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("删除订单异常",e.getMessage());
            return ResultCode.SERVER_ERROR;
        }
        return ResultCode.SUCCESS;
    }


}

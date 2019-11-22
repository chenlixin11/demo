package rxt.bsb.rest.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rxt.bsb.rest.dao.OrdersInfoDao;
import rxt.bsb.rest.po.OrdersInfo;

import java.util.Date;

/**
 * @program: rxt-bsb
 * @description:
 * @author: Mr.Wang
 * @create: 2019-10-21 15:47
 **/
@Service
public class OrderInfoService {
    @Autowired
    private OrdersInfoDao ordersInfoDao;

    /**
     * 查询
     * @param ordersInfo
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<OrdersInfo> queryOrdersInfoPage(OrdersInfo ordersInfo, int pageNo, int pageSize) {
        PageHelper.startPage( pageNo, pageSize );
        Page<OrdersInfo> page  = ordersInfoDao.queryOrdersInfoPage( ordersInfo );
        return page;
    }

    /**
     * 添加
     * @param ordersInfo
     */
    public int addOrdersInfo(OrdersInfo ordersInfo) {
        ordersInfo.setId(null);
        ordersInfo.setOperateFlag("1");//操作标志 (1:新增；2：更新)
        ordersInfo.setCreateTime(new Date());
        return ordersInfoDao.insert(ordersInfo);
    }

    public OrdersInfo queryOrdersInfoByOrderNo(Integer agentInfoId,String billCode) {
        return ordersInfoDao.queryOrdersInfoByOrderNo(agentInfoId,billCode);
    }


    /**
     * 删除订单
     * @param ordersInfo
     * @return
     */
    public int deleteOrdersInfo(OrdersInfo ordersInfo) {
        return ordersInfoDao.deleteByPrimaryKey(ordersInfo.getId());

    }
    public int deleteOrdersInfo1(Integer id) {
        return ordersInfoDao.deleteByPrimaryKey(id);

    }

    /**
     *
     * @param ordersInfo
     * @return
     */
    public int updateOrdersInfo(OrdersInfo ordersInfo) {
        return ordersInfoDao.updateByPrimaryKeySelective(ordersInfo);
    }
}

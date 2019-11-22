package rxt.bsb.rest.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.OrdersInfo;

@Mapper
public interface OrdersInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(OrdersInfo record);

    int insertSelective(OrdersInfo record);

    OrdersInfo selectByPrimaryKey(Integer id);

    OrdersInfo queryOrdersInfoByOrderNo(Integer agentInfoId, String orderNo);

    int updateByPrimaryKeySelective(OrdersInfo record);

    int updateByPrimaryKey(OrdersInfo record);

    Page<OrdersInfo> queryOrdersInfoPage(OrdersInfo ordersInfo);
}
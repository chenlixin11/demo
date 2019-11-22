package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.OrderPayDetail;
@Mapper
public interface OrderPayDetailDao {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderPayDetail record);

    int insertSelective(OrderPayDetail record);

    OrderPayDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderPayDetail record);

    int updateByPrimaryKey(OrderPayDetail record);
}
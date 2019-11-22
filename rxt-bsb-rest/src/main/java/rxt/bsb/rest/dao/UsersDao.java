package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.Users;

@Mapper
public interface UsersDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    Users selectByUserName(String userName);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

}
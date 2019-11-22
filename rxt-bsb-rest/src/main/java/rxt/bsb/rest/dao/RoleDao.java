package rxt.bsb.rest.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.Role;

import java.util.List;

@Mapper
public interface RoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    Role queryRoleByUserType(Integer userType);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    Page<Role> queryRolePage();

    List<Role> queryRoleList();
}
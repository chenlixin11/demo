package rxt.bsb.rest.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rxt.bsb.rest.dao.RoleDao;
import rxt.bsb.rest.po.Role;

import java.util.Date;
import java.util.List;


@Service
public class RoleService {


    @Autowired
    private RoleDao roleDao;

    public Page<Role> queryRolePage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        Page<Role> page  = roleDao.queryRolePage();
        return page;


    }

    public List<Role> roleList(){
        return roleDao.queryRoleList();
    }

    public int saveRole(Role r) {
        r.setId(null);
        r.setCreateTime( new Date());
        return roleDao.insert(r);
    }


    public int updateRole(Role r) {
        return roleDao.updateByPrimaryKeySelective(r);
    }

    public int rmRole(Role r) {
        return roleDao.deleteByPrimaryKey(r.getId());
    }



}

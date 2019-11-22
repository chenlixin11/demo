package rxt.bsb.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rxt.bsb.rest.common.ApiResult;
import rxt.bsb.rest.common.Enums.ResultCode;
import rxt.bsb.rest.common.util.Encipher;
import rxt.bsb.rest.common.util.ValidateUtils;
import rxt.bsb.rest.dao.UsersDao;
import rxt.bsb.rest.po.Users;

/**
 * @author <a href="mailto:wangjian@rokesoft.com">alw</a>
 * @Copyright (c)</ b> 2012融信通-版权所有<br/>
 * @createTime: 2019/10/25 17:33
 * @Description:
 */
@Service
public class UsersService {

    @Autowired
    private UsersDao usersDao;

    /**
     * 重置密码（管理员）
     */
    public int resetPwd(Integer userId) {
        Users users = usersDao.selectByPrimaryKey(userId);
        users.setPwd( Encipher.Encode( "123456" ));
        return usersDao.updateByPrimaryKeySelective(users);
    }

    /**
     * 修改密码（公共）
     */
    public Object updatePwd(String oldPwd, String newPwd,String userName) {
        Users users = usersDao.selectByUserName(userName);

        if( users == null) {
            return ApiResult.errorOf("查无此用户");
        }

        String dbPwd = users.getPwd();
        if(!Encipher.Decode(dbPwd).equals(oldPwd)) {
            return ApiResult.errorOf("原密码不正确");
        }

        users.setPwd(Encipher.Encode(newPwd));

        return usersDao.updateByPrimaryKeySelective(users) == 1 ? ResultCode.SUCCESS : ResultCode.ERROR;

    }

    public int selectByUserName(String userName) {
        Users users = usersDao.selectByUserName(userName);
        int n = 1;
        if(ValidateUtils.isEmpty(users)){
            n = 0;//不存在
        }
        return n;
    }
}

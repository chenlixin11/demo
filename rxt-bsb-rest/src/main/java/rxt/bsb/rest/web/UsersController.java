package rxt.bsb.rest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rxt.bsb.rest.common.Enums.ResultCode;
import rxt.bsb.rest.service.UsersService;
import rxt.bsb.rest.vo.UserVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="mailto:wangjian@rokesoft.com">alw</a>
 * @Copyright (c)</ b> 2012融信通-版权所有<br/>
 * @createTime: 2019/10/30 17:43
 * @Description:
 */
@RestController
@RequestMapping("users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * 修改密码（公共）
     */
    @PutMapping(value="updatePwd" )
    public  Object updatePwd(String oldPwd ,String newPwd,HttpServletRequest request) {
        UserVO userVO = (UserVO) request.getSession().getAttribute("userVO");
        String userName = userVO.getUsers().getUserName();
        return usersService.updatePwd(oldPwd,newPwd,userName);
    }

    /**
     * 校验用户名
     */
    @PutMapping(value="checkUsers")
    public Object checkUsers(String userName){
        //return usersService.selectByUserName(userName);
        return usersService.selectByUserName(userName) == 1 ? ResultCode.SUCCESS: ResultCode.ERROR;
    }
}

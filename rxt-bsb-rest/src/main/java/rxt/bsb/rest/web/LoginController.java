package rxt.bsb.rest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import rxt.bsb.rest.common.ApiResult;
import rxt.bsb.rest.common.util.SessionUtil;
import rxt.bsb.rest.service.LoginService;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: rxt-bsb
 * @description:
 * @author: Mr.zgq
 * @create: 2019-10-25 09:50
 **/
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService ;


    /**
     * 用户登录
     *
     * @return
     */
    @PostMapping("login")
    public Object login(HttpServletRequest request) {
       return loginService.login(request);
    }

    /**
     * 退出登录
     * @return
     */
    @PostMapping("logout")
    public Object logout() {
        SessionUtil.destory();
        return ApiResult.successOf("退出登录成功");
    }
}

package rxt.bsb.rest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rxt.bsb.rest.common.ApiResult;
import rxt.bsb.rest.common.Enums.ResultCode;
import rxt.bsb.rest.common.util.Encipher;
import rxt.bsb.rest.common.util.SessionUtil;
import rxt.bsb.rest.dao.*;
import rxt.bsb.rest.po.*;
import rxt.bsb.rest.vo.UserVO;
import rxt.bsb.rest.vo.showVO.ShowUserAndMenuVO;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: rxt-bsb
 * @description:
 * @author: Mr.zgq
 * @create: 2019-11-01 16:04
 **/
@Service
public class LoginService {
    private final static Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private UsersDao userDao ;

    @Autowired
    private AgentInfoDao agentInfoDao ;

    @Autowired
    private LogLoginInfoDao logLoginInfoDao ;

    @Autowired
    private PermissDao permissDao;

    @Autowired
    private RoleDao roleDao;

    /**
     * 用户登录
     *
     * @return
     */
    public Object login(HttpServletRequest request) {
        try {
            String userName = request.getParameter("uname");
            String passwd = request.getParameter("passwd");

            logger.info(String.format("%s,%s,%s",request.getSession().getId(), userName , passwd ) );

            Users u  = userDao.selectByUserName(userName);

            if( u == null)
                return ApiResult.errorOf("用户名或密码错误");

            if(!Encipher.Decode(u.getPwd()).equals(passwd))
                return ApiResult.errorOf("用户名或密码错误");

            //用户表id
            int usersId = u.getId();

            //获取客户ip
            String ip = SessionUtil.getIp();
            //保存登陆日志表
            LogLoginInfo logLoginInfo = new LogLoginInfo();
            logLoginInfo.setLoginIp(ip);
            logLoginInfo.setLoginTime(new Date());
            logLoginInfo.setUsersId(usersId);
            logLoginInfoDao.insert(logLoginInfo);

            //查询客户信息
            AgentInfo agentInfo = agentInfoDao.queryAgentInfoByUsersId(usersId);
            //组装session
            UserVO userVO = new UserVO();
            userVO.setUsers(u);
            userVO.setAgentInfo(agentInfo);
            request.getSession().setAttribute("userVO", userVO);

            /**
             * 查询用户权限资源并返回（ 这里目前只返回了菜单资源）
             */
            Role role = roleDao.queryRoleByUserType(u.getUserType());
            String permiss [] = role.getRolePermiss().split(",");
            List permissIds = new ArrayList();
            for(int i=0;i<permiss.length;i++){
                permissIds.add(permiss[i]);
            }
            List<Permiss> menu = permissDao.queryPermissByIds(permissIds);
            ShowUserAndMenuVO showUserAndMenuVO = new ShowUserAndMenuVO();
            showUserAndMenuVO.setUserVO(userVO);
            showUserAndMenuVO.setMenu(menu);
            return ApiResult.successOf( showUserAndMenuVO);

        } catch (Exception e) {
            e.printStackTrace();
            return ResultCode.SERVER_ERROR;
        }
    }
}

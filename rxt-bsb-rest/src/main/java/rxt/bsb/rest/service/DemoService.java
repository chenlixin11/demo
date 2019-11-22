package rxt.bsb.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rxt.bsb.api.dto.request.OpenPersonalAcctReqDto;
import rxt.bsb.api.server.RxtBsbOperatorServer;
import rxt.bsb.rest.dao.UsersDao;
import rxt.bsb.rest.po.Users;
import vo.InterfaceRespVo;

import java.util.Date;

/**
 * @program: rxt-bsb
 * @description:
 * @author: Mr.Wang
 * @create: 2019-10-10 17:05
 **/
@Service
public class DemoService {
    public RxtBsbOperatorServer rxtBsbOperatorServer;

    @Autowired
    private UsersDao usersDao;

    public String subAcctNoPersonal = "9956760999679500000003";//个人资金账号
    public String subAcctNoEnterprise = "9956760999679500000007";//企业资金账号
    public String acctNo = "";//银行卡号
    public String test( ) {
        System.out.println("11111111111111111111111");
        OpenPersonalAcctReqDto openPersonalAcct = new OpenPersonalAcctReqDto();
        openPersonalAcct.setCertType("01");
        openPersonalAcct.setEmail("876733048@qq.com");
        openPersonalAcct.setCustName("全渠道");
        openPersonalAcct.setMobileNo("13552535506");
        openPersonalAcct.setCertNo("341126197709218366");
        openPersonalAcct.setCustNo("01240114");
        openPersonalAcct.setRepayAcctFlag("");
        InterfaceRespVo<OpenPersonalAcctReqDto> response =
                rxtBsbOperatorServer.openPersonalAcct(openPersonalAcct);
        return response.toString();
    }

    public int addUsers(){
        Users users = new Users();
        users.setUserName("cs001");
        users.setPwd("123456");
        users.setUserType(1);
        users.setCreateTime(new Date());
        int aa = usersDao.insert(users);
        return aa;
    }

    public Users queryUser (){
        Users users = usersDao.selectByPrimaryKey(2);
        return users;
    }

    public int deleteUsers (){
        int aa = usersDao.deleteByPrimaryKey(1);
        return aa;
    }

    public int updateUsers (){
        Users users = new Users();
        users.setId(1);
        users.setUserName("xiugai");
        users.setPwd("234");
        int aa = usersDao.updateByPrimaryKey(users);
        return aa;
    }
}

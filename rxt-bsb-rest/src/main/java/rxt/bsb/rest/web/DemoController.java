package rxt.bsb.rest.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rxt.bsb.rest.po.Users;
import rxt.bsb.rest.service.DemoService;

@RestController
@RequestMapping("demo")
public class DemoController {
    @Autowired
    public DemoService demoService;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @RequestMapping("test")
    String test( ) {
        return demoService.test();
    }

    @RequestMapping("add")
    int addUsers(){
        return  demoService.addUsers();
    }

    @RequestMapping("delete")
    int deleteUsers(){
        return  demoService.deleteUsers();
    }

    @RequestMapping("select")
    Users selectUsers(){
        return  demoService.queryUser();
    }

    @RequestMapping("update")
    int updateUsers(){
        return  demoService.updateUsers();
    }
}

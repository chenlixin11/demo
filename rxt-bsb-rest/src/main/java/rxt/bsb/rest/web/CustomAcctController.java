package rxt.bsb.rest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rxt.bsb.rest.service.CustomAcctService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/customAcct")
public class CustomAcctController {

    @Autowired
    private CustomAcctService customAcctService;


    @RequestMapping(" value = showCustAcctInfo")
    public Object showCustAcctInfo(HttpServletRequest request){

        return null;
    }


    /**
     *  开户申请
     * @param request
     * @return
     */
    @RequestMapping(" value = custOpenAcctApply")
    public Object custOpenAcctApply(HttpServletRequest request){
        return null;
    }

}

package rxt.bsb.rest.vo.showVO;

import rxt.bsb.rest.po.Permiss;
import rxt.bsb.rest.vo.UserVO;

import java.util.List;

/**
 * @program: rxt-bsb
 * @description:
 * @author: Mr.Wang
 * @create: 2019-11-13 18:17
 **/
public class ShowUserAndMenuVO {
    private UserVO userVO;
    private List<Permiss> menu;

    public UserVO getUserVO() {
        return userVO;
    }

    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }

    public List<Permiss> getMenu() {
        return menu;
    }

    public void setMenu(List<Permiss> menu) {
        this.menu = menu;
    }
}

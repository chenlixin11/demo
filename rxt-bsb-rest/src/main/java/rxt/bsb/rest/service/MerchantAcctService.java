package rxt.bsb.rest.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rxt.bsb.rest.dao.MerchantAcctDao;
import rxt.bsb.rest.dao.MerchantInfoDao;
import rxt.bsb.rest.po.MerchantAcct;

import java.util.Date;


@Service
public class MerchantAcctService {

    @Autowired
    private MerchantAcctDao merchantAcctDao;
    @Autowired
    private MerchantInfoDao merchantInfoDao;

    public MerchantAcct find(Integer id) {
        MerchantAcct merchantAcct = merchantAcctDao.selectByPrimaryKey(id);
        return merchantAcct;
    }

    //分页
    public Page<MerchantAcct> findByPage(MerchantAcct merchant,Integer pageNum, Integer pageSize) {
        PageHelper.startPage( pageNum, pageSize );
        Page<MerchantAcct> page  = merchantAcctDao.findByPage( merchant);
        return page;
    }

    //添加
    public Integer save(MerchantAcct merchantAcct) {
        merchantAcct.setCreateTime(new Date());
        return merchantAcctDao.insertSelective(merchantAcct);
    }

    //修改
    public Integer update(MerchantAcct merchantAcct) {
        return merchantAcctDao.updateByPrimaryKeySelective(merchantAcct);
    }

    //删除
    public Integer delete(Integer id) {
        return merchantAcctDao.deleteByPrimaryKey(id);
    }
}

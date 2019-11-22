package rxt.bsb.rest.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rxt.bsb.rest.common.ApiResult;
import rxt.bsb.rest.dao.PermissDao;
import rxt.bsb.rest.po.Permiss;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @program: rxt-bsb
 * @description:
 * @author: Mr.zgq
 * @create: 2019-11-04 14:55
 **/
@Service
public class PermissService {

    @Autowired
    private PermissDao permissDao;

    public List<Permiss> queryPermissList(){
       return permissDao.queryPermissList();
    }

    /**
     * 保存菜单设置
     * @param jsonData
     * @return
     */
    public Object save(String jsonData) {
        List<Permiss>  permissForm =   JSON.parseArray(jsonData, Permiss.class);
        List<Permiss> permissCache =   permissDao.queryPermissList();

        // 删除的集合
        List<Integer> permissForDel = new CopyOnWriteArrayList<>();

        // 修改的集合
        List<Permiss> permissForUpdate = new CopyOnWriteArrayList<>();

        // 添加的集合
        List<Permiss> permissForInsert = new CopyOnWriteArrayList<>();


        for(Permiss pd: permissCache) {

            // 将数据库已有的添加进来
            permissForDel.add(pd.getId());

            for(Permiss pf: permissForm) {

                // id 相等   有一个属性不等  视为对象被修改
                if( pf.getId() != null &&   pf.getId().equals(  pd.getId() ) && !pf.equals( pd) )
                    permissForUpdate.add(pf);

                // 和form提交的数据做对比、如果有则这条数据不做删除操作
                if(  permissForDel.contains(pf.getId()) )
                    permissForDel.remove(pf.getId());

                // 新建菜单判断
                if("1".equals(pf.getIsNew()) &&  !permissForInsert.contains(pf))
                    permissForInsert.add(pf);

            }
        }

        if( permissForInsert.size() > 0 )
            permissDao.insertBatch(permissForInsert);
        if(  permissForUpdate.size() > 0 )
            permissDao.updateBatch(permissForUpdate );
        if( permissForDel.size() > 0 )
            permissDao.deleteBatch(permissForDel.toArray(new Integer[permissForDel.size()]));

        return ApiResult.successOf( String.format("修改了%s条数据，删除%s条数据，新增了%s条数据", permissForUpdate.size() , permissForDel.size() , permissForInsert.size()));
    }

}

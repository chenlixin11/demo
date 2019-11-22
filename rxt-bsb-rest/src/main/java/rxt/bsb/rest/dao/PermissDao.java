package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.Permiss;

import java.util.List;

@Mapper
public interface PermissDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Permiss record);

    int insertSelective(Permiss record);

    Permiss selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Permiss record);

    int updateByPrimaryKey(Permiss record);

    List<Permiss> queryPermissByIds(List ids);

    List<Permiss> queryPermissList();

    int insertBatch(List<Permiss> permisses);

    int updateBatch(List<Permiss> permisses);

    int deleteBatch(Integer []  arr);
}
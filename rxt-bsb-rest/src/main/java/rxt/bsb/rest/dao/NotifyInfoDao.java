package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.NotifyInfo;
import rxt.bsb.rest.po.NotifyInfoWithBLOBs;
@Mapper
public interface NotifyInfoDao {
    int deleteByPrimaryKey(Integer id);

    int insert(NotifyInfoWithBLOBs record);

    int insertSelective(NotifyInfoWithBLOBs record);

    NotifyInfoWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NotifyInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(NotifyInfoWithBLOBs record);

    int updateByPrimaryKey(NotifyInfo record);
}
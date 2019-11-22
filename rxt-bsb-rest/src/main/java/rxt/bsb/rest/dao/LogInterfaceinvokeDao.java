package rxt.bsb.rest.dao;

import org.apache.ibatis.annotations.Mapper;
import rxt.bsb.rest.po.LogInterfaceinvoke;
import rxt.bsb.rest.po.LogInterfaceinvokeWithBLOBs;
@Mapper
public interface LogInterfaceinvokeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(LogInterfaceinvokeWithBLOBs record);

    int insertSelective(LogInterfaceinvokeWithBLOBs record);

    LogInterfaceinvokeWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogInterfaceinvokeWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(LogInterfaceinvokeWithBLOBs record);

    int updateByPrimaryKey(LogInterfaceinvoke record);
}
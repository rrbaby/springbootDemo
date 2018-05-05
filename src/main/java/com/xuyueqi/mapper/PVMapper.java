package com.xuyueqi.mapper;

import com.xuyueqi.model.PV;

public interface PVMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PV record);

    int insertSelective(PV record);

    PV selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PV record);

    int updateByPrimaryKey(PV record);
}
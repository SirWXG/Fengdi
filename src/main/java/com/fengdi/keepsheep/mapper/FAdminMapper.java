package com.fengdi.keepsheep.mapper;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.bean.FAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FAdminMapper {
    int countByExample(FAdminExample example);

    int deleteByExample(FAdminExample example);

    int deleteByPrimaryKey(String adminNo);

    int insert(FAdmin record);

    int insertSelective(FAdmin record);

    List<FAdmin> selectByExample(FAdminExample example);

    FAdmin selectByPrimaryKey(String adminNo);

    int updateByExampleSelective(@Param("record") FAdmin record, @Param("example") FAdminExample example);

    int updateByExample(@Param("record") FAdmin record, @Param("example") FAdminExample example);

    int updateByPrimaryKeySelective(FAdmin record);

    int updateByPrimaryKey(FAdmin record);
}
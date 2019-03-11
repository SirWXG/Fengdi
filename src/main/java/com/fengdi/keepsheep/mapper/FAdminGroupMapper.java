package com.fengdi.keepsheep.mapper;

import com.fengdi.keepsheep.bean.FAdminGroup;
import com.fengdi.keepsheep.bean.FAdminGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FAdminGroupMapper {
    int countByExample(FAdminGroupExample example);

    int deleteByExample(FAdminGroupExample example);

    int deleteByPrimaryKey(String adminGroupNo);

    int insert(FAdminGroup record);

    int insertSelective(FAdminGroup record);

    List<FAdminGroup> selectByExampleWithBLOBs(FAdminGroupExample example);

    List<FAdminGroup> selectByExample(FAdminGroupExample example);

    FAdminGroup selectByPrimaryKey(String adminGroupNo);

    int updateByExampleSelective(@Param("record") FAdminGroup record, @Param("example") FAdminGroupExample example);

    int updateByExampleWithBLOBs(@Param("record") FAdminGroup record, @Param("example") FAdminGroupExample example);

    int updateByExample(@Param("record") FAdminGroup record, @Param("example") FAdminGroupExample example);

    int updateByPrimaryKeySelective(FAdminGroup record);

    int updateByPrimaryKeyWithBLOBs(FAdminGroup record);

    int updateByPrimaryKey(FAdminGroup record);
}
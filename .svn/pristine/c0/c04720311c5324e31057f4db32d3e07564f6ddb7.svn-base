package com.fengdi.keepsheep.mapper;

import com.fengdi.keepsheep.bean.FService;
import com.fengdi.keepsheep.bean.FServiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FServiceMapper {
    int countByExample(FServiceExample example);

    int deleteByExample(FServiceExample example);

    int deleteByPrimaryKey(Integer serviceNo);

    int insert(FService record);

    int insertSelective(FService record);

    List<FService> selectByExampleWithBLOBs(FServiceExample example);

    List<FService> selectByExample(FServiceExample example);

    FService selectByPrimaryKey(Integer serviceNo);

    int updateByExampleSelective(@Param("record") FService record, @Param("example") FServiceExample example);

    int updateByExampleWithBLOBs(@Param("record") FService record, @Param("example") FServiceExample example);

    int updateByExample(@Param("record") FService record, @Param("example") FServiceExample example);

    int updateByPrimaryKeySelective(FService record);

    int updateByPrimaryKeyWithBLOBs(FService record);

    int updateByPrimaryKey(FService record);
}
package com.fengdi.keepsheep.mapper;

import com.fengdi.keepsheep.bean.FProduct;
import com.fengdi.keepsheep.bean.FProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FProductMapper {
    int countByExample(FProductExample example);

    int deleteByExample(FProductExample example);

    int deleteByPrimaryKey(Integer productNo);

    int insert(FProduct record);

    int insertSelective(FProduct record);

    List<FProduct> selectByExampleWithBLOBs(FProductExample example);

    List<FProduct> selectByExample(FProductExample example);

    FProduct selectByPrimaryKey(Integer productNo);

    int updateByExampleSelective(@Param("record") FProduct record, @Param("example") FProductExample example);

    int updateByExampleWithBLOBs(@Param("record") FProduct record, @Param("example") FProductExample example);

    int updateByExample(@Param("record") FProduct record, @Param("example") FProductExample example);

    int updateByPrimaryKeySelective(FProduct record);

    int updateByPrimaryKeyWithBLOBs(FProduct record);

    int updateByPrimaryKey(FProduct record);
}
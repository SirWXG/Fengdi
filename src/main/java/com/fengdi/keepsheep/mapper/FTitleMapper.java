package com.fengdi.keepsheep.mapper;

import com.fengdi.keepsheep.bean.FTitle;
import com.fengdi.keepsheep.bean.FTitleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FTitleMapper {
    int countByExample(FTitleExample example);

    int deleteByExample(FTitleExample example);

    int deleteByPrimaryKey(String titleNo);

    int insert(FTitle record);

    int insertSelective(FTitle record);

    List<FTitle> selectByExample(FTitleExample example);

    FTitle selectByPrimaryKey(String titleNo);

    int updateByExampleSelective(@Param("record") FTitle record, @Param("example") FTitleExample example);

    int updateByExample(@Param("record") FTitle record, @Param("example") FTitleExample example);

    int updateByPrimaryKeySelective(FTitle record);

    int updateByPrimaryKey(FTitle record);
}
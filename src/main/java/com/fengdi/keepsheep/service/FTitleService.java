package com.fengdi.keepsheep.service;

import com.fengdi.keepsheep.bean.FTitle;
import com.fengdi.keepsheep.bean.FTitleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @create 2019-03-22 上午 11:38
 **/
public interface FTitleService {
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

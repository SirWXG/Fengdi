package com.fengdi.keepsheep.mapper;

import com.fengdi.keepsheep.bean.FProblem;
import com.fengdi.keepsheep.bean.FProblemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FProblemMapper {
    int countByExample(FProblemExample example);

    int deleteByExample(FProblemExample example);

    int deleteByPrimaryKey(String problemNo);

    int insert(FProblem record);

    int insertSelective(FProblem record);

    List<FProblem> selectByExample(FProblemExample example);

    FProblem selectByPrimaryKey(String problemNo);

    int updateByExampleSelective(@Param("record") FProblem record, @Param("example") FProblemExample example);

    int updateByExample(@Param("record") FProblem record, @Param("example") FProblemExample example);

    int updateByPrimaryKeySelective(FProblem record);

    int updateByPrimaryKey(FProblem record);
}
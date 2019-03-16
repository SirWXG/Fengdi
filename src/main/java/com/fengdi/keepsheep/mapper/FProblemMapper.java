package com.fengdi.keepsheep.mapper;

import com.fengdi.keepsheep.bean.FProblem;
import com.fengdi.keepsheep.bean.FProblemExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface FProblemMapper {
    int countByExample(FProblemExample example);

    boolean deleteById(@Param("id") Integer id);

    int deleteByPrimaryKey(String problemNo);

    int insert(FProblem record);

    int insertSelective(FProblem record);

    List<FProblem> selectByExample(FProblemExample example);

    FProblem selectById(@Param("id") Integer id);

    FProblem selectByPrimaryKey(String problemNo);

    int updateByExampleSelective(@Param("record") FProblem record, @Param("example") FProblemExample example);

    int updateByExample(@Param("record") FProblem record, @Param("example") FProblemExample example);

    int updateByPrimaryKeySelective(FProblem record);

    int updateByPrimaryKey(FProblem record);

    boolean updateByStatus(@Param("id")Integer id,@Param("status")String status);

    boolean updateById(FProblem fProblem);

    List<FProblem> selectNoAndCname(Map<String,Object> map);

    int selectCount();
}
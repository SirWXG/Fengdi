package com.fengdi.keepsheep.mapper;

import com.fengdi.keepsheep.bean.FAuthorize;
import com.fengdi.keepsheep.bean.FAuthorizeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FAuthorizeMapper {
    int countByExample(FAuthorizeExample example);

    int deleteByExample(FAuthorizeExample example);

    int deleteByPrimaryKey(Long authorizeNo);

    int insert(FAuthorize record);

    int insertSelective(FAuthorize record);

    List<FAuthorize> selectByExample(FAuthorizeExample example);

    FAuthorize selectByPrimaryKey(Long authorizeNo);

    int updateByExampleSelective(@Param("record") FAuthorize record, @Param("example") FAuthorizeExample example);

    int updateByExample(@Param("record") FAuthorize record, @Param("example") FAuthorizeExample example);

    int updateByPrimaryKeySelective(FAuthorize record);

    int updateByPrimaryKey(FAuthorize record);

    List<FAuthorize> selectAuthByFirst(String array[]);

    List<FAuthorize> selectList(String array[]);

    List<FAuthorize> selectListAuth(String array[]);

    List<FAuthorize> selectFirst();

    List<FAuthorize> selectAuthBySecond(@Param("superAuthorizeNo")String superAuthorizeNo);

    List<FAuthorize> selectListAuthBySuper(String array[]);
}
package com.fengdi.keepsheep.mapper;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.bean.FAdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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

    List<FAdmin> checkLogin(Map<String,String>map);

    int updateAdminForLoginTime(Map<String,Object>map);

    List<FAdmin> selectAdminByStatus(Map<String,Object>map);

    int deleteAdminByAdminNo(String adminNo);

    int updateAdminStatus(Map<String,String>map);

    List<FAdmin> selectAdminByAdminNo(String adminNo);

    List<FAdmin> selectAdminByLoginName(@Param("loginName")String loginName);
}
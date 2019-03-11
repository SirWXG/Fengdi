package com.fengdi.keepsheep.mapper;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.bean.FAdminExample;
import java.util.List;
import java.util.Map;

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
    
    /**
     * 验证登录
     * @param map
     * @return
     */
    List<FAdmin> checkLogin(Map<String, String>map);

    /**
     * 更新登录时间
     * @param map
     * @return
     */
    int updateAdminForLoginTime(Map<String,Object>map);

    /**
     * 条件查询
     * @param fAdmin
     * @return
     */
    List<FAdmin> selectAdminByStatus(FAdmin fAdmin);
}
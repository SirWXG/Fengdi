package com.fengdi.keepsheep.mapper;

import com.fengdi.keepsheep.bean.FProduct;
import com.fengdi.keepsheep.bean.FProductExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FProductMapper {
    int countByExample(FProductExample example);

    int deleteByExample(FProductExample example);

    int deleteByPrimaryKey(String productNo);

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

    List<FProduct> selectAllProduct(@Param("productName") String productName);

    int updateProductStatus(Map<String,Object> map);

    int checkProductImg();

    List<FProduct> selectProductByPno(@Param("productNo") String productNo);

    int updateProduct(Map<String,Object>map);

    int updateProducts(Map<String,Object>map);

    List<FProduct> selectProductForBefore();

}
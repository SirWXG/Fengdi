package com.fengdi.keepsheep.service;

import com.fengdi.keepsheep.bean.FProduct;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/3/16.
 */
public interface FProductService {

    List<FProduct> selectAllProduct(String productName);

    int deleteByPrimaryKey(String productNo);

    int updateProductStatus(Map<String,Object> map);

    int checkProductImg();

    int insert(FProduct record);

    List<FProduct> selectProductByPno(String productNo);

    int updateProduct(Map<String,Object>map);

    int updateProducts(Map<String,Object>map);

    List<FProduct> selectProductForBefore();
}

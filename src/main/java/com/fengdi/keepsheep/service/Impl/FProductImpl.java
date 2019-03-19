package com.fengdi.keepsheep.service.Impl;

import com.fengdi.keepsheep.bean.FAdmin;
import com.fengdi.keepsheep.bean.FProduct;
import com.fengdi.keepsheep.mapper.FProductMapper;
import com.fengdi.keepsheep.service.FProductService;
import com.fengdi.keepsheep.util.Random2Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/3/16.
 */

@Service
public class FProductImpl implements FProductService {

    @Autowired
    private FProductMapper fProductMapper;

    @Override
    public List<FProduct> selectAllProduct(String productName) {
        return fProductMapper.selectAllProduct(productName);
    }

    @Override
    public int deleteByPrimaryKey(String productNo) {
        return fProductMapper.deleteByPrimaryKey(productNo);
    }

    @Override
    public int updateProductStatus(Map<String, Object> map) {
        return fProductMapper.updateProductStatus(map);
    }

    @Override
    public int checkProductImg() {
        return fProductMapper.checkProductImg();
    }

    @Override
    public int insert(FProduct product) {
        product.setProductNo(Random2Utils.buildSn("PR"));
        product.setCreateTime(new Date());
        HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        FAdmin pro =(FAdmin)session.getAttribute("admin");
        product.setGroupCnname(pro.getAdminName());
        product.setAdminGroupNo(pro.getAdminNo());
        return fProductMapper.insert(product);
    }

    @Override
    public List<FProduct> selectProductByPno(String productNo) {
        return fProductMapper.selectProductByPno(productNo);
    }

    @Override
    public int updateProduct(Map<String, Object> map) {
        return fProductMapper.updateProduct(map);
    }

    @Override
    public int updateProducts(Map<String, Object> map) {
        return fProductMapper.updateProducts(map);
    }

    @Override
    public List<FProduct> selectProductForBefore() {
        return fProductMapper.selectProductForBefore();
    }
}

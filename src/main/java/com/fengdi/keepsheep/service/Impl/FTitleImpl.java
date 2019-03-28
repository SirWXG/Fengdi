package com.fengdi.keepsheep.service.Impl;

import com.fengdi.keepsheep.bean.FTitle;
import com.fengdi.keepsheep.bean.FTitleExample;
import com.fengdi.keepsheep.mapper.FTitleMapper;
import com.fengdi.keepsheep.service.FTitleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 张文强
 * @company 开发者联盟
 * @description 描述
 * @create 2019-03-22 上午 11:39
 **/

@Service
public class FTitleImpl implements FTitleService {
    @Resource
    private FTitleMapper fTitleMapper;

    @Override
    public int countByExample(FTitleExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(FTitleExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(String titleNo) {
        return 0;
    }

    @Override
    public int insert(FTitle record) {
        return 0;
    }

    @Override
    public int insertSelective(FTitle record) {
        return 0;
    }

    @Override
    public List<FTitle> selectByExample(FTitleExample example) {
        return fTitleMapper.selectByExample(new FTitleExample());
    }

    @Override
    public FTitle selectByPrimaryKey(String titleNo) {
        return fTitleMapper.selectByPrimaryKey(titleNo);
    }

    @Override
    public int updateByExampleSelective(FTitle record, FTitleExample example) {
        return 0;
    }

    @Override
    public int updateByExample(FTitle record, FTitleExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(FTitle record) {
        return fTitleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(FTitle record) {
        return 0;
    }

    @Override
    public int updatestauts(String titleNo, String status) {
        return fTitleMapper.updatestauts(titleNo,status);
    }
}

package com.czxy.merchant.service.impl;

import com.czxy.merchant.service.MDemoService;
import com.czxy.tobto.dao.MDemoMapper;
import com.czxy.tobto.dao.TMerchantMapper;
import com.czxy.tobto.domain.MDemo;
import com.czxy.tobto.domain.TMerchant;
import com.czxy.utils.DataGridResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MDemoServiceImpl implements MDemoService {

    @Autowired
    private MDemoMapper mDemoMapper;

    @Autowired
    private TMerchantMapper tMerchantMapper;

    @Override
    public DataGridResult findPage(Integer page,Integer rows){

        PageHelper.startPage(page,rows);
        List<MDemo> mDemos = mDemoMapper.selectAll();
        for (MDemo mDemo: mDemos) {
            TMerchant tMerchant = tMerchantMapper.selectByPrimaryKey(mDemo.getdId());
        //    List<TMerchant> tMerchants = tMerchantMapper.selectAll();
            mDemo.settMerchant(tMerchant);
        }
        PageInfo<MDemo> mDemoPageInfo = new PageInfo<>(mDemos);
        return new DataGridResult(mDemoPageInfo.getTotal(),mDemoPageInfo.getList());
    }

    @Override
    public void up(String str) {
        String[] ids = str.split(",");
        for (String id: ids) {
            if (id!=null){
                MDemo mDemo = mDemoMapper.selectByPrimaryKey(Integer.parseInt(id));
                mDemo.setdState(null);
                mDemoMapper.updateByPrimaryKey(mDemo);
            }
        }
    }

    @Override
    public void load(String str) {
        String[] ids = str.split(",");
        for (String id: ids) {
            if (id!=null){
                MDemo mDemo = mDemoMapper.selectByPrimaryKey(Integer.parseInt(id));
                mDemo.setdState(0);
                mDemoMapper.updateByPrimaryKey(mDemo);
            }
        }
    }


}

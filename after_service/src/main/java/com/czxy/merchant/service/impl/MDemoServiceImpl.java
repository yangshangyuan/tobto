package com.czxy.merchant.service.impl;

import com.czxy.merchant.service.MDemoService;
import com.czxy.tobto.dao.MDemoMapper;
import com.czxy.tobto.dao.TMerchantMapper;
import com.czxy.tobto.dao.repository.ESMDemoRepository;
import com.czxy.tobto.domain.ES.ESMDemo;
import com.czxy.tobto.domain.MDemo;
import com.czxy.tobto.domain.TMerchant;
import com.czxy.utils.DataGridResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
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

    @Autowired
    private ESMDemoRepository esmDemoRepository;
    /*
    利用es进行分页
     */
    @Override
    public DataGridResult findPage(Integer page,Integer rows){

       /* PageHelper.startPage(page,rows);
        List<MDemo> mDemos = mDemoMapper.selectAll();
        for (MDemo mDemo: mDemos) {
            TMerchant tMerchant = tMerchantMapper.selectByPrimaryKey(mDemo.getdId());
        //    List<TMerchant> tMerchants = tMerchantMapper.selectAll();
            mDemo.settMerchant(tMerchant);
        }
        PageInfo<MDemo> mDemoPageInfo = new PageInfo<>(mDemos);*/

       //用于添加数据
//        esmDemoRepository.deleteAll();
//        List<MDemo> mDemos = mDemoMapper.selectAll();
//        for (MDemo mDemo: mDemos) {
//            ESMDemo esmDemo = new ESMDemo();
//            BeanUtils.copyProperties(mDemo,esmDemo);
//            esmDemoRepository.save(esmDemo);
//        }
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        builder.withPageable(PageRequest.of(page - 1, rows));
        Page<ESMDemo> search = this.esmDemoRepository.search(builder.build());
        for (ESMDemo esmDemo: search) {
            esmDemo.settMerchant(tMerchantMapper.sele(esmDemo.getdId()));
        }
        return new DataGridResult(search.getTotalElements(),search.getContent());
    }

    @Override
    public void up(String str) {
        String[] ids = str.split(",");
        for (String id: ids) {
            if (id!=null){
                ESMDemo esmDemo = new ESMDemo();
                MDemo mDemo = mDemoMapper.selectByPrimaryKey(Integer.parseInt(id));
                mDemo.setdState(null);
                BeanUtils.copyProperties(mDemo,esmDemo);
                esmDemoRepository.save(esmDemo);
                mDemoMapper.updateByPrimaryKey(mDemo);
            }
        }
    }

    @Override
    public void load(String str) {
        String[] ids = str.split(",");
        for (String id: ids) {
            if (id!=null){
                ESMDemo esmDemo = new ESMDemo();
                MDemo mDemo = mDemoMapper.selectByPrimaryKey(Integer.parseInt(id));
                mDemo.setdState(0);
                BeanUtils.copyProperties(mDemo,esmDemo);
                esmDemoRepository.save(esmDemo);
                mDemoMapper.updateByPrimaryKey(mDemo);
            }
        }
    }

    @Override
    public void updataAll(MDemo mDemo) {

      if (mDemo.getdRecommend()==1){
          mDemo.setdRecommend(null);
      }
      if (mDemo.getdState()==1){
          mDemo.setdState(null);
      }

        ESMDemo esmDemo = new ESMDemo();
        BeanUtils.copyProperties(mDemo,esmDemo);
        esmDemoRepository.save(esmDemo);
        mDemoMapper.updateByPrimaryKey(mDemo);
    }

    @Override
    public void add(MDemo mDemo1) {
        mDemo1.setdRecommend(null);
        mDemo1.setdState(null);
        mDemoMapper.insert(mDemo1);
        esmDemoRepository.deleteAll();
        List<MDemo> mDemos = mDemoMapper.selectAll();
       for (MDemo mDemo: mDemos) {
           ESMDemo esmDemo = new ESMDemo();
            BeanUtils.copyProperties(mDemo,esmDemo);
            esmDemoRepository.save(esmDemo);
        }
    }


}

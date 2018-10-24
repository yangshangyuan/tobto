package com.czxy.terrace.service.impl;

import com.czxy.terrace.service.LinkService;
import com.czxy.tobto.dao.TFindsMapper;
import com.czxy.tobto.dao.repository.TFindsRepository;
import com.czxy.tobto.domain.ES.ESTFinds;
import com.czxy.tobto.domain.TFinds;
import com.czxy.utils.vo.DataGridResultInfo;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

import java.util.List;

@Service
public class LinkServiceImpl implements LinkService {


    @Resource
    private TFindsMapper tFindsMapper;

    @Autowired
    private TFindsRepository tFindsRepository;

    @Override
    public DataGridResultInfo findAllTFinds(String fName,Integer page,Integer rows) {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        if(fName == null || fName.equals("") || fName.equals("null")){

        }else{
            WildcardQueryBuilder nFname = QueryBuilders.wildcardQuery("fName", "*" + fName + "*");
            boolQuery.should(nFname);
        }
        builder.withPageable(PageRequest.of(page-1,rows));
        builder.withQuery(boolQuery);
        Page<ESTFinds> search = tFindsRepository.search(builder.build());
        DataGridResultInfo resultInfo = new DataGridResultInfo();
        resultInfo.setTotal(search.getTotalElements());
        resultInfo.setRows(search.getContent());
        return resultInfo;
    }


    @Override
    public int addLink(TFinds tFinds) {
        int insert = tFindsMapper.insert(tFinds);
        syncLink(tFinds);
        return insert;
    }

    @Override
    public void update(TFinds tFinds) {

        TFinds tFinds1 = tFindsMapper.selectOne(tFinds);
        Integer integer = tFinds1.getfShow();
        if (integer!=null){
            System.out.println(1);
            TFinds tf = new TFinds();
            BeanUtils.copyProperties(tFinds1,tf);
            tf.setfShow(null);
            tFindsMapper.updateByPrimaryKey(tf);
            ESTFinds estFinds = new ESTFinds();
            BeanUtils.copyProperties(tf,estFinds);
            tFindsRepository.save(estFinds);


        }else {
            System.out.println(2);
            TFinds tf = new TFinds();
            BeanUtils.copyProperties(tFinds1,tf);
            tf.setfShow(1);
            tFindsMapper.updateByPrimaryKey(tf);
            ESTFinds estFinds = new ESTFinds();
            BeanUtils.copyProperties(tf,estFinds);
            tFindsRepository.save(estFinds);

        }

    }

    @Override
    public void deleted(int i) {
        System.out.println(i);
        tFindsMapper.deleteByPrimaryKey(i);
        tFindsRepository.deleteById(i);
    }



    @Override
    public void syncLink(TFinds tFinds) {
        TFinds tFinds1 = tFindsMapper.selectOne(tFinds);
        ESTFinds estFinds = new ESTFinds();
        BeanUtils.copyProperties(tFinds1,estFinds);
        tFindsRepository.save(estFinds);
    }




}

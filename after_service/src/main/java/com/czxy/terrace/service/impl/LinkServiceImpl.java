package com.czxy.terrace.service.impl;

import com.czxy.terrace.service.LinkService;
import com.czxy.tobto.dao.TFindsMapper;
import com.czxy.tobto.dao.repository.TFindsRepository;
import com.czxy.tobto.domain.ES.ESTFinds;
import com.czxy.tobto.domain.TFinds;
import com.czxy.utils.vo.DataGridResultInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

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
      /*  PageHelper.startPage(page,rows);
        List<TFinds> tFinds = tFindsMapper.selectAll();
        PageInfo<TFinds> info = new PageInfo(tFinds);*/
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
        TFinds tFinds1 = tFindsMapper.selectByPrimaryKey(tFinds.getfId());
        if (tFinds1.getfShow()==null){
            TFinds tf = new TFinds();
            BeanUtils.copyProperties(tFinds1,tf);
            tf.setfShow(1);
            tFindsMapper.updateByPrimaryKey(tf);
            syncLink(tf);
        }else {
            TFinds tf = new TFinds();
            BeanUtils.copyProperties(tFinds1,tf);
            tf.setfShow(null);
            tFindsMapper.updateByPrimaryKey(tf);
            syncLink(tf);
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

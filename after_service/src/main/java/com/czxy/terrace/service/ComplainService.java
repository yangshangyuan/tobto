package com.czxy.terrace.service;

import com.czxy.tobto.dao.Es.ComplainRepository;
import com.czxy.tobto.dao.TComplainMapper;
import com.czxy.tobto.domain.ES.EsTComplain;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class ComplainService {
    @Resource
    private TComplainMapper complainMapper;
    @Resource
    private ComplainRepository complainRepository;


    public Page<EsTComplain> findComByPage(Integer complainState, Integer page, Integer rows) {
        //1.条件封装对象
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (!"null".equals(complainState)&& StringUtils.isNotBlank(complainState+"")) {
            boolQueryBuilder.must(QueryBuilders.wildcardQuery("complainState","*"+complainState+"*"));
        }
        //2.搜索封装对象
        NativeSearchQuery searchQuery = new NativeSearchQuery(boolQueryBuilder);
        searchQuery.setPageable(PageRequest.of(page-1,rows));
        return complainRepository.search(searchQuery);
    }
}

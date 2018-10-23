package com.czxy.tobto.dao.repository;

import com.czxy.tobto.domain.ES.ESMDemo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ESMDemoRepository extends ElasticsearchRepository<ESMDemo,Integer> {
}

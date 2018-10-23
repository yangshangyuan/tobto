package com.czxy.tobto.dao.repository;

import com.czxy.tobto.domain.ES.ESTFinds;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TFindsRepository extends ElasticsearchRepository<ESTFinds,Integer> {
}

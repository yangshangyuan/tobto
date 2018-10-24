package com.czxy.tobto.dao.Es;

import com.czxy.tobto.domain.ES.EsTComplain;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ComplainRepository extends ElasticsearchRepository<EsTComplain ,Integer> {
}

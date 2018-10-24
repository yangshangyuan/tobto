package com.czxy.tobto.dao.Es;

import com.czxy.tobto.domain.ES.EsTAdvertising;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AdvertisingRepository extends ElasticsearchRepository<EsTAdvertising,Integer> {
}

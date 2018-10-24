package com.czxy.terrace.service;

import com.czxy.tobto.dao.Es.AdvertisingRepository;
import com.czxy.tobto.dao.TAdvertisingMapper;
import com.czxy.tobto.domain.ES.EsTAdvertising;
import com.czxy.tobto.domain.TAdvertising;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class AdvertisementService {


    @Autowired
    private AdvertisingRepository advertisingRepository;

    @Resource
    private TAdvertisingMapper tAdvertisingMapper;

    public Page<EsTAdvertising> findAdvByPage(String getaText, Integer page, Integer rows) {
        //1.条件封装对象
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (!"null".equals(getaText)&&StringUtils.isNotBlank(getaText)) {
            boolQueryBuilder.must(QueryBuilders.wildcardQuery("aText","*"+getaText+"*"));
        }
        //2.搜索封装对象
        NativeSearchQuery searchQuery = new NativeSearchQuery(boolQueryBuilder);
        searchQuery.setPageable(PageRequest.of(page-1,rows));
        return advertisingRepository.search(searchQuery);

    }

    public Integer addAdv(TAdvertising advertising) {
        int insert = tAdvertisingMapper.insert(advertising);
        timeInsert();
        return insert;
    }

    public Integer deleteAdv(String ids) {
        String[] split = ids.split(",");
        int i =  0 ;
        for (String id : split) {
            TAdvertising tAdvertising = tAdvertisingMapper.selectByPrimaryKey(id);
            tAdvertisingMapper.deleteByPrimaryKey(tAdvertising);
            EsTAdvertising esTAdvertising = new EsTAdvertising();
            BeanUtils.copyProperties(tAdvertising,esTAdvertising);
            advertisingRepository.delete(esTAdvertising);
            i++;
        }
        timeInsert();
        return i;

    }
    /**
     * 修改
     * @param advertising
     * @return
     */
    public Integer updateAdvById(TAdvertising advertising) {
        TAdvertising tAdvertising = tAdvertisingMapper.selectByPrimaryKey(advertising.getaId());
        System.out.println(tAdvertising.getaText());
        if (tAdvertising!=null) {
            int i = this.tAdvertisingMapper.updateByPrimaryKey(advertising);
            timeInsert();
            return  i;
        }
        return  null;
    }
    /**
     * 更新es索引库
     */
    public void  timeInsert(){
        List<TAdvertising> tAdvertisingList = tAdvertisingMapper.selectAll();
        ArrayList<EsTAdvertising> list = new ArrayList<>();

        for (TAdvertising tAdvertising : tAdvertisingList) {
            EsTAdvertising esTAdvertising = new EsTAdvertising();
            BeanUtils.copyProperties(tAdvertising,esTAdvertising);
            list.add(esTAdvertising);

        }
        advertisingRepository.saveAll(list);
    }
}

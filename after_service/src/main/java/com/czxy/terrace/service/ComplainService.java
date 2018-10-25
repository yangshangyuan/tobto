package com.czxy.terrace.service;

import com.czxy.tobto.dao.Es.ComplainRepository;
import com.czxy.tobto.dao.TComplainMapper;
import com.czxy.tobto.dao.UserMapper;
import com.czxy.tobto.domain.ES.EsTComplain;
import com.czxy.tobto.domain.TComplain;
import com.czxy.tobto.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.BeanUtils;
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
public class ComplainService {
    @Resource
    private TComplainMapper complainMapper;
    @Resource
    private ComplainRepository complainRepository;
@Resource
private UserMapper userMapper;

    public Page<EsTComplain> findComByPage(String complainText, Integer page, Integer rows) {
        //1.条件封装对象
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (!"null".equals(complainText) && StringUtils.isNotBlank(complainText)) {
            boolQueryBuilder.must(QueryBuilders.wildcardQuery("complainText", "*" + complainText + "*"));
        }
        //2.搜索封装对象
        NativeSearchQuery searchQuery = new NativeSearchQuery(boolQueryBuilder);

        searchQuery.setPageable(PageRequest.of(page - 1, rows));
        return complainRepository.search(searchQuery);
    }

    public Integer addAdv(TComplain complain) {
        complain.setComplainState(0);

        int insert = complainMapper.insert(complain);

        timeInsert();
        return insert;

    }

    public Integer deleteCom(String ids) {
        String[] split = ids.split(",");
        int i = 0;
        for (String id : split) {
            TComplain tComplain = complainMapper.selectByPrimaryKey(id);
            complainMapper.deleteByPrimaryKey(tComplain);
            EsTComplain esTComplain = new EsTComplain();
            BeanUtils.copyProperties(tComplain, esTComplain);
            complainRepository.delete(esTComplain);
            i++;
        }
        timeInsert();
        return i;
    }

    public Integer updateCom(TComplain complain) {
        TComplain tComplain = complainMapper.selectByPrimaryKey(complain.getComplainId());
        if (tComplain.getComplainState() == 0) {
            int i = this.complainMapper.updateByPrimaryKey(complain);
            timeInsert();
            return i;
        }
        return null;
    }

    /**
     * 更新es索引库
     */
    public void timeInsert() {
        List<TComplain> tComplainList = complainMapper.selectAll();
        ArrayList<EsTComplain> list = new ArrayList<>();
        for (TComplain tComplain : tComplainList) {
            User user = userMapper.selectByPrimaryKey(tComplain.getuId());
            EsTComplain esTComplain = new EsTComplain();
            esTComplain.setLoginName(user.getLoginName());
            BeanUtils.copyProperties(tComplain, esTComplain);
            list.add(esTComplain);
        }
        complainRepository.saveAll(list);
    }


}

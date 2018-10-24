package com.czxy;

import com.czxy.tobto.dao.TFindsMapper;
import com.czxy.tobto.dao.repository.TFindsRepository;
import com.czxy.tobto.domain.ES.ESTFinds;
import com.czxy.tobto.domain.TFinds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AfterWebApplication.class)
public class AfterWebTest {

    @Resource
    private TFindsMapper tFindsMapper;

    @Autowired
    private TFindsRepository tFindsRepository;

  /*  @Test
    public void syncTest(){
        tFindsRepository.deleteAll();
        List<TFinds> tFinds = tFindsMapper.selectAll();
        ArrayList<ESTFinds> esList  =  new ArrayList<>();
        for (TFinds tf : tFinds){
            ESTFinds estFinds = new ESTFinds();
            BeanUtils.copyProperties(tf,estFinds);
            esList.add(estFinds);
        }
        tFindsRepository.saveAll(esList);
    }*/

    @Test
    public void demoTest(){
        TFinds tFinds = new TFinds();
        tFinds.setfId(7);
        tFinds.setfName("测试");
        tFinds.setfUrl("www.test.com");
        tFinds.setfShow(1);
        tFindsMapper.updateByPrimaryKey(tFinds);
    }
}

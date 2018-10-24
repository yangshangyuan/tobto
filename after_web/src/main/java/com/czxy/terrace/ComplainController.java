package com.czxy.terrace;

import com.czxy.terrace.service.ComplainService;
import com.czxy.tobto.domain.ES.EsTAdvertising;
import com.czxy.tobto.domain.ES.EsTComplain;
import com.czxy.utils.DataGridResult;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/terrace")
public class ComplainController {

    @Resource
    private ComplainService complainService;

    @GetMapping("/findComByPage")
    public ResponseEntity<DataGridResult> findAdvByPage(EsTComplain esTComplain, Integer page, Integer rows) {
        Page<EsTComplain> proByPage = complainService.findComByPage(esTComplain.getComplainState(), page, rows);
        System.out.println(esTComplain.getComplainState());
        DataGridResult result = new DataGridResult();
        result.setTotal(proByPage.getTotalElements());
        result.setRows(proByPage.getContent());

        return  new ResponseEntity<>(result, HttpStatus.OK);
    }


}

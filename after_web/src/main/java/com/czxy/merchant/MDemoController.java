package com.czxy.merchant;

import com.czxy.merchant.service.MDemoService;
import com.czxy.merchant.service.impl.MDemoServiceImpl;
import com.czxy.utils.DataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class MDemoController {


    @Autowired
    private MDemoService mDemoService;
    @GetMapping
    public ResponseEntity<DataGridResult> findPage(Integer page,Integer rows){

        DataGridResult result = mDemoService.findPage(page, rows);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("up")
    public ResponseEntity<Void> up(String str){
    mDemoService.up(str);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("load")
    public ResponseEntity<Void> load(String str){
        mDemoService.load(str);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

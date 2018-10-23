package com.czxy.merchant;

import com.czxy.merchant.service.MDemoService;
import com.czxy.merchant.service.impl.MDemoServiceImpl;
import com.czxy.tobto.domain.ES.ESMDemo;
import com.czxy.tobto.domain.MDemo;
import com.czxy.utils.DataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class MDemoController {

/*
商品分页展示
 */
    @Autowired
    private MDemoService mDemoService;
    @GetMapping
    public ResponseEntity<DataGridResult> findPage(String dName,Integer page,Integer rows){

        DataGridResult result = mDemoService.findPage(dName,page, rows);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    /*
    商品上架
     */
    @PutMapping("up")
    public ResponseEntity<Void> up(String str){
        mDemoService.up(str);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    /*
    商品下架
     */
    @PutMapping("load")
    public ResponseEntity<Void> load(String str){
        mDemoService.load(str);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/all")
    public ResponseEntity<Void> all(MDemo mDemo){
        mDemoService.updataAll(mDemo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> add(MDemo mDemo){
        mDemoService.add(mDemo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

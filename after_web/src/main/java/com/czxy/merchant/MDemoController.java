package com.czxy.merchant;

import com.czxy.merchant.service.MDemoService;
import com.czxy.tobto.domain.MDemo;
import com.czxy.tobto.domain.TMerchant;
import com.czxy.utils.DataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/product")
public class MDemoController {

/*
商品分页展示
 */
    @Autowired
    private MDemoService mDemoService;

    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletResponse response;
    @GetMapping
    public ResponseEntity<DataGridResult> findPage(String dName,Integer page,Integer rows){

        try {
           TMerchant tMerchant = (TMerchant)session.getAttribute("merchant");
            if (tMerchant==null){
                response.sendRedirect("http://localhost:8088/");
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            DataGridResult result = mDemoService.findPage(tMerchant,dName, page, rows);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    /*
    商品上架
     */
    @PutMapping("up")
    public ResponseEntity<Void> up(String str){
        try {
            mDemoService.up(str);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    /*
    商品下架
     */
    @PutMapping("load")
    public ResponseEntity<Void> load(String str){
        try {
            mDemoService.up(str);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 修改商品
     * @param mDemo
     * @return
     */
    @PutMapping("/all")
    public ResponseEntity<Void> all(MDemo mDemo){
        try {
            mDemoService.updataAll(mDemo);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 添加商品
     * @param mDemo
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<Void> add(MDemo mDemo){
        try {
            mDemoService.add(mDemo);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}

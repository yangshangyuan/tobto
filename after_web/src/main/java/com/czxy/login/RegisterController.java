package com.czxy.login;

import com.czxy.merchant.service.MerchantService;
import com.czxy.tobto.domain.TMerchant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterController  {

    @Resource
    private MerchantService merchantService;

    @GetMapping("/getMerchant")
    public ResponseEntity<List<TMerchant>> findAllMer (){
        List<TMerchant> allMerchant = merchantService.findAllMerchant();
        return new ResponseEntity<>(allMerchant, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Void> register(){

        return null;
    }
}

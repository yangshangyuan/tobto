package com.czxy.login;

import com.czxy.tobto.domain.TMerchant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterController  {

    public ResponseEntity<List<TMerchant>> findAllMer (){

        return null;
    }
}

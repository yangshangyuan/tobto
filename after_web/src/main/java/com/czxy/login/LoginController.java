package com.czxy.login;

import com.czxy.login.service.LoginService;
import com.czxy.tobto.domain.User;
import com.czxy.utils.PasswordUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping
    public ResponseEntity<String> login (String loginName , String loginPassword){
        System.out.println(loginName + "=============" + loginPassword );
        User login = loginService.login(loginName);
        if (login == null){
            return new ResponseEntity<>("帐号不存在",HttpStatus.NOT_FOUND);
        }
        if (! login.getLoginPassword().equals(PasswordUtil.MD5Encode(loginPassword,"utf-8",false))){
            return new ResponseEntity<>("密码错误",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (login.getuService() == 0 || login.getuPower() == 0){
            return new ResponseEntity<>("/merchant/index.html",HttpStatus.OK);
        }
        if (login.getuPower() == 1){
            return new ResponseEntity<>("terrace/index.html",HttpStatus.OK);
        }


        return new ResponseEntity<>("帐号密码错误",HttpStatus.INTERNAL_SERVER_ERROR);

    }

}

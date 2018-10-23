package com.czxy.login;

import com.czxy.login.service.LoginService;
import com.czxy.tobto.domain.User;
import com.czxy.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @Autowired
    private HttpSession session;



    @GetMapping
    public ResponseEntity<String> login (String loginName , String loginPassword){
        System.out.println(loginName + "=============" + loginPassword );
        User login = loginService.login(loginName);
        System.out.println(login.getuService() + "==========" + login.getuPower());
        if (login == null){
            return new ResponseEntity<>("帐号不存在",HttpStatus.NOT_FOUND);
        }


        if (login.getuService() != null || login.getuPower() != null){

            if (! login.getLoginPassword().equals(PasswordUtil.MD5Encode(loginPassword,"utf-8",false))){
                return new ResponseEntity<>("密码错误",HttpStatus.INTERNAL_SERVER_ERROR);
            }

            if (login.getuService() == 0 || login.getuService() == 1  || login.getuPower() == 0  ){
                session.setAttribute("user",login);
                return new ResponseEntity<>("/merchant/index.html",HttpStatus.OK);
            }
            if (login.getuPower() == 1 || login.getuService() == 2){
                session.setAttribute("user",login);
                return new ResponseEntity<>("terrace/index.html",HttpStatus.OK);
            }
        }



        return new ResponseEntity<>("登录失败,帐号不存在",HttpStatus.INTERNAL_SERVER_ERROR);

    }

}

package com.czxy.terrace;


import com.czxy.terrace.service.TerraceUserService;
import com.czxy.tobto.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/terrace")
public class TerraceUserController {
   @Autowired
   private HttpSession session;

   @Autowired
   private TerraceUserService terraceUserService;

    @GetMapping("/login")
    public ResponseEntity<Void> login(User user){
        //1.得到subject对象
//        Subject subject = SecurityUtils.getSubject();
//        //通过shiro进行认证登录
//        subject.login(new UsernamePasswordToken(user.getLoginName(), user.getLoginPassword()));
//        //登录成功,存到session中
//        User loginUser = (User)subject.getPrincipal();
//        session.setAttribute("loginUser",loginUser);

       terraceUserService.findUserByUsername(user.getLoginName());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

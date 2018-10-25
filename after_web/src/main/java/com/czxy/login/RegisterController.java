package com.czxy.login;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.czxy.login.service.RegisterService;
import com.czxy.merchant.service.MerchantService;
import com.czxy.tobto.domain.TMerchant;
import com.czxy.tobto.domain.User;
import com.czxy.utils.GetRandomCodeUtil;
import com.czxy.utils.SmsUtil;
import com.czxy.vo.RegisterVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/register")
public class RegisterController  {

    @Resource
    private MerchantService merchantService;

    @Autowired
    private HttpSession httpSession;

    @Resource
    private RegisterService registerService;

    @GetMapping("/getMerchant")
    public ResponseEntity<List<TMerchant>> findAllMer (){
        List<TMerchant> allMerchant = merchantService.findAllMerchant();
        return new ResponseEntity<>(allMerchant, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> register(RegisterVo register){
        System.out.println(register);

        String code = (String) httpSession.getAttribute(register.getPhone());

        if (! code.equals(register.getVifyCode())){
            return new ResponseEntity<>("验证码错误",HttpStatus.INTERNAL_SERVER_ERROR);
        }


        try{
            User user = new User();
            BeanUtils.copyProperties(register,user);
            user.setPhone(register.getPhone());
            System.out.println(user);

            registerService.register(user,register.getMerchant());

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("注册失败",HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<>("http://localhost:8088",HttpStatus.OK);
    }

    @GetMapping("/sendSms")
    public ResponseEntity<Void> sendSms(String telephone)  {
        String code = GetRandomCodeUtil.getNumber();
        try {
            SendSmsResponse sendSmsResponse = SmsUtil.sendSms(telephone, code);
            httpSession.setAttribute(telephone,code);
            System.out.println(telephone + "====" + code);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (ClientException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

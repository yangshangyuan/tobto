package com.czxy.login.service;

import com.czxy.tobto.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public interface RegisterService {

    public void register (User user , Integer merchant);

}

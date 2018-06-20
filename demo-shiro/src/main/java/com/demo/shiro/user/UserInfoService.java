package com.demo.shiro.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sheng on 2018/6/12.
 */
@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Transactional(readOnly = true)
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoService.findByUsername()");
        return userInfoRepository.findByUsername(username);
    }
}

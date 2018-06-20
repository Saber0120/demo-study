package com.demo.shiro.user;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by sheng on 2018/6/12.
 */
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {

    public UserInfo findByUsername(String username);
}

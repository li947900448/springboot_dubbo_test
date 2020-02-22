package com.lsf.service.impl;

import com.lsf.bean.User;
import com.lsf.mapper.UserMapper;
import com.lsf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2020/2/21.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(int k) {
        return userMapper.selectByPrimaryKey(k);
    }
}

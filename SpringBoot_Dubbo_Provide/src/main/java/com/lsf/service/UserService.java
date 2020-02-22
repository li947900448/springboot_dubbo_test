package com.lsf.service;

import com.lsf.bean.User;

/**
 * Created by Administrator on 2020/2/21.
 */
public interface UserService {

    abstract User selectByPrimaryKey(int k);

}

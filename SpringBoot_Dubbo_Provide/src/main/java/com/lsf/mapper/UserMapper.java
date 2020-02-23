package com.lsf.mapper;

import com.lsf.bean.User;
import org.springframework.stereotype.Repository;


/**
 * Created by Administrator on 2020/2/21.
 */
@Repository
public interface UserMapper {
    User selectByPrimaryKey(Integer userId);
}

package com.lsf.mapper;

import com.lsf.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2020/2/21.
 */
@Repository
public interface UserMapper {
    User selectByPrimaryKey(Integer userId);
}

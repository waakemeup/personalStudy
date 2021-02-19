package com.waakemeup.dao;

import com.waakemeup.pojo.User;

import java.util.List;

public interface UserMapper {

    //根据ID查询用户
    User getUserById(int id);

}

package com.waakemeup.dao;

import com.waakemeup.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    User queryUsers(@Param("id") int id);

    int updateUser(User user);
}

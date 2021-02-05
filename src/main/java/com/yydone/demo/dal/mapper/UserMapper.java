package com.yydone.demo.dal.mapper;

import com.yydone.demo.dal.model.UserDO;

public interface UserMapper {

    UserDO selectByUserId(String userId);
}

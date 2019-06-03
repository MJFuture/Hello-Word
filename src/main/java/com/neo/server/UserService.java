package com.neo.server;

import java.util.List;

import com.neo.entity.UserEntity;

public interface UserService {
	 /**
     * 根据接口查询所用的用户
     */
    public List<UserEntity> findAllUser();
    
    
    
}

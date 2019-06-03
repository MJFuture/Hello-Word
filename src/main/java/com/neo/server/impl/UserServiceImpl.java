package com.neo.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;

import com.neo.entity.UserEntity;
import com.neo.mapper.UserMapper;
import com.neo.server.UserService;

public class UserServiceImpl extends DaoSupport implements UserService  {
	 
	@Autowired
	private UserMapper mapper;
	
	@Override
	public List<UserEntity> findAllUser() {
		// TODO Auto-generated method stub
		return mapper.getAll();
	}

	@Override
	protected void checkDaoConfig() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

}

package com.wantao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wantao.bean.User;
import com.wantao.mapper.UserMapper;

/**
 * @author wantao
 * @date 2019-02-13 21:18
 * @description:user表
 */
@Service
public class UserService implements UserMapper {
	@Autowired
	private UserMapper userMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wantao.mapper.UserMapper#selectUserCount() 查询User数量
	 */
	@Override
	public Integer selectUserCount() {
		// TODO Auto-generated method stub
		return userMapper.selectUserCount();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wantao.mapper.UserMapper#selectAllUser() 查询所有的User
	 */
	@Override
	public List<User> selectAllUser() {
		return userMapper.selectAllUser();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wantao.mapper.UserMapper#insertUser(com.wantao.bean.User) 插入一个用户
	 */
	@Override
	public Integer insertUser(User user) {
		return userMapper.insertUser(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wantao.mapper.UserMapper#insertUserByBatch(java.util.List) 批量插入多个用户
	 */
	@Override
	public Integer insertUserByBatch(List<User> users) {
		return userMapper.insertUserByBatch(users);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wantao.mapper.UserMapper#selectUserById(java.lang.Integer) 按用户id查找用户
	 */
	@Override
	public User selectUserById(Integer userId) {
		return userMapper.selectUserById(userId);
	}

	/* (non-Javadoc)
	 * @see com.wantao.mapper.UserMapper#updateUserByUserId(com.wantao.bean.User) 按用户id修改用户
	 */
	@Override
	public Integer updateUserByUserId(User user) {
		return userMapper.updateUserByUserId(user);
	}

}

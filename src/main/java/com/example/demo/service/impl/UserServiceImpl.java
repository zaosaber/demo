package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserMapper userMapper;
	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		userMapper.insertUser(user);
		return user.getId();
	}
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userMapper.getAll();
	}
	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userMapper.findById(id);
	}
	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userMapper.update(user);
	}
	@Override
	public void delete(Long userId) {
		// TODO Auto-generated method stub
		userMapper.delete(userId);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int testTransantional() {
		// TODO Auto-generated method stub
		User user = new User();
		user.setAge(18);
		user.setCreateTime(new Date());
		user.setName("测试事务加入事务");
		user.setPhone("108168");
		userMapper.insertUser(user);
		int i = 18/0;
		return user.getId();
	}

}

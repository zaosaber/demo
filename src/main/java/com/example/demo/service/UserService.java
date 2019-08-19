package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.User;

public interface UserService {
       
	public int add(User user);
	
	public List<User> getAll();
	  
	public User findById(Long id);

	public void update(User user);

	public void delete(Long userId);
	
	public int testTransantional();
}

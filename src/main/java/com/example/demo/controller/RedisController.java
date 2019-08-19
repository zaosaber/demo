package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.untils.JsonData;
import com.example.demo.untils.JsonUtils;
import com.example.demo.untils.RedisClient;

@RestController
@RequestMapping("/api/v1/redis")
public class RedisController {
	@Autowired
	private RedisClient redisClient;
	
	@GetMapping("add")
	public void add() {
		User user = new User();
		user.setAge(22);
		user.setCreateTime(new Date());
		user.setName("陈意涵estelle是我老婆啊ya");
		user.setPhone("15999930599");
		String jsonString = JsonUtils.obj2String(user);
	    redisClient.set("wodelaopo:estellea", jsonString);
	}
	
	@GetMapping("get")
	public Object get() {
		String name = redisClient.get("wodelaopo:estellea");
		User uer = JsonUtils.string2Obj(name, User.class);
		return JsonData.buildSuccess(uer);
	}
	
}

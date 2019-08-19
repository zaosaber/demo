package com.example.demo.controller;

import java.util.Date;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import com.example.demo.task.AsyncTask;
import com.example.demo.untils.JsonData;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
       
	   @Autowired
	   private UserService userService;
	   
	   @Autowired
	   private AsyncTask asyncTask;
	   
	   @GetMapping("add")
		public Object add(){
			
			User user = new User();
			user.setAge(11);
			user.setCreateTime(new Date());
			user.setName("xdclass");
			user.setPhone("10010000");
			int id = userService.add(user);
			
	       return JsonData.buildSuccess(id);
		}
	   
	   /**
		 * 功能描述：查找全部用户
		 * @return
		 */
		@GetMapping("findAll")
		public Object findAll(){
			
	       return JsonData.buildSuccess(userService.getAll());
		}
		
		@GetMapping("find_by_id")
		public Object findById(long id){
	       return JsonData.buildSuccess(userService.findById(id));
		}
		
		@GetMapping("del_by_id")
		public Object delById(long id){
			userService.delete(id);
	       return JsonData.buildSuccess();
		}
		
		@GetMapping("update")
		public Object update(String name,int id){
			User user = new User();
			user.setName(name);
			user.setId(id);
			userService.update(user);
		    return JsonData.buildSuccess();
		}
		
		@GetMapping("testTransantional")
		public Object testTransantional(){
			int id = userService.testTransantional();
		    return JsonData.buildSuccess(id);
		}
		
		
		@GetMapping("async_task")
		public Object asyncTask() throws InterruptedException{
			long begin = System.currentTimeMillis();
			Future<String> task4 = asyncTask.task4();
			Future<String> task5 = asyncTask.task5();
			Future<String> task6 = asyncTask.task6();
			
			for(;;) {
				if(task4.isDone()&&task5.isDone()&&task6.isDone()) {
					break;
				}
			}
			long end = System.currentTimeMillis();
			long total = end-begin;
			System.out.println("总耗时"+total);
		    return JsonData.buildSuccess(total);
		}
		
		@Value("${test.url}")
		private String df;
		
		@GetMapping("df")
		public Object df(){
		    return JsonData.buildSuccess(df);
		}
}

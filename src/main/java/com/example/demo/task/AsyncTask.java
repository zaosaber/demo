package com.example.demo.task;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;


@Component
@Async
public class AsyncTask {
       
	   public void task1() throws InterruptedException {
		   long begin = System.currentTimeMillis();
		   Thread.sleep(1000l);
		   long end = System.currentTimeMillis();
		   System.out.println("任务1耗时"+(end-begin));
	   }
	   
	   public void task2() throws InterruptedException {
		   long begin = System.currentTimeMillis();
		   Thread.sleep(2000l);
		   long end = System.currentTimeMillis();
		   System.out.println("任务2耗时"+(end-begin));
	   }
	   
	   public void task3() throws InterruptedException {
		   long begin = System.currentTimeMillis();
		   Thread.sleep(3000l);
		   long end = System.currentTimeMillis();
		   System.out.println("任务3耗时"+(end-begin));
	   }
	   
	   public Future<String> task4() throws InterruptedException {
		   long begin = System.currentTimeMillis();
		   Thread.sleep(3000l);
		   long end = System.currentTimeMillis();
		   System.out.println("任务4耗时"+(end-begin));
		   return new AsyncResult<String>("任务4");
	   }
	  
	   public Future<String> task5() throws InterruptedException {
		   long begin = System.currentTimeMillis();
		   Thread.sleep(2000l);
		   long end = System.currentTimeMillis();
		   System.out.println("任务5耗时"+(end-begin));
		   return new AsyncResult<String>("任务5");
	   }
	
	   public Future<String> task6() throws InterruptedException {
		   long begin = System.currentTimeMillis();
		   Thread.sleep(1000l);
		   long end = System.currentTimeMillis();
		   System.out.println("任务6耗时"+(end-begin));
		   return new AsyncResult<String>("任务6");
	   }
}

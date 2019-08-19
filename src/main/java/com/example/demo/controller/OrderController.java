package com.example.demo.controller;

import java.io.UnsupportedEncodingException;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jms.MsgProducer;
import com.example.demo.service.ProducerService;
import com.example.demo.untils.JsonData;



/**
 * 功能描述：模拟微信支付回调
 *
 * <p> 创建时间：May 3, 2018 9:53:14 PM </p> 
 *
 *@作者 小D课堂  小D
 */
@RestController
@RequestMapping("/api/v1")
public class OrderController {
	
	@Autowired
	private ProducerService producerService;
	/**
	 * 功能描述：微信支付回调接口
	 * @param msg 支付信息
	 * @return
	 */
	@GetMapping("order")
	public Object order(String msg){
		
		Destination destination = new ActiveMQQueue("order.queue");
		
		producerService.sendMessage(destination, msg);
	
       return JsonData.buildSuccess();
	}
	
	
	
	@GetMapping("common")
	public Object common(String msg){
		producerService.sendMessage(msg);	
       return JsonData.buildSuccess();
	}
	
	
	
	@GetMapping("topic")
	public Object topic(String msg){
		producerService.sendvVideo(msg);	
       return JsonData.buildSuccess();
	}
	
	
	
	
	
	
	@Autowired
	private MsgProducer msgProducer;
	
//	
//	/**
//	 * 功能描述：微信支付回调接口
//	 * @param msg 支付信息
//	 * @return
//	 */
	@GetMapping("comment")
	public Object comment(String msg,String tag) throws MQClientException, RemotingException, MQBrokerException, InterruptedException, UnsupportedEncodingException{
	  
		/**
        * 创建一个消息实例，包含 topic、tag 和 消息体           
       */
       Message message = new Message("commentTopic",tag, msg.getBytes(RemotingHelper.DEFAULT_CHARSET));
       
       //同步的方式，会有返回结果,发送的是普通消息
       SendResult result = msgProducer.getProducer().send(message);
       
       System.out.println("发送响应：MsgId:" + result.getMsgId() + "，发送状态:" + result.getSendStatus());
     
       return JsonData.buildSuccess();
	}
	
	
	
	
	
	
}

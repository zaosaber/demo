package com.example.demo.service.impl;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.service.ProducerService;

@Service
public class ProducerServiceImpl implements ProducerService{
	
	@Autowired
	private JmsMessagingTemplate jmsTemplate; //用来发送消息到broker的对象
	
	@Autowired
	private Queue queue;  //默认的，在启动类哪里注入了
    
	//发送消息，destination是发送到的队列，message是待发送的消息
	@Override
	public void sendMessage(Destination destination, String message) {
		// TODO Auto-generated method stub
		jmsTemplate.convertAndSend(destination, message);
	}

	@Override
	public void sendMessage(String message) {
		// TODO Auto-generated method stub
		jmsTemplate.convertAndSend(this.queue, message);
	}
	
	@Autowired
	private Topic topic;

	@Override
	public void sendvVideo(String message) {
		// TODO Auto-generated method stub
		jmsTemplate.convertAndSend(this.topic,message);
	}

}

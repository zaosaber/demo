package com.example.demo.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
@Component

public class OrderConsumer {

	@JmsListener(destination="order.queue")
	public void receiveQueueO(String text){
		System.out.println("OrderConsumer收到的报文为:"+text);
	}
	
	@JmsListener(destination="common.queue")
	public void receiveQueueC(String text){
		System.out.println("CommonConsumer收到的报文为:"+text);
	}
}

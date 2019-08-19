package com.example.demo.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//@Component
public class OrderSub {
       
	   @JmsListener(destination="video.topic",containerFactory="jmsListenerContainerTopic")
	   public void receive1(String message) {
		   System.out.println("receive1 接收的信息为："+message);
	   }
	   
	   @JmsListener(destination="video.topic",containerFactory="jmsListenerContainerTopic")
	   public void receive2(String message) {
		   System.out.println("receive2 接收的信息为："+message);
	   }
	   
	   @JmsListener(destination="video.topic")
	   public void receive3(String message) {
		   System.out.println("receive3 接收的信息为："+message);
	   }
}

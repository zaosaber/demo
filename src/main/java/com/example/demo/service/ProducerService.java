package com.example.demo.service;

import javax.jms.Destination;

public interface ProducerService {
       
	    public void sendMessage(Destination destination,String message);
	    
	    public void sendMessage(String message);
	    
	    public void sendvVideo(String message);
}

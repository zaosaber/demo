package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.untils.JsonData;

@RestController
@RequestMapping("/api/logback")
public class TestLogBackController {
       
	   private Logger logger = LoggerFactory.getLogger(this.getClass());
	   
	   @GetMapping("log")
	   public Object log() {
		   logger.debug("this is debug levef");
		   logger.info("this is info levef");
		   logger.warn("this is warn levef");
		   logger.error("this is error levef");
		   return JsonData.buildSuccess();
	   }
}

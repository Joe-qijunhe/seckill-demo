package com.joe.seckilldemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.joe.seckilldemo")
public class SeckillDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeckillDemoApplication.class, args);
	}

}

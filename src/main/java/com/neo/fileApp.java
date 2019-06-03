package com.neo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.neo.mapper"})
@MapperScan("com.neo.mapper")
public class fileApp {
	
	public static void main(String[] args) {
		SpringApplication.run(fileApp.class, args);
	}
}

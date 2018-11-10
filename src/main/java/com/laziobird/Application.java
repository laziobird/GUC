package com.laziobird;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author laziobird
 *
 */
@SpringBootApplication
@MapperScan("com.laziobird.bean")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

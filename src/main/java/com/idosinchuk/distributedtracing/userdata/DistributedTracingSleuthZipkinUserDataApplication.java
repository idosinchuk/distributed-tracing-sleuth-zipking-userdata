package com.idosinchuk.distributedtracing.userdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DistributedTracingSleuthZipkinUserDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributedTracingSleuthZipkinUserDataApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate(){
		return new RestTemplate();
	}

}

package com.sudheer.securebank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SecuredBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuredBankApplication.class, args);
	}

}

package com.pratik.billpayapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.pratik.billpayapp")
@EnableJpaRepositories
public class BillPayAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillPayAppApplication.class, args);
	}

}

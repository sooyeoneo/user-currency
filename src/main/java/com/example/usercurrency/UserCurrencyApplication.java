package com.example.usercurrency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class UserCurrencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCurrencyApplication.class, args);
	}

}

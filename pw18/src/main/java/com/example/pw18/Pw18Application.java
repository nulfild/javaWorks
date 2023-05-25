package com.example.pw18;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(
	exclude = { DataSourceAutoConfiguration.class }
)
@Slf4j
public class Pw18Application {

	public static void main(String[] args) {
		log.info("Start application");
		SpringApplication.run(com.example.pw18.Pw18Application.class, args);
	}
}

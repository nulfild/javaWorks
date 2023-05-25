package com.example.pw16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(
	exclude = { DataSourceAutoConfiguration.class }
)
public class Pw16Application {

	public static void main(String[] args) {
		SpringApplication.run(Pw16Application.class, args);
	}
}

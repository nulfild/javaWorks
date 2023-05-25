package com.example.pw13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Pw13Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(
			Pw13Application.class,
			args
		);
		StudentConf student = context.getBean(
			StudentConf.class
		);

		System.out.println(student.getName());
		System.out.println(student.getLastName());
		System.out.println(student.getGroup());

		Environment env = context.getBean(Environment.class);
		System.out.println(env.getProperty("student.name"));
		System.out.println(
			env.getProperty("student.lastName")
		);
		System.out.println(env.getProperty("student.group"));
	}
}

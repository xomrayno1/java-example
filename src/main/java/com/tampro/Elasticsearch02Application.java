package com.tampro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Elasticsearch02Application {

	public static void main(String[] args) {
		SpringApplication.run(Elasticsearch02Application.class, args);
	}

}

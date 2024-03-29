package com.amdocs.demoDanielBeltran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan({"com.amdocs"})
@EntityScan("com.amdocs.entity")
@EnableJpaRepositories("com.amdocs.repository")
public class DemoDanielBeltranApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoDanielBeltranApplication.class, args);
	}

}

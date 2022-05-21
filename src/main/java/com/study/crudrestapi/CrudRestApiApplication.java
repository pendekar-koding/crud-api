package com.study.crudrestapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "appAuditorAware")
@OpenAPIDefinition(info = @Info(title = "CRUD API", version = "1"))
public class CrudRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudRestApiApplication.class, args);
	}

}

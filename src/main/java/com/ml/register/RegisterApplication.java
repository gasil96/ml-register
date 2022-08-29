package com.ml.register;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
@EnableJpaRepositories
@OpenAPIDefinition(info = @Info(title = "${application.title}", version = "${application.version}", description = "${application.description}"))
public class RegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterApplication.class, args);
	}

}

package com.courier.packaging.service.pkg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.courier.packaging.*" })

public class ServicePkgApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicePkgApplication.class, args);
	}

}


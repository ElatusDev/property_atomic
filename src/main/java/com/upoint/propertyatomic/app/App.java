package com.upoint.propertyatomic.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.upoint.propertyatomic.app", "com.upoint.utilities.mapper", "com.upoint.propertyatomic.util"})
@EnableJpaRepositories
@EntityScan("com.upoint.model.product")
public class App {
	public static void main (String[] args) {
		SpringApplication.run(App.class, args);
	}

}

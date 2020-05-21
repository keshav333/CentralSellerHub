package com.spe.CentralSellerPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages={"com.spe.CentralSellerPortal"})
public class CentralSellerPortalApplication{

	public static void main(String[] args) {
		SpringApplication.run(CentralSellerPortalApplication.class, args);
	}

}



//extends SpringBootServletInitializer
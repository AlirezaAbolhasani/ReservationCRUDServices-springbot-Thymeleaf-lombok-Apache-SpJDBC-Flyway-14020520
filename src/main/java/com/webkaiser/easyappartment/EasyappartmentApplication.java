package com.webkaiser.easyappartment;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class EasyappartmentApplication implements ApplicationRunner {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(EasyappartmentApplication.class, args);
	}
	@Override
	public void run(ApplicationArguments arg) throws Exception{
			System.out.println("*****************************************************************************");
			System.out.println("**************Reservation Webservice Is Running******************************");
			System.out.println("**************Developer:Alireza Abolhasani***********************************");
			System.out.println("*****************************************************************************");
	}
}

package com.webkaiser.easyappartment;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EasyappartmentApplication implements ApplicationRunner {

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

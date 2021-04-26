package com.thevirtualx.mvcApp;

import com.thevirtualx.mvcApp.Entity.Rated;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AppApplication extends SpringBootServletInitializer { //extend this class

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}


	//WARDEPLOY
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AppApplication.class);
	}

	
}


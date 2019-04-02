package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.amazonaws.services.appstream.model.Application;

	@SpringBootApplication
	public class Driver extends SpringBootServletInitializer{
		
		@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
			return application.sources(Application.class);
		}
		
		public static void main(String[] args) {
			SpringApplication.run(Driver.class, args);
		}
}

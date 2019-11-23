package com.mkasana.FamilyTree.Pariwar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mkasana.FamilyTree.Pariwar"})
public class PariwarApplication {
	public static void main(String[] args) {
		SpringApplication.run(PariwarApplication.class, args);
	}
}

package br.com.ibm.vs_spring.vs_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class VsSpringApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(VsSpringApplication.class, args);
	}

}

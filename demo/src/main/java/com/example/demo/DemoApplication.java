package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@CrossOrigin(origins = { "*" })
public class DemoApplication{

	public static void main(String[] args) {
		// SpringApplication.run(DemoApplication.class, args);
		SpringApplication sa = new SpringApplication(DemoApplication.class);
		sa.run(args);
	}


	@GetMapping({ "/v1/hello/{name}", "/v1/hello" })
	public String sayHello(@PathVariable(required = false) String name) {
		if (name == null) {
			return "Hello World";
		}
		return "Hello " + name;
	}
}

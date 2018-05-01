package com.ericardo.strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StringsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsApplication.class, args);
	}
	
	@RequestMapping("/")
	public String landingPage() {
		return "Hello client, how are you doing?";
	}
	
	@RequestMapping("/random")
	public String randomPage() {
		return "Spring Boot is great! So easy to respond with strings!";
	}
}

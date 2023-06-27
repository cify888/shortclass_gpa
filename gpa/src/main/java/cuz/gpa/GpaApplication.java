package cuz.gpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class GpaApplication {

	@GetMapping("/")
	public String hello(){
		return "Hello World!";
	}
	@GetMapping("/student")
	public String helloStudent(){
		return "Hello Student!";
	}

	public static void main(String[] args) {
		SpringApplication.run(GpaApplication.class, args);
	}

}

package com.example.spring.webservices.rest.hello;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
	
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("hello world");
	}


	@GetMapping(path = "hello-world/user/{name}")
	public String getUser(@PathVariable String name) {
		return "Hello "+name +" !!";
	}
}

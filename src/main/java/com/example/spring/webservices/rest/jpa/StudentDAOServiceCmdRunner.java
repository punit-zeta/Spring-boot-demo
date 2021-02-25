package com.example.spring.webservices.rest.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentDAOServiceCmdRunner implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(StudentDAOServiceCmdRunner.class); 
	
	@Autowired
	private StudentDAOService service;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Student student = new Student("Punit", "Admin");
		long id = service.save(student);
		log.info("New user created : "+id);
	}

}

package com.example.spring.webservices.rest.user;

import java.util.List;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.spring.webservices.rest.exception.UserNotFoundException;


import java.net.URI;


@RestController
public class UserResource {

	@Autowired
	private UserDAOService service;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	@GetMapping("/user/{id}")
	public EntityModel<User> find(@PathVariable int id) {
		User user = service.find(id);
		if(user == null) {
			throw new UserNotFoundException("id = "+id);
		}
		
		// Older method
//		Resource<User> resource = new Resource<User>(user);
//		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
//		resource.add(linkTo.withRel("all-users"));
		
		// New version
        EntityModel<User> resource = EntityModel.of(user);
		
		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}
	
	@DeleteMapping("/user/{id}")
	public User deleteById(@PathVariable int id) {
		User user = service.deleteById(id);
		if(user == null) {
			throw new UserNotFoundException("id = "+id);
		}
		return user;
	}
	


	@PostMapping("user/create")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		
		User savedUser = service.createUser(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	
}

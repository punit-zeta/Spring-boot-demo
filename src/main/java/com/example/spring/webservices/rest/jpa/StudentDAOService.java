package com.example.spring.webservices.rest.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentDAOService {

	@PersistenceContext
	private EntityManager entityManager;
	
	public long save(Student student) {
		// record all changes done to user
		entityManager.persist(student);
		return student.getId();
	}
	
}

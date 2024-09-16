package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jpa;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository   // We want this to talk to a database so we add the @Repository.
@Transactional  // Whenever you want to execute queries with JPA, you must have @Transactional in here.
public class CourseJpaRepository {
	
	//@Autowired   // In order to use the entityManager, we have to Autowire it so it connects to Course.java.
	@PersistenceContext   // Instead of @Autowired we are using a more specific annotation that works with EntityManager.
	private EntityManager entityManager;
	
	// We no longer have to write SQL queries, all we are concerned with is calling the correct entityManager methods.
	public void insert(Course course) {
		// All the mapping was already created in Course.java by mapping the Course table as well as all the columns directly to the database. All we have to do is enter this code.
		entityManager.merge(course);
	}
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void DeleteById(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
}

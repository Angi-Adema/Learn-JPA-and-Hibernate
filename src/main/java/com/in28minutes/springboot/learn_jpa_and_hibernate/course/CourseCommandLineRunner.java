package com.in28minutes.springboot.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
	
//	@Autowired
//	private CourseJdbcRepository repository;
	
	// Instead of using the JDBC repository created we now want to make use of the JPA repository just created.
	@Autowired
	private CourseJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course(1, "Learn Java Now!", "in28minutes"));
		repository.insert(new Course(2, "Learn Spring JPA Now!", "in28minutes"));
		repository.insert(new Course(3, "Learn JPA Now!", "in28minutes"));
		
		repository.DeleteById(1);
		
		System.out.println(repository.findById(2));
		System.out.println(repository.findById(3));
	}

}

package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;

@Repository   // When a class talks to a database it is @Repository.
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_QUERY =
			"""
				insert into course (id, name, author)
				values(?, ?, ?)
				
			""";
	
	private static String DELETE_QUERY =
			"""
				delete from course
				where id = ?
				
			""";
	
	private static String SELECT_QUERY =
			"""
				select * from course
				where id = ?
				
			""";
	
	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());  // The question marks in the query above match the order of items to insert here.
	}
	
	public void deleteById(long id) {
		springJdbcTemplate.update(DELETE_QUERY, id);  
	}
	
	public Course findById(long id) {
		// We want to take this result set and map it to the Course bean. ResultSet -> Bean => Row Mapper (Help us map a ResultSet to Bean) =>
		// Also need to send id as the input. id
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}
}

package com.in28minutes.springboot.learn_jpa_and_hibernate.course;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// When using JPA, we would map or create a mapping between the Course Java Bean and the in memory database. We then use that mapping to insert values in the database.
// This makes it so we do not have to write all the SQL queries and does the operations on the database or table for us.
//Only need this if Bean name is different than table column name. @Entity (name="Course_Details") - this would then map to the correct database name.
@Entity
public class Course {
	
	@Id  // This adds the id as the primary key.
	private long id;
	
	//@Column(name="name")  // This maps these fields to the columns in the database and specify it maps to the column named "name". This is only necessary if the column has a different name than what we show here.
	private String name;
	
	//@Column(name="author")  
	private String author;
	
	// TODO: Create a constructor, getters and toString method.
	
	public Course() {
		
	}
	
	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}
	

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
}



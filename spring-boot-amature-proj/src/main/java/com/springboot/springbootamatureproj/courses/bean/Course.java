package com.springboot.springbootamatureproj.courses.bean;

public class Course {
	private int id;
	private String name;
	private String author;

	// the constructor is needed cuz we need to create objects
	public Course(int id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	
	// getters are necessary as spring gets the values this way
	// and prepares the response result.
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}
	
	// not needed for the response method or by spring
	// needed if we do a sysout of the object
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

}

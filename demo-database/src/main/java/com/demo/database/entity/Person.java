package com.demo.database.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

// as it's a bean, create constructor and setters with all the fields.

// for jpa/hibernate:
// to make it an entity just add @Entity from javax.persistence
// no need to name the table with @Table(name='') as the table name is same
// in case we wanted to map to a different table name, we could've done that

// for jpa/hibernate:
// spring boot autoconfigures the Jpa/hibernate in the classpath
// and hibernate does a schema update (create/updates the tables)
// if we add @Entity. It's a hibernate feature.
// now as we also have a data.sql which creates the table there would be error
// thus we comment the table creation part from there.
@Entity

// the named query we've created in PersonJpaRepository
// the query is written in jpql, where we write query in terms of entity and it's fields
// "select p from Person p" means select all persons from person entity.
@NamedQuery(name = "find_all_persons", query = "select p from Person p")
public class Person {
	// convention to make the data fields of the entity private

	// for jpa/hibernate:
	// no need for @Column for each fields as the names match
	@Id // for the primary key
	@GeneratedValue // hibernate generates the value for this col
	private int id;
	private String name;
	private String location;
	// for jpa/hibernate:
	// no need for
	// @Column(name = "birth_date")
	// Camel case is handled by default
	private LocalDate birthDate;

	// for the new BeanPropertyRowMapper(Person.class) in PersonJdbcDao to work we
	// need an empty/default constructor.
	// as we'd provide a parameterized constructor, the default one which is
	// provided implicitly is gone.
	// so we'll create a default constructor.

	// for jpa/hibernate:
	// for hibernate also we need to have a default constructor, and setters for
	// each fields.
	public Person() {

	}

	// for jpa/hibernate:
	// no id cuz hibernate will create the ID, and it'll be easier for me to
	// create an object without id.
	public Person(String name, String location, LocalDate birthDate) {
		super();
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}

	public Person(int id, String name, String location, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "\n Person [id=" + id + ", name=" + name + ", location=" + location + ", birthDate=" + birthDate + "]";
	}

}

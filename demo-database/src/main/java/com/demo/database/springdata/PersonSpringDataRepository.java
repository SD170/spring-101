package com.demo.database.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.database.entity.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {
	// <param 1> the type of the entity we wanna create repository for
	// <param 2> the type of the primary key

}

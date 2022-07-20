package com.demo.database.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.demo.database.entity.Person;

// a class to manage the entity. It's called a repository.
@Repository
// transaction management: 
// 
// So when we do operations to the database, transactions become very important.
// When we have multiple steps in a single transaction we'd want all of them to be successful 
// or all of them to fail together. 
// For now we would implement transactions at the level of a repository. 
// Ideally transactions have to be implemented around your business services.
// So we’ll need to say this is the repository. We would need to have transactions around this.
@Transactional
public class PersonJpaRepository {
	// connect to the database.
	@PersistenceContext // all operations we perform is stored inside PersistenceContext
	EntityManager entityManager; // EntityManager is an interface to the PersistenceContext
	// all operations has to go through EntityManager

	// we'll use jpql and create a named query for findAll()
	public List<Person> findAll() {
		// createNamedQuery("name of the query", type of entity the query returns)
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		// .getResultList() returns the result
		return namedQuery.getResultList();
		
		// the actual query(named Query) will be written inside the entity using jpql
	}

	public Person findById(int id) {
		// param1: the class, param2: the pk
		return entityManager.find(Person.class, id);
	}

	public Person update(Person person) {
		// merge() is like upsert, if this person object with id is present, update
		// or insert with that id and details.
		return entityManager.merge(person);
	}

	public Person insert(Person person) {
		// same as update
		return entityManager.merge(person);
	}

	public void deleteById(int id) {
		// we need the person object to delete the person
		// we can use the findById() method
		Person person = findById(id);
		entityManager.remove(person);
	}

}

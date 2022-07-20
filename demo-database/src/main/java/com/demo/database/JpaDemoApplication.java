package com.demo.database;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.database.entity.Person;
import com.demo.database.jdbc.PersonJdbcDao;
import com.demo.database.jpa.PersonJpaRepository;

//@SpringBootApplication // commenting to run the SpringDataDemoApplication
public class JpaDemoApplication implements CommandLineRunner {

	// logger
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository personJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person person1 = personJpaRepository.findById(100007);

		// no need to pass the id with insert, as hibernate generates it
		Person newPerson = new Person("Iniesta", "Spain", LocalDate.now());
		Person insertedPerson = personJpaRepository.insert(newPerson);
		
		Person updatedPerson = new Person(100007, "CR7", "England", LocalDate.now());
		Person updatedPersonRet = personJpaRepository.update(updatedPerson);
		personJpaRepository.deleteById(100007); // returns nothing

		List<Person> persons = personJpaRepository.findAll();
		
		logger.info("person with id 100007 -> {}", person1);
		logger.info("inserting new person, inserted Person -> {}", insertedPerson);
		logger.info("updationg person with id 100007, effected rows -> {}", updatedPersonRet);
		logger.info("All persons -> {}", persons);

	}

}

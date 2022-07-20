package com.demo.database;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.database.entity.Person;
import com.demo.database.jdbc.PersonJdbcDao;
import com.demo.database.jpa.PersonJpaRepository;
import com.demo.database.springdata.PersonSpringDataRepository;

@SpringBootApplication
public class SpringDataDemoApplication implements CommandLineRunner {

	// logger
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonSpringDataRepository personSpringDataRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// findById returns Optional<Person>
//		Optional<Person> person1 = personSpringDataRepository.findById(100007);
		// we can use findById().get()
		Person person1 = personSpringDataRepository.findById(100007).get();

		// in case of both update and insert we use save()
		// and under the hood it uses entityManager.merge()
		Person newPerson = new Person("Iniesta", "Spain", LocalDate.now());
		Person insertedPerson = personSpringDataRepository.save(newPerson);
		
		Person updatedPerson = new Person(100007, "CR7", "England", LocalDate.now());
		Person updatedPersonRet = personSpringDataRepository.save(updatedPerson);
		personSpringDataRepository.deleteById(100007); // returns nothing

		List<Person> persons = personSpringDataRepository.findAll();
		
		logger.info("person with id 100007 -> {}", person1);
		logger.info("inserting new person, inserted Person -> {}", insertedPerson);
		logger.info("updationg person with id 100007, effected rows -> {}", updatedPersonRet);
		logger.info("All persons -> {}", persons);

	}

}

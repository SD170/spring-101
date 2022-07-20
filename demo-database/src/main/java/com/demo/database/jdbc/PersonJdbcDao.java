package com.demo.database.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.database.entity.Person;

// this class talks to the database thus it's a: Repository
@Repository
public class PersonJdbcDao {

	// this is the connection to talk to the DB, spring can autowire it.
	@Autowired
	JdbcTemplate jdbcTemplate;

	// creating a custom row-mapper:
	// we can use: new BeanPropertyRowMapper<Person>(Person.class)
	// as the column name of the table and the field name of the entity was the
	// same.
	//
	// now if the structure of the table and the field names are not same, in that
	// case we can use our custom row-mapper:
	// we'll use a innerclass for this rowmapper as we'll not need a PersonRowMapper
	// outside PersonJdbcDao
	//
	// we implement an interface to create the rowmapper.
	class PersonRowMapper implements RowMapper<Person> {
		
		// the parames for this overridden methods are rs, and rowNum
		// rowNum is not that used
		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			// mapping from table cols to class fields.
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getDate("birth_date").toLocalDate());

			return person;
		}

	}

	// Person class needs to be created by us. So JAVA knows about the stucture of
	// Person table.
	public List<Person> findAll() {
		// we'll return the list of all person to do that we'll execute the query

		// the first param is the query string.

		// the second one is the result set.
		// the result set needs to be mapped properly with each row of the table to each
		// field of the entity.

		// as the name of the row (in the table) and the name of the
		// fields (in the entity) is same we can do that mapping easily by using
		// BeanPropertyRowMapper and pass the entity (Person) class as param.
		// also we cast the return to Person type using <Person>
		//
		// using BeanPropertyRowMapper
//		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
		// using custom row-mapper 
		return jdbcTemplate.query("select * from person", new PersonRowMapper());
	}

	public Person findById(int id) {

		// as a second parameter we pass the variables for the queries to be substituted
		// by the question mark (?)
		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));
		// for multiple parameters (and, or):
		// "select * from person where id=? and/or name=?"
	}

	public int deleteById(int id) {

		// for delete and update we use jdbcTemplate.update
		// update returns the number of rows it affected.
		// we don't need the rowmapper as it returns an int.
		return jdbcTemplate.update("delete from person where id=?", new Object[] { id });
	}

	public int insert(Person person) {

		return jdbcTemplate.update("insert into person (id, name, location, birth_date )" + "VALUES(?,?,?,?)",
				new Object[] { person.getId(), person.getName(), person.getLocation(), person.getBirthDate() });

		// convention is to write the jdbc queries in small-case

		// sql query:
		// INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
		// VALUES(100007, 'Cristiano Ronaldo', 'Portugal',CURRENT_TIMESTAMP());
	}

	public int update(Person person) {

		return jdbcTemplate.update("update person " + "set name = ?, location =?, birth_date=? " + "where id =?",
				new Object[] { person.getName(), person.getLocation(), person.getBirthDate(), person.getId() });
	}

}

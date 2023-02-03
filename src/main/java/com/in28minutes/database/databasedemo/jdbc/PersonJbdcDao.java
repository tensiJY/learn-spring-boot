package com.in28minutes.database.databasedemo.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.Person;

@Repository
public class PersonJbdcDao {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public List<Person> findAll(){
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append(" * ");
		sb.append("from ");
		sb.append(" person");
		return jdbc.query(sb.toString(), new BeanPropertyRowMapper<Person>(Person.class));
	}

}

package com.in28minutes.jpa.hibernate.demo.entity.single;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.entity.joined.Employee;

import jakarta.persistence.EntityManager;

//@Repository
//@Transactional
public class EmployeeRepository {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EntityManager em;
	
	public List<Employee> retrieveAllEmployees() {
		return em.createQuery("select e from Employee e", Employee.class).getResultList();
	}
	
	public void insert(Employee employee) {
		em.persist(employee);
	}
	
}

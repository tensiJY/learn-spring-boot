package com.in28minutes.jpa.hibernate.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.entity.Course;

import jakarta.persistence.EntityManager;


@Repository
@Transactional
public class CourseRepository {

	@Autowired
	private EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	public void deleteById(Long id) {
		Course selectedCourse = findById(id);
		em.remove(selectedCourse);
	}
	
	public Course save(Course course) {
		
		if(course.getId() == null) {
			
			em.persist(course);
			
		}else {
			
			em.merge(course);
		}
		
		return course;
	}
	
}

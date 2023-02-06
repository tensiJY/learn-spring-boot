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
	
	public void playWithEntityManager() {
		Course course1 = Course.builder().name("Web Services in 100 Steps 1").build();
		em.persist(course1);	
		
		Course course2 = Course.builder().name("Angular Js in 100 Steps 2").build();
		em.persist(course2);
		
		Course course3 = Course.builder().name("Node Js in 100 Steps 3").build();
		
		em.persist(course3);
		
		em.flush();
		

		course1.setName("Web Services in 100 Steps - Updated");
		course2.setName("Angular Js in 100 Steps - Updated");
		
		em.refresh(course1);
		
		em.flush();
		
		Course course4 = Course.builder().name("Vue Js in 100 Steps 4").build();
		em.persist(course4);
	}
	
}

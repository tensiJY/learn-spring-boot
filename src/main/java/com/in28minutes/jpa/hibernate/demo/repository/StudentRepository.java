package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Student;

import jakarta.persistence.EntityManager;


@Repository
@Transactional
public class StudentRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EntityManager em;
	
	public Student findById(Long id) {
		return em.find(Student.class, id);
	}
	
	public void deleteById(Long id) {
		Student selectedStudent = findById(id);
		em.remove(selectedStudent);
	}
	
	public Student save(Student Student) {
		
		if(Student.getId() == null) {
			
			em.persist(Student);
			
		}else {
			
			em.merge(Student);
		}
		
		return Student;
	}
	
	public void saveStudentWithPassport() {
		Passport passport = Passport.builder()
				.number("Z123456")
				.build();
		
		em.persist(passport);
		
		Student student = Student.builder()
				.name("Jane")
				.passport(passport)
				.build();
		
		em.persist(student);
	}
	
	public void someOperationToUnderstandPersistenceContext() {
		//Database Operation 1 - Retrieve student
		Student student = em.find(Student.class, 20001L);
		//Persistence Context (student)
		
		
		//Database Operation 2 - Retrieve passport
		Passport passport = student.getPassport();
		//Persistence Context (student, passport)

		//Database Operation 3 - update passport
		passport.setNumber("E123457");
		//Persistence Context (student, passport++)
		
		//Database Operation 4 - update student
		student.setName("Ranga - updated");
		//Persistence Context (student++ , passport++)
	}
	
	public void insertHardcodedStudentAndCourse(){
		Student student = Student.builder()
				.name("Jack")
				.build();	
		
		Course course = Course.builder()
				.name("Microservices in 100 Steps")
				.build();
		em.persist(student);
		em.persist(course);
		
		logger.info("student : {}", student);
		logger.info("course : {}", course);
		
		student.setCourses(Arrays.asList(course));
		course.setStudents(Arrays.asList(student));
		
		
		em.persist(student);
		em.persist(course);
	}
	
	public void insertStudentAndCourse(Student student, Course course){
		student.setCourses(Arrays.asList(course));
		course.setStudents(Arrays.asList(student));
		
		logger.info("student : {}", student);
		logger.info("course : {}", course);
		
		
		em.persist(student);
		em.persist(course);
	}
	
}

package com.in28minutes.jpa.hibernate.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Review;
import com.in28minutes.jpa.hibernate.demo.entity.Student;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//selectCourse();
		
		//deleteCourse();
		
		//saveCourse();
		
		//playWithEntityManager();
		
		//studentRepository.saveStudentWithPassport();
		
		//courseRepository.addHardcodedReviewsForCourse();
		
		/*
		courseRepository.addReviewsForCourse(10003L, 
				Arrays.asList(
						  Review.builder().rating("5").description("1").build()
						, Review.builder().rating("6").description("2").build()
						)
				);
		*/
		
		//studentRepository.insertHardcodedStudentAndCourse();
		studentRepository.insertStudentAndCourse(
				Student.builder()
						.name("jane")
						.build()
				, Course.builder()
					.name("Html/css Master step 100")
					.build()
				);
		
	}
	
	public void selectCourse() {
		Course selectedCourse = courseRepository.findById(10001L);
		logger.info("Course 10001 -> {}", selectedCourse);
	}
	
	public void deleteCourse() {
		courseRepository.deleteById(10001L);
	}
	
	public void saveCourse() {
		Course course = Course.builder()
				.name("New Data")
				.build();
		Course savedCourse = courseRepository.save(course);
		logger.info("savedCourse : {}", savedCourse);
		
	}
	
	public void playWithEntityManager() {
		courseRepository.playWithEntityManager();
	}

}

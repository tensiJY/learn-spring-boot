package com.in28minutes.jpa.hibernate.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//selectCourse();
		
		//deleteCourse();
		
		//saveCourse();
		
		playWithEntityManager();
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

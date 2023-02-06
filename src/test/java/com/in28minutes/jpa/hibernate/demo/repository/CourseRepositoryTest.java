package com.in28minutes.jpa.hibernate.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes=DemoApplication.class)
class CourseRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	@Test
	@DisplayName("findById 10002L")
	public void findById_basic() {
		Course course = repository.findById(10002L);
		logger.info("findById_basic {} : ", course);
		assertEquals("Spring in 50 Steps", course.getName());
	}
	
	//	@DirtiesContext
	//	테스트가 실행 된 후 다른 테스의 테이터가 변경되지 않도록 데이터를 재설정
	@Test
	@DirtiesContext	
	@DisplayName("deleteById 10002L")
	public void deleteById_basic() {
		
		repository.deleteById(10002L);
		Course course = repository.findById(10002L);
		logger.info("deleteById_basic : {}", course);
		assertNull(course);
	}
	
	@Test
	@DirtiesContext	
	@DisplayName("save 10002L")
	public void save_basic() {
		Long id = 10002L;
		String name = "JPA in 50 Steps - Updated";
		Course course = repository.findById(id);
		
		assertEquals("Spring in 50 Steps", course.getName());
		
		course.setName(name);
		
		Course updatedCourse = repository.save(course);
		logger.info("save_basic updatedCourse : {}", updatedCourse);
		
		Course selectedCourse = repository.findById(id);
		logger.info("save_basic selectedCourse : {}", selectedCourse);
		assertEquals(name, selectedCourse.getName());
		
	}
	
	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		repository.playWithEntityManager();
	}

}

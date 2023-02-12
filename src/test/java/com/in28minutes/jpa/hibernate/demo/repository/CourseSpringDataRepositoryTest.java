package com.in28minutes.jpa.hibernate.demo.repository;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;

// replaced @RunWith with @ExtendWith
// replaced SpringRunner.class with SpringExtension.class
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class CourseSpringDataRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseSpringDataRepository repository;
	
	@Test
	public void findById_CoursePresent() {
		Optional<Course> courseOptional = repository.findById(10001L);
		logger.info("findById_CoursePresent : {}", courseOptional.isPresent());
		assertTrue(courseOptional.isPresent());
	}

	@Test
	public void findById_CourseNotPresent() {
		Optional<Course> courseOptional = repository.findById(20001L);
		logger.info("findById_CourseNotPresent : {}", courseOptional.isPresent());
		assertFalse(courseOptional.isPresent());
	}
	
	@DisplayName("과목 상세 목록 조회")
	@Test
	@DirtiesContext
	public void findById() {
		Course course = Course.builder()
				.name("java")
				.build();
		
		Course savedCourse = repository.saveAndFlush(course);
		
		Course foundCourse = repository.findById(savedCourse.getId()).get();
		
		assertEquals(course.getName(), foundCourse.getName());
	}
	
	@Test
	public void playingAroundWithSpringDataRepository() {
		//Course course = new Course("Microservices in 100 Steps");
		//repository.save(course);

		//course.setName("Microservices in 100 Steps - Updated");
		//repository.save(course);
		logger.info("Courses -> {} ", repository.findAll());
		logger.info("Count -> {} ", repository.count());
	}
	
	@Test
	public void sort() {
		/*
		Sort sort = Sort.by(
			      Sort.Order.desc("time"),
			      Sort.Order.asc("id")
			    );
		*/
		Sort sort = Sort.by(
					Sort.Direction.DESC, "name"
				);
		logger.info("Sorted Courses -> {} ", repository.findAll(sort));
		
	}
	
	
	@Test
	public void pagination() {
		PageRequest pageRequest = PageRequest.of(0, 3);
		
		Page<Course> firstPage = repository.findAll(pageRequest);
		logger.info("First Page -> {} ", firstPage);
	}
	
	@Test
	public void q_method() {
		List<Course> selectedCourses = repository.findByNameContainingOrderByIdDesc("D");
		logger.info("{} : ", selectedCourses);
		
		List<Course> courses = repository.findByNameContaining("50");
		logger.info("{} : ", courses);
	}

}








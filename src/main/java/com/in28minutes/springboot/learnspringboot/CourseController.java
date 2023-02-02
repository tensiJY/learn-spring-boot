package com.in28minutes.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@GetMapping("/courses")
	public List<Course> retrieveAllCourses(){
		
		return Arrays.asList(
					new Course(1, "Learn AWS", "jyp"),
					new Course(2, "Learn DevOps", "jyp")
				);
	}
	                                
}

package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.in28minutes.jpa.hibernate.demo.entity.Course;

@RepositoryRestResource(path="courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long>{

	public List<Course> findByNameOrderByIdDesc(String name);


	public List<Course> findByNameContainingOrderByIdDesc(String string);
	
	List<Course> findByNameAndId(String name, Long id);

	List<Course> findByName(String name);

	List<Course> countByName(String name);

	List<Course> deleteByName(String name);

	//	jpql
	@Query("Select  c  From Course c where name like '%100 Steps'")
	List<Course> courseWith100StepsInName();

	//	nativeQuery
	@Query(value = "Select  *  From Course c where name like '%100 Steps'", nativeQuery = true)
	List<Course> courseWith100StepsInNameUsingNativeQuery();
	
	@Query(value = "select * from course c where name like %:name%", nativeQuery = true)
	List<Course> findByNameContaining(@Param(value="name")String name);

	//	namedQuery
	@Query(name = "query_get_100_Step_courses")
	List<Course> courseWith100StepsInNameUsingNamedQuery();

	
	
	
}

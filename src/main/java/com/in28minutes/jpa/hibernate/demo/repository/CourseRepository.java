package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.entity.Course;
import com.in28minutes.jpa.hibernate.demo.entity.Review;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
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

		if (course.getId() == null) {

			em.persist(course);

		} else {

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

		// em.flush();

		// Course course4 = Course.builder().name("Vue Js in 100 Steps 4").build();
		// em.persist(course4);
	}

	public void addHardcodedReviewsForCourse() {
		// get the course 10003
		Course course = findById(10003L);
		logger.info("course.getReviews() -> {}", course.getReviews());

		// add 2 reviews to it
		Review review1 = Review.builder().rating("5").description("Great Hands-on Stuff.").build();//new Review("5", "Great Hands-on Stuff.");
		Review review2 = Review.builder().rating("6").description("Hatsoff.").build();//new Review("5", "Hatsoff.");

		// setting the relationship
		course.addReview(review1);
		review1.setCourse(course);

		course.addReview(review2);
		review2.setCourse(course);

		// save it to the database
		em.persist(review1);
		em.persist(review2);

	}
	
	public void addReviewsForCourse(Long courseId, List<Review> reviews) {
		Course selectedCourse = findById(courseId);
		logger.info("course : {}", selectedCourse);
		//logger.info("reviews : {}", selectedCourse.getReviews());
		
		for(Review review : reviews) {
			selectedCourse.addReview(review);
			review.setCourse(selectedCourse);
			em.persist(review);
		}
		
	}
	
	

}

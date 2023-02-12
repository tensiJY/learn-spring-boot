package com.in28minutes.jpa.hibernate.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@NamedQueries(
			value= {
					  @NamedQuery(name = "query_get_all_courses", query = "Select  c  From Course c")
					, @NamedQuery(name = "query_get_100_Step_courses", query = "Select  c  From Course c where name like '%100 Steps'")
			}
		)
@Cacheable
public class Course {

	@Id
	@GeneratedValue
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//	null을 허용하지 않음
	//	따라서 데이터에 있는 모든 가능한 제약 제약 조건을 사용
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="last_updated_date")
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@Column(name="created_date")
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@OneToMany(mappedBy="course")
	private List<Review> reviews = new ArrayList();
	
	@ManyToMany(mappedBy="courses")
	@JsonIgnore
	private List<Student> students = new ArrayList();
	
	@Override
	public String toString() {
		return String.format(
				"Course(id=%s, name=%s, last_updated_date=%s, createdDate=%s)"
				, id, name, lastUpdatedDate, createdDate
				);
	}
	
	public void addReview(Review review) {
		this.reviews.add(review);
	}

	public void removeReview(Review review) {
		this.reviews.remove(review);
	}
	
	public void addStudent(Student student) {
		this.students.add(student);
	}
}

package com.in28minutes.jpa.hibernate.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="review")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString(exclude = {"course"})
public class Review {

	@Id
	@GeneratedValue
	private Long id;

	private String rating;

	private String description;
	
	@ManyToOne
	private Course course;
	
	/*
	@Override
	public String toString() {
		return String.format(
				"Review(id=%s, rating=%s, description=%s)"
				, id, rating, description);
	}
	*/
}
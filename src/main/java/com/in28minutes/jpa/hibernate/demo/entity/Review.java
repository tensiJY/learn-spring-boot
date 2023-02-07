package com.in28minutes.jpa.hibernate.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="review")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Review {

	@Id
	@GeneratedValue
	private Long id;

	private String rating;

	private String description;

}
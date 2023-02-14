package com.in28minutes.jpa.hibernate.demo.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Address {

	private String line1;
	private String line2;
	private String city;
	
}

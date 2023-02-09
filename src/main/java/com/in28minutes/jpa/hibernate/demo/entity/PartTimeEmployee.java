package com.in28minutes.jpa.hibernate.demo.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class PartTimeEmployee extends Employee{

	private BigDecimal hourlyWage;
	
	@Override
	public String toString() {
		return String.format("PartTimeEmployee(id=%s, name=%s, hourlyWage=%s)", getId(), getName(), hourlyWage);
	}
}

package com.in28minutes.jpa.hibernate.demo.entity.perclass;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@SuperBuilder
public class FullTimeEmployee extends Employee{

	private BigDecimal salary;
	
	@Override
	public String toString() {
		return String.format("FullTimeEmployee(id=%s, name=%s, salary=%s)", this.getId(), this.getName(), salary);
	}
}

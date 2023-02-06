package com.in28minutes.jpa.hibernate.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="course")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
}

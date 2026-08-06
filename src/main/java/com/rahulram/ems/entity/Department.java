package com.rahulram.ems.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "departments")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Department Name Must Not Be Blank")
	@Size(min = 1, max = 100, message = "Department Name Size Must be between 1 and 100 Characters")
	@Column(nullable = false)
	private String departmentName;

	@NotBlank(message = "Department Code Must Not Be Blank")
	@Size(min = 1, max = 10, message = "Department Code Size Must be between 1 and 10 Characters")
	@Column(nullable = false)
	private String departmentCode;

	@Size(max = 100)
	private String description;
}

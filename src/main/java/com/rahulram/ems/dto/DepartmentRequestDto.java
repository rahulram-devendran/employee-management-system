package com.rahulram.ems.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentRequestDto {
	@NotBlank(message = "Department Name Must Not Be Blank")
	@Size(min = 1, max = 100, message = "Department Name Size Must be between 1 and 100 Characters")
	private String departmentName;

	@NotBlank(message = "Department Code Must Not Be Blank")
	@Size(min = 1, max = 10, message = "Department Code Size Must be between 1 and 10 Characters")
	private String departmentCode;

	@Size(max = 100)
	private String description;
}

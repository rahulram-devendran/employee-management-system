package com.rahulram.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentResponseDto {
	private Long id;

	private String departmentName;

	private String departmentCode;

	private String description;
}

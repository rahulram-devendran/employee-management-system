package com.rahulram.ems.mapper;

import java.util.List;

import com.rahulram.ems.dto.DepartmentRequestDto;
import com.rahulram.ems.dto.DepartmentResponseDto;
import com.rahulram.ems.entity.Department;

public class DepartmentMapper {
	public static Department toEntity(DepartmentRequestDto dto) {
		Department department = Department.builder().departmentName(dto.getDepartmentName())
				.departmentCode(dto.getDepartmentCode()).description(dto.getDescription()).build();
		return department;
	}

	public static DepartmentResponseDto toResponseDto(Department department) {
		DepartmentResponseDto departmentResponseDto = DepartmentResponseDto.builder().id(department.getId())
				.departmentName(department.getDepartmentName()).departmentCode(department.getDepartmentCode())
				.description(department.getDescription()).build();

		return departmentResponseDto;
	}

	public static List<DepartmentResponseDto> toResponseList(List<Department> departments) {
		return departments.stream().map(DepartmentMapper::toResponseDto).toList();
	}
}

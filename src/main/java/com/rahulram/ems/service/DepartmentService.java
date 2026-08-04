package com.rahulram.ems.service;

import java.util.List;

import com.rahulram.ems.entity.Department;

public interface DepartmentService {
	Department createDepartment(Department department);

	Department getDepartment(Long id);

	List<Department> getAllDepartments();

	Department updateDepartment(Long id, Department department);

	void deleteDepartment(Long id);
}

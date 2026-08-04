package com.rahulram.ems.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rahulram.ems.entity.Department;
import com.rahulram.ems.repository.DepartmentRepository;
import com.rahulram.ems.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentRepository departmentRepository;

	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@Override
	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Department getDepartment(Long id) {
		Department existingDepartment = departmentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("No Department Found"));
		return existingDepartment;
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department updateDepartment(Long id, Department department) {
		Department existingDepartment = departmentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("NO Department found"));
		if (department.getDepartmentCode() != null && !department.getDepartmentCode().isBlank()) {
			existingDepartment.setDepartmentCode(department.getDepartmentCode());

		}
		if (department.getDepartmentName() != null && !department.getDepartmentName().isBlank()) {
			existingDepartment.setDepartmentName(department.getDepartmentName());

		}
		if (department.getDescription() != null && !department.getDescription().isBlank()) {
			existingDepartment.setDescription(department.getDescription());
		}

		return departmentRepository.save(existingDepartment);
	}

	@Override
	public void deleteDepartment(Long id) {
		Department existingdept = departmentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("No Dept Found"));
		System.out.println("Department " + existingdept.getDepartmentName() + " Deleted");
		departmentRepository.deleteById(id);
	}

}

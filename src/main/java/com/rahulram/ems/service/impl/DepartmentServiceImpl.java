package com.rahulram.ems.service.impl;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rahulram.ems.entity.Department;
import com.rahulram.ems.exception.DepartmentNotFoundException;
import com.rahulram.ems.repository.DepartmentRepository;
import com.rahulram.ems.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	private final DepartmentRepository departmentRepository;

	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@Override
	public Department createDepartment(Department department) {
		log.info("Department created");
		return departmentRepository.save(department);
	}

	@Override
	public Department getDepartmentById(Long id) {
		Department existingDepartment = departmentRepository.findById(id)
				.orElseThrow(() -> new DepartmentNotFoundException(id));
		return existingDepartment;
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department updateDepartment(Long id, Department department) {
		Department existingDepartment = departmentRepository.findById(id)
				.orElseThrow(() -> new DepartmentNotFoundException(id));
		if (department.getDepartmentCode() != null && !department.getDepartmentCode().isBlank()) {
			existingDepartment.setDepartmentCode(department.getDepartmentCode());

		}
		if (department.getDepartmentName() != null && !department.getDepartmentName().isBlank()) {
			existingDepartment.setDepartmentName(department.getDepartmentName());

		}
		if (department.getDescription() != null && !department.getDescription().isBlank()) {
			existingDepartment.setDescription(department.getDescription());
		}
		log.info("Department Updated");
		return departmentRepository.save(existingDepartment);
	}

	@Override
	public void deleteDepartment(Long id) {
		Department existingDepartment = departmentRepository.findById(id)
				.orElseThrow(() -> new DepartmentNotFoundException(id));
		log.info("Department '{}' deleted Successfully", existingDepartment.getDepartmentName());
		departmentRepository.deleteById(id);
	}

}

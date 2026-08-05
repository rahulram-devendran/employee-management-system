package com.rahulram.ems.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahulram.ems.entity.Department;
import com.rahulram.ems.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
	private final DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable("id") Long id) {
		return departmentService.getDepartmentById(id);
	}

	@GetMapping
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}

	@PatchMapping("/{id}")
	public Department updateDepartment(@PathVariable("id") Long id, @Valid @RequestBody Department department) {
		return departmentService.updateDepartment(id, department);
	}

	@PostMapping
	public Department createDepartment(@Valid @RequestBody Department department) {
		return departmentService.createDepartment(department);
	}

	@DeleteMapping("/{id}")
	public String deleteDepartment(@PathVariable("id") Long id) {
		departmentService.deleteDepartment(id);
		return "Department Deleted";
	}

}

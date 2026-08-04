package com.rahulram.ems.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahulram.ems.entity.Department;
import com.rahulram.ems.service.DepartmentService;

@RestController
@RequestMapping("/api/v1")
public class DepartmentController {
	private final DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@GetMapping("/getDept/{id}")
	public Department findDept(@PathVariable("id") Long id) {
		return departmentService.getDepartment(id);
	}

	@GetMapping("/getAllDept")
	public List<Department> getAllDept() {
		return departmentService.getAllDepartments();
	}

	@PatchMapping("/updateDept/{id}")
	public Department updateDept(@PathVariable("id") Long id, Department department) {
		return departmentService.updateDepartment(id, department);
	}

	@DeleteMapping("/deletedept/{id}")
	public String deleteDept(@PathVariable("id") Long id) {
		departmentService.deleteDepartment(id);
		return "Department Deleted";
	}

	@PostMapping("/createDept")
	public Department createDept(Department department) {
		return departmentService.createDepartment(department);
	}

}

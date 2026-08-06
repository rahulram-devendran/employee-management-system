package com.rahulram.ems.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahulram.ems.dto.DepartmentRequestDto;
import com.rahulram.ems.dto.DepartmentResponseDto;
import com.rahulram.ems.entity.Department;
import com.rahulram.ems.mapper.DepartmentMapper;
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
	public ResponseEntity<DepartmentResponseDto> getDepartmentById(@PathVariable("id") Long id) {
		Department department = departmentService.getDepartmentById(id);
		return ResponseEntity.ok(DepartmentMapper.toResponseDto(department));
	}

	@GetMapping
	public ResponseEntity<List<DepartmentResponseDto>> getAllDepartments() {
		return ResponseEntity.ok(DepartmentMapper.toResponseList(departmentService.getAllDepartments()));
	}

	@PatchMapping("/{id}")
	public ResponseEntity<DepartmentResponseDto> updateDepartment(@PathVariable("id") Long id,
			@Valid @RequestBody DepartmentRequestDto requestDto) {
		Department department = DepartmentMapper.toEntity(requestDto);
		Department updatedDepartment = departmentService.updateDepartment(id, department);
		return ResponseEntity.ok(DepartmentMapper.toResponseDto(updatedDepartment));
	}

	@PostMapping
	public ResponseEntity<DepartmentResponseDto> createDepartment(@Valid @RequestBody DepartmentRequestDto requestDto) {
		Department department = DepartmentMapper.toEntity(requestDto);
		Department savedDepartment = departmentService.createDepartment(department);
		return ResponseEntity.status(HttpStatus.CREATED).body(DepartmentMapper.toResponseDto(savedDepartment));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable("id") Long id) {
		departmentService.deleteDepartment(id);
		return ResponseEntity.noContent().build();
	}

}

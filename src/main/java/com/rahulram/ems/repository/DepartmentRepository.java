package com.rahulram.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahulram.ems.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}

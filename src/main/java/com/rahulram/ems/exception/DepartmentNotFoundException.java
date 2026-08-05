package com.rahulram.ems.exception;

public class DepartmentNotFoundException extends RuntimeException {
	public DepartmentNotFoundException(Long id) {
		super("Department Not Found for this id : " + id);
	}
}

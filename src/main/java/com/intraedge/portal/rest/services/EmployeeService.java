package com.intraedge.portal.rest.services;

import java.util.List;

import com.intraedge.portal.rest.dto.EmployeeDto;

public interface EmployeeService {
	public int save(EmployeeDto employeeDto);
	public EmployeeDto findById(int id);
	public List<EmployeeDto> findAll();
	public int update(EmployeeDto employeeDto);
	public void delete(EmployeeDto employeeDto);
	void deleteById(int id);
}

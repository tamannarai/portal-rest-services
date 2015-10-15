package com.intraedge.portal.rest.services;

import java.util.List;

import com.intraedge.portal.rest.dto.DepartmentDto;

public interface DepartmentService {

	public DepartmentDto findById(int id);
	public List<DepartmentDto> findAll();
	public int update(DepartmentDto departmentDto);
	public void delete(DepartmentDto departmentDto);
	public void deleteById(int id);
	public int save(DepartmentDto department);

}

package com.intraedge.portal.rest.dao;

import java.util.List;

import com.intraedge.portal.rest.entity.EmployeeEntity;

public interface EmployeeDao {
	
	public int save(EmployeeEntity employeeEntity);
	public EmployeeEntity findById(int id);
	public List<EmployeeEntity> findAll();
	public int update(EmployeeEntity employeeEntity);
	public void deleteById(int id);
	public void delete(EmployeeEntity employeeEntity);
}

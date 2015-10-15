package com.intraedge.portal.rest.dao;

import java.util.List;

import com.intraedge.portal.rest.entity.DepartmentEntity;

public interface DepartmentDao {

	public int save(DepartmentEntity departmentEntity);
	public DepartmentEntity findById(int id);
	public List<DepartmentEntity> findAll();
	public int update(DepartmentEntity departmentEntity);
	public void delete(DepartmentEntity departmentEntity);
	public void deleteById(int id);
}

package com.intraedge.portal.rest.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.intraedge.portal.rest.dao.DepartmentDao;
import com.intraedge.portal.rest.dto.DepartmentDto;
import com.intraedge.portal.rest.dto.builder.DtoToEntityBuilder;
import com.intraedge.portal.rest.dto.builder.EntityToDtoBuilder;
import com.intraedge.portal.rest.entity.DepartmentEntity;
import com.intraedge.portal.rest.services.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentDao departmentDao;
	
	@Override
	@Transactional(readOnly=true)
	public DepartmentDto findById(int id) {
		DepartmentEntity entity = departmentDao.findById(id);
		return (DepartmentDto)EntityToDtoBuilder.build(entity);
	}

	@Override
	@Transactional(readOnly=true)
	public List<DepartmentDto> findAll() {		
		List<DepartmentDto> dtos = new ArrayList<DepartmentDto>();
		List<DepartmentEntity> entities = departmentDao.findAll();
		for(DepartmentEntity entity: entities){
			dtos.add((DepartmentDto)EntityToDtoBuilder.build(entity));
		}
		return dtos;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int update(DepartmentDto departmentDto) {
		DepartmentEntity entity = (DepartmentEntity)DtoToEntityBuilder.build(departmentDto);
		return departmentDao.update(entity);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(DepartmentDto departmentDto) {
		DepartmentEntity entity = (DepartmentEntity)DtoToEntityBuilder.build(departmentDto);
		departmentDao.delete(entity);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteById(int id) {
		departmentDao.deleteById(id);
		System.out.println("Successfully Deleted"); 
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int save(DepartmentDto departmentDto) {
		DepartmentEntity entity = (DepartmentEntity)DtoToEntityBuilder.build(departmentDto);
		return departmentDao.save(entity);
	}

}

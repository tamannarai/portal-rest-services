package com.intraedge.portal.rest.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intraedge.portal.rest.dao.EmployeeDao;
import com.intraedge.portal.rest.dto.builder.EntityToDtoBuilder;
import com.intraedge.portal.rest.entity.AuditEntity;
import com.intraedge.portal.rest.entity.EmployeeEntity;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	EntityToDtoBuilder entityToDtoBuilder = new EntityToDtoBuilder();
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int save(EmployeeEntity employeeEntity) {
		Session session = sessionFactory.openSession();
		AuditEntity auditEntity = new AuditEntity();
		auditEntity.setCreatedBy("System");
		auditEntity.setCreatedDate(new Date());
		employeeEntity.setAuditEntity(auditEntity);
		if(employeeEntity.getDepartment() != null){
			employeeEntity.getDepartment().setAuditEntity(auditEntity);
		}
		session.save(employeeEntity);
		
		
		return employeeEntity.getId();
	}

	@Override
	public EmployeeEntity findById(int id) {
		Session session = sessionFactory.openSession();
		EmployeeEntity employeeEntity=(EmployeeEntity)session.get(EmployeeEntity.class, id);
		return employeeEntity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeEntity> findAll() {
		Session session=sessionFactory.openSession();
		Query query=(Query)session.createQuery("from EmployeeEntity");
		List<EmployeeEntity> empEntityList=(List<EmployeeEntity>)query.list();
		return empEntityList;
	}

	@Override
	public int update(EmployeeEntity employeeEntity) {
		Session session=sessionFactory.openSession();
		AuditEntity auditEntity = new AuditEntity();
		auditEntity.setUpdatedBy("System");
		auditEntity.setUpdatedDate(new Date());
		employeeEntity.setAuditEntity(auditEntity);
		session.merge(employeeEntity);
		return employeeEntity.getId();
	}

	@Override
	public void deleteById(int id) {
		Session session=sessionFactory.openSession();
		EmployeeEntity employeeEntity = (EmployeeEntity) session.get(EmployeeEntity.class, id);
		session.delete(employeeEntity);
		session.flush();
	}
	
	@Override
	public void delete(EmployeeEntity employeeEntity){
		Session session=sessionFactory.openSession();
		session.delete(employeeEntity);
		session.flush();
	}

}

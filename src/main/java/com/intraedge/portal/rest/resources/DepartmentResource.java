package com.intraedge.portal.rest.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intraedge.portal.rest.dto.DepartmentDto;
import com.intraedge.portal.rest.services.DepartmentService;

@Component
@Path("/departments")
public class DepartmentResource {
	
	@Autowired 
	DepartmentService departmentService;
	@Context
	UriInfo uriInfo;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getDepartments(){
		List<DepartmentDto> departmentsList = (List<DepartmentDto>) departmentService.findAll();
		return Response.status(200).entity(new GenericEntity<List<DepartmentDto>>(departmentsList) {}).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getDepartmentById(@PathParam("id")int id){
		DepartmentDto departemnt=departmentService.findById(id);
		return Response.ok(departemnt).build();
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response addDepartment(DepartmentDto departmentDto){
		int createdId = departmentService.save(departmentDto);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(createdId));
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response updateDepartment(DepartmentDto departmentDto){
		departmentService.update(departmentDto);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response deleteDepartment(@PathParam("id")int id){
		departmentService.deleteById(id);
		return Response.ok().build();
	}
	
}

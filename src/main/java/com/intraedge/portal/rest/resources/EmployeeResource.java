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

import com.intraedge.portal.rest.dto.EmployeeDto;
import com.intraedge.portal.rest.services.EmployeeService;

@Component
@Path("/employees")
public class EmployeeResource {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Context
	UriInfo uriInfo;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getEmployees(){
		List<EmployeeDto> employees=employeeService.findAll();
		return Response.ok().entity(new GenericEntity<List<EmployeeDto>>(employees) {}).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getEmployeeById(@PathParam("id")int id){
		EmployeeDto employeeDto=employeeService.findById(id);
		if(employeeDto == null){
			return Response.noContent().entity("No Empoyee found").build();
		}
		return Response.ok().entity(employeeDto).build();
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response addEmployee(EmployeeDto employeeDto){
		int createdId = employeeService.save(employeeDto);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(createdId));
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response updateEmployee(EmployeeDto employeeDto){
		employeeService.update(employeeDto);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response deleteEmployee(@PathParam("id")int id){
		employeeService.deleteById(id);
		return Response.ok().build();
	}
}

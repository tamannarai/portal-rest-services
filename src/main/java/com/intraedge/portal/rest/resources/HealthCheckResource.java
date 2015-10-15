package com.intraedge.portal.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/healthcheck")
public class HealthCheckResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getResponse(){
		return "Success 200";
	}
}

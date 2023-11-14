package com.apaulino.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.apaulino.model.University;

@Path("/universities")
@RegisterRestClient(configKey = "university-api")
public interface UniversityService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<University> list();

}

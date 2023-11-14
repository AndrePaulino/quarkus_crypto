package com.apaulino.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.apaulino.model.University;
import com.apaulino.service.UniversityService;

@Path("/universities")
public class UniversityResource {

	@Inject
	@RestClient
	UniversityService universityService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<University> list() {
		return universityService.list();
	}
}

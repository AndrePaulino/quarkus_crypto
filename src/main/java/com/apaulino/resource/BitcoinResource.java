package com.apaulino.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.apaulino.model.Bitcoin;
import com.apaulino.service.BitcoinService;

@Path("/bitcoins")
public class BitcoinResource {

	@Inject
	@RestClient
	BitcoinService bitcoinService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bitcoin> listar() {
		return bitcoinService.listar();
	}
}

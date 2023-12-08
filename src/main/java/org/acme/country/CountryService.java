package org.acme.country;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("/v3.1")
@RegisterRestClient(configKey = "rest-countries")
@ApplicationScoped
public interface CountryService {
  @GET
  @Produces("application/json")
  @Path("/name/{name}")
  List<Country> getByName(@PathParam("name") String name);
}

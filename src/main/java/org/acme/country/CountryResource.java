package org.acme.country;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/country")
public class CountryResource {
  private final CountryService countryService;

  public CountryResource(@RestClient CountryService countryService) {
    this.countryService = countryService;
  }

  @GET
  @Path("/name/{name}")
  public List<Country> getByName(@PathParam("name") String name) {
    return countryService.getByName(name);
  }
}

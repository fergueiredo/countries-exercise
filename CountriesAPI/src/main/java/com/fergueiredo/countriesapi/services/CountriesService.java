package com.fergueiredo.countriesapi.services;

import com.fergueiredo.countriesapi.models.Country;
import com.fergueiredo.countriesapi.repositories.CountriesRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/countries")
public class CountriesService {
    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Country> getAllCountries() {
        CountriesRepository countriesRepository = new CountriesRepository();

        return countriesRepository.getAllCountries();
    }

    @GET
    @Path("/{code}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCountryByCode(@PathParam("code") String code) {
        CountriesRepository countriesRepository = new CountriesRepository();
        Country country = countriesRepository.getCountryByCode(code);

        if (country.getCode().isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK).entity(country).build();
    }
}

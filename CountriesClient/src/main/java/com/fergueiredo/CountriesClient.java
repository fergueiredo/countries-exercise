package com.fergueiredo;

import com.fergueiredo.model.Country;
import org.jboss.resteasy.plugins.providers.jackson.ResteasyJacksonProvider;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class CountriesClient {
    public void execute(String[] args) {
        if (args.length == 0) {
            getAllCountries();
            return;
        }
        if (args.length == 1) {
            getCountry(args[0]);
            return;
        }

        throw new RuntimeException("Invalid arguments.");
    }

    private void getCountry(String code) {
        Country country = consume("http://localhost:8080/countriesapi/api/countries/" + code, Country.class);
        System.out.println(country);
    }

    private void getAllCountries() {
        Country[] countries = consume("http://localhost:8080/countriesapi/api/countries/", Country[].class);
        for (Country country : countries) {
            System.out.println(country);
        }
    }

    private <T> T consume(String url, Class<T> responseClass) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        target.register(ResteasyJacksonProvider.class);
        Response response = target.request().get();

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed: " + response.getStatus());
        }

        return response.readEntity(responseClass);
    }
}

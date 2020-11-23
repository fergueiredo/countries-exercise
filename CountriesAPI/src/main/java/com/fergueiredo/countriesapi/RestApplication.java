package com.fergueiredo.countriesapi;

import com.fergueiredo.countriesapi.services.CountriesService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class RestApplication extends Application {
    private Set<Object> singletons = new HashSet<Object>();

    public RestApplication() {
        singletons.add(new CountriesService());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
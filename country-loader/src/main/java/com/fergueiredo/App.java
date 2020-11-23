package com.fergueiredo;

import com.fergueiredo.countryloader.CountryLoader;

public class App 
{
    public static void main( String[] args )
    {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        propertiesLoader.load();

        CountryLoader loader = new CountryLoader(args);
        loader.start();
    }
}

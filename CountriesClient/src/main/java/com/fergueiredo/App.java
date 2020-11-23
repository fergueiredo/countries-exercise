package com.fergueiredo;

public class App
{
    public static void main( String[] args )
    {

        CountriesClient client = new CountriesClient();
        client.execute(args);
    }
}

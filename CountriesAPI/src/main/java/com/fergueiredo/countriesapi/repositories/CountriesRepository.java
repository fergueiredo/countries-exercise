package com.fergueiredo.countriesapi.repositories;

import com.fergueiredo.countriesapi.models.Country;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class CountriesRepository {
    public List<Country> getAllCountries() {
        List<Country> countries = new ArrayList<>();

        try(MongoClient client = new MongoClient("localhost", 27017)) {
            MongoDatabase db = client.getDatabase("countries-api");
            MongoCollection<Document> countriesCollection = db.getCollection("countries");

            FindIterable<Document> resultset = countriesCollection.find();

            for (Document result : resultset) {
                Country country = new Country(result);
                countries.add(country);
            }
        }
        return countries;
    }

    public Country getCountryByCode(String code) {

        try (MongoClient client = new MongoClient("localhost", 27017)) {
            MongoDatabase db = client.getDatabase("countries-api");
            MongoCollection<Document> countriesCollection = db.getCollection("countries");

            Document result = countriesCollection.find(new Document("code", code)).first();

            return new Country(result);
        }

    }
}

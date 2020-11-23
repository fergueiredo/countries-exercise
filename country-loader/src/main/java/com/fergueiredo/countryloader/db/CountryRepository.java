package com.fergueiredo.countryloader.db;

import com.fergueiredo.countryloader.Country;
import com.mongodb.MongoClient;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

public class CountryRepository extends DBConnector {

    private final String database;
    private final String collection;

    private MongoCollection<Document> countriesCollection;

    public CountryRepository() {
        super();
        database = System.getProperty("db.database");
        collection = System.getProperty("db.collection.countries");
    }

    public void insert(Country country) {
        try (MongoClient mongoClient = getClient()) {
            MongoDatabase db = mongoClient.getDatabase(database);
            countriesCollection = db.getCollection(collection);

            CountryDocumentFactory cdFactory = new CountryDocumentFactory();
            Document newCountry = cdFactory.create(country);
            Bson filter = Filters.eq("code", country.getCode());

            if (countryAlreadyExists(filter)) {
                updateCountry(newCountry, filter);
            } else {
                insertNewCountry(newCountry);
            }
        }
    }

    private void insertNewCountry(Document newCountry) {
        countriesCollection.insertOne(newCountry);
    }

    private void updateCountry(Document newCountry, Bson filter) {
        Document updateData = new Document();
        updateData.append("$set", newCountry);

        countriesCollection.updateOne(filter, updateData);
    }

    private boolean countryAlreadyExists(Bson filter) {
        MongoCursor<Document> result = countriesCollection.find(filter).iterator();

        return result.hasNext();
    }
}

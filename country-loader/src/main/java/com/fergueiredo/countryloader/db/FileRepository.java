package com.fergueiredo.countryloader.db;

import com.fergueiredo.countryloader.Country;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.io.File;

public class FileRepository extends DBConnector {
    private final String database;
    private final String collection;

    private MongoCollection<Document> filesCollection;

    public FileRepository() {
        super();
        database = System.getProperty("db.database");
        collection = System.getProperty("db.collection.files");
    }

    public boolean fileAlreadyExists(File file) {
        try (MongoClient mongoClient = getClient()) {
            MongoDatabase db = mongoClient.getDatabase(database);
            filesCollection = db.getCollection(collection);

            Bson filter = Filters.and(Filters.eq("hash", file.hashCode()), Filters.eq("lastMod", file.lastModified()));

            MongoCursor<Document> result = filesCollection.find(filter).iterator();

            return result.hasNext();
        }
    }

    public void insert(File file) {
        try (MongoClient mongoClient = getClient()) {
            MongoDatabase db = mongoClient.getDatabase(database);
            filesCollection = db.getCollection(collection);

            Document fileDocument = new Document();
            fileDocument.append("hash", file.hashCode());
            fileDocument.append("lastMod", file.lastModified());


            filesCollection.insertOne(fileDocument);
        }

    }

}

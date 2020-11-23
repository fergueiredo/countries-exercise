package com.fergueiredo.countryloader.db;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class DBConnector {
    private final String host;
    private final Integer port;

    public DBConnector() {
        host = System.getProperty("db.host");
        port = Integer.parseInt(System.getProperty("db.port"));
    }

    public MongoClient getClient() {
        return new MongoClient(host, port);
    }

}

package org.example;

import java.util.List;

import com.mongodb.client.http.MongoClient;
import com.mongodb.client.http.MongoCollection;
import com.mongodb.client.http.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.diagnostics.Logger;
import org.bson.diagnostics.Loggers;

import com.mongodb.MongoException;
import com.mongodb.client.model.Updates;

import static com.mongodb.client.model.Filters.*;

public class Main {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase database = mongoClient.getDatabase("starwardb");
        System.out.println("database: " + database);
        MongoCollection<Document> collection = database.getCollection("humans");
        System.out.println("collection: " + collection);
        Document doc = collection.find(
                and(
                        eq("_id", "50006"),
                        eq("homePlanet", "Liberia")))
                .first();
        System.out.println("doc: " + doc);
        System.out.println("doc.toString(): " + doc.toString());
        System.out.println("doc.toJson(): " + doc.toJson());

    }
}
package mongoDAO;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;

public class MongoDBConfig {
    private static MongoCollection collection;

    public static MongoCollection getCollection() {
        if (collection == null) {
            MongoClient mongoClient = MongoClients.create("mongodb://root:Sandia4you@localhost:27017");
            return mongoClient.getDatabase("aeropuerto").getCollection("aero-data");
        }
        return collection;
    }
}

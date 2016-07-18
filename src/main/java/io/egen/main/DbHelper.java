package io.egen.main;

import com.mongodb.DB;

import com.mongodb.MongoClient;

public class DbHelper {
	private DB db;

	/* Method contains port and mongodb client configuration */
	@SuppressWarnings("resource")
	public DB dbConfig() {
		MongoClient mongoClient = new MongoClient("localhost", 27017);

		db = mongoClient.getDB("egenUserMgmt");

		return db;
	}

}

package io.egen.main;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import io.egen.controller.UserController;
import io.egen.service.UserServiceImpl;

public class Main {

	static MongoClient mongoClient = null;

	public static void main(String[] args) {
		/*
		 * Creating an instance of our UserService and passing it on to newly
		 * created UserController
		 */
		try {
			DbHelper objDb = new DbHelper();
			DB db = objDb.dbConfig();

			new UserController(new UserServiceImpl(db));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

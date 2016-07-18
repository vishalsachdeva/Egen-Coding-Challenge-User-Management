package io.egen.service;

import java.util.HashSet;
import java.util.LinkedHashSet;

import org.bson.types.ObjectId;

import com.google.gson.Gson;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import io.egen.entity.User;

import io.egen.repository.UserRepository;

public class UserServiceImpl implements UserService {
	private final DB db;
	private final DBCollection dbCollection;

	public UserServiceImpl(DB db) {
		this.db = db;
		this.dbCollection = db.getCollection("user");
	}

	/* To GET all the users in database */
	public HashSet<User> findAllUsers() {
		HashSet<User> userHashSet = new LinkedHashSet<User>();
		DBCursor dbCursor = dbCollection.find();
		while (dbCursor.hasNext()) {
			DBObject dbObject = dbCursor.next();
			userHashSet.add(new User((BasicDBObject) dbObject));
		}
		return userHashSet;

	}

	/* Implementation to create a user */
	public User createUser(String body) {
		User objUser = new Gson().fromJson(body, User.class);
		BasicDBObject dbObject = new BasicDBObject();
		dbObject.put("email", objUser.getEmail());

		DBCursor dbCursor = dbCollection.find(dbObject);

		if (!dbCursor.hasNext()) {
			BasicDBObject updateResult = UserRepository.createDB(objUser);
			dbCollection.insert(updateResult);
			return cursorFind(dbObject);

		} else {

			return null;
		}
	}

	/* To update specific the users in database */
	public User updateUser(String body) {
		User objUser = new Gson().fromJson(body, User.class);

		BasicDBObject dbObject = new BasicDBObject();
		try {
			dbObject.put("_id", new ObjectId(objUser.getId()));
		} catch (IllegalArgumentException e) {
			return null;
		}
		DBCursor dbCursor = dbCollection.find(dbObject);
		if (dbCursor.hasNext()) {
			BasicDBObject dbObject1 = new BasicDBObject("_id", new ObjectId(objUser.getId()));

			BasicDBObject updateResult = UserRepository.createDB(objUser);

			dbCollection.update(dbObject1, updateResult);

			return cursorFind(dbObject1);

		} else {
			return null;
		}

	}

	/* Cursor Find Function */
	public User cursorFind(BasicDBObject dbObject) {
		DBCursor cursor1 = dbCollection.find(dbObject);
		if (cursor1.hasNext()) {
			return new User((BasicDBObject) cursor1.next());
		} else {
			return null;
		}
	}

}

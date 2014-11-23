package com.tutu.clouderp.repository;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.tutu.clouderp.Entity.User;

public class AuthDao {

	private static String mongodburi = "mongodb://127.0.0.1:27017";
	private static MongoClientURI mongoClientURI = null;
	private static MongoClient mongoClient = null;
	private static DB db = null;
	private static DBCollection coll = null;
	private static String _dbName = "auth";
	private static String _collName = "user";
	static {
		mongoClientURI = new MongoClientURI(mongodburi);
		try {
			mongoClient = new MongoClient(mongoClientURI);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		db = mongoClient.getDB(_dbName);
		coll = db.getCollection(_collName);
		// coll.setReadPreference(ReadPreference.secondaryPreferred());
		// coll.setWriteConcern(new WriteConcern(1));
	}

	public static User getUser(String name) {
		BasicDBObject query = new BasicDBObject("name", name);
		DBCursor cursor = coll.find(query);
		User user =null;
		try {
			while (cursor.hasNext()) {
				DBObject dbObject = cursor.next();
				user = User.getMMFromDBObject(dbObject);
				break;
			}
		} finally {
			cursor.close();
		}
		return user;
	}

}

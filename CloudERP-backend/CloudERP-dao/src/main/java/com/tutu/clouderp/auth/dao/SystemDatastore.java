package com.tutu.clouderp.auth.dao;

import org.mongodb.morphia.DatastoreImpl;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
public class SystemDatastore extends DatastoreImpl {

	public SystemDatastore(Morphia morphia, MongoClient mongoClient, String dbName) {
		super(morphia, mongoClient, dbName);
	}
}

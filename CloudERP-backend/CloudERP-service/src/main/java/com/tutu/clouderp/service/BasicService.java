package com.tutu.clouderp.service;

import org.mongodb.morphia.Datastore;

import com.mongodb.DBCollection;
import com.tutu.clouderp.context.ContextHolder;

public class BasicService {
	public Datastore getDataStore(){
		return ContextHolder.getContext().getDatastore();
	}
	
	public DBCollection getCollection(String collName){
		return getDataStore().getDB().getCollection(collName);
	}
}

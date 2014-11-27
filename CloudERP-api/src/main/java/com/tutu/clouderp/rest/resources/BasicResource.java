package com.tutu.clouderp.rest.resources;

import org.mongodb.morphia.Datastore;

import com.mongodb.DBCollection;
import com.tutu.clouderp.context.ContextHolder;

public class BasicResource {
	public Datastore getDataStore(){
		return ContextHolder.getContext().getDatastore();
	}
	
	public DBCollection getCollection(String collName){
		return getDataStore().getDB().getCollection(collName);
	}
}

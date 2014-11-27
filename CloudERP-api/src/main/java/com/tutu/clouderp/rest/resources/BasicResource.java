package com.tutu.clouderp.rest.resources;

import org.mongodb.morphia.Datastore;

import com.tutu.clouderp.context.ContextHolder;

public class BasicResource {
	public Datastore getDataStore(){
		return ContextHolder.getContext().getDatastore();
	}
}

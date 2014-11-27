package com.tutu.clouderp.context;

import java.net.UnknownHostException;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.tutu.clouderp.auth.entity.MM;
import com.tutu.clouderp.auth.entity.User;

public class Context {
	private User user;
	private Datastore datastore;

	public User getUser() {
		return user;
	}

	public void setUser(User user) throws UnknownHostException {
		this.user = user;
		setDatastore();
	}

	public Datastore getDatastore() {
		return datastore;
	}

	private void setDatastore() throws UnknownHostException {
		MM mm = this.user.getTenant().getMm();
		MongoClient mongo = new MongoClient(mm.getHostip(), mm.getPort());
		datastore = new Morphia().createDatastore(mongo, user.getTenant().getDbname());
	}

}

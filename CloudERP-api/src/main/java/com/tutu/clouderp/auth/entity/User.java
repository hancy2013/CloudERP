package com.tutu.clouderp.auth.entity;

import java.util.HashSet;
import java.util.Set;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="user")
@Entity("user")
public class User{

	@Id
	private ObjectId id;

	private String name;

	private String password;
	
	private String moid;
	private Set<String> roles = new HashSet<String>();

	protected User() {
		/* Reflection instantiation */
	}

	public User(String name, String passwordHash) {
		this.name = name;
		this.password = passwordHash;
	}

	public ObjectId getId() {
		return this.id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

	public void addRole(String role) {
		this.roles.add(role);
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
//	public static User getMMFromDBObject(DBObject dbObject) {
//		User user = new User();
//		user.setId(dbObject.get("_id").toString());
//		user.setName((String) dbObject.get("name"));
//		user.setPassword((String) dbObject.get("password"));
//		Set<String> roles=new HashSet<String>();
//		roles.add("admin");
//		user.setRoles(roles);
//		return user;
//	}

	public String getMoid() {
		return moid;
	}

	public void setMoid(String moid) {
		this.moid = moid;
	}
}
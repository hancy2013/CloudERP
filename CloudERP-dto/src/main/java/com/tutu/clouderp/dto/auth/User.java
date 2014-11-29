package com.tutu.clouderp.dto.auth;

import java.util.HashSet;
import java.util.Set;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import com.tutu.clouderp.dto.Org;
@Entity("user")
public class User{

	@Id
	private String name;
	private String password;
	@Reference
	private Tenant tenant;
	@Reference
	private Org org;
	private Set<String> roles = new HashSet<String>();

	protected User() {
	}

	public User(String name, String passwordHash) {
		this.name = name;
		this.password = passwordHash;
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

	public Org getOrg() {
		return org;
	}

	public void setOrg(Org org) {
		this.org = org;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}
	
}
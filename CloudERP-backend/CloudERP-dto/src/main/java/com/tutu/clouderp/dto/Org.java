package com.tutu.clouderp.dto;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;
@Entity("org")
public class Org {
	@Id
	private String id;
	@Reference(value="pid",idOnly=true)
	private Org parentOrg;
	private String name;
	public Org(){
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Org getParentOrg() {
		return parentOrg;
	}
	public void setParentOrg(Org parentOrg) {
		this.parentOrg = parentOrg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

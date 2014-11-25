package com.tutu.clouderp.auth.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.springframework.data.mongodb.core.mapping.Document;



/**
 * ��֯��
 * 
 * @Title MO.java
 * @Package com.passionguy.force.dto
 * @Description 
 * @author tutu
 * @date 2014-11-20
 */
@Document(collection="org")
@Entity("org")
public class Org {
	@Id
	private ObjectId id;
	private String name;
	private String mmid;
	private String dbid;
	private String adminemail;
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMmid() {
		return mmid;
	}

	public void setMmid(String mmid) {
		this.mmid = mmid;
	}

	public String getDbid() {
		return dbid;
	}

	public void setDbid(String dbid) {
		this.dbid = dbid;
	}
	
	public String getAdminemail() {
		return adminemail;
	}

	public void setAdminemail(String adminemail) {
		this.adminemail = adminemail;
	}
	
}

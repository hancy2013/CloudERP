package com.tutu.clouderp.dto.auth;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

/**
 * 租户
 * 
 * @Title MO.java
 * @Package com.passionguy.force.dto
 * @Description 
 * @author tutu
 * @date 2014-11-20
 */
@Entity("tenant")
public class Tenant {
	@Id
	private String name;
	@Reference
	private MM mm;
	private String dbname;
	private String email;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MM getMm() {
		return mm;
	}

	public void setMm(MM mm) {
		this.mm = mm;
	}

	public String getDbname() {
		return dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

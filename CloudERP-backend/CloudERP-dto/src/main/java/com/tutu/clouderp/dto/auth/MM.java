package com.tutu.clouderp.dto.auth;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;


/**
 * mongodb数据库
 * 
 * @Title MM.java
 * @Package com.passionguy.force.dto
 * @Description
 * @author tutu
 * @date 2014-11-20
 */
@Entity("mm")
public class MM {
	@Id
	private ObjectId id;
	private String hostip;
	private int port;
	private int weight;

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getHostip() {
		return hostip;
	}

	public void setHostip(String hostip) {
		this.hostip = hostip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}

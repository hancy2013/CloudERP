package com.tutu.clouderp.Entity;

import org.springframework.data.mongodb.core.mapping.Document;


/**
 * mongodb��������Դ��meta machine ���mm
 * 
 * @Title MM.java
 * @Package com.passionguy.force.dto
 * @Description
 * @author tutu
 * @date 2014-11-20
 */
@Document(collection="mm")
public class MM {
	private String id;
	private String hostip;
	private int port;
	private String username;
	private String password;
	private int weight;

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

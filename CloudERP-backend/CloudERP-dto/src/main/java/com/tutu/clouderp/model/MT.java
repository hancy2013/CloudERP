package com.tutu.clouderp.model;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * 元数据表
 * 
 * @Title MT.java
 * @Package com.passionguy.force.dto
 * @Description 
 * @author tutu
 * @date 2014-11-20
 */
@Entity("mt")
public class MT {
	@Id
	private String id;
	private String name;
	private List<MF> mfs;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MF> getMfs() {
		return mfs;
	}

	public void setMfs(List<MF> mfs) {
		this.mfs = mfs;
	}
	
}

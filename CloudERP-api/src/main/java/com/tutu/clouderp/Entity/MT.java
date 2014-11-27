package com.tutu.clouderp.Entity;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;

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

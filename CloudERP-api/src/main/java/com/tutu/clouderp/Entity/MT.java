package com.tutu.clouderp.Entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Ԫ��ݶ���
 * 
 * @Title MT.java
 * @Package com.passionguy.force.dto
 * @Description 
 * @author tutu
 * @date 2014-11-20
 */
@Document(collection="mt")
public class MT {
	private String id;
	private String name;
	private String oid;
	private List<MF> mfs;
	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

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

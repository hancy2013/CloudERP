package com.tutu.clouderp.Entity;

import org.bson.BasicBSONObject;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Ԫ����ֶ�
 * 
 * @Title MF.java
 * @Package com.passionguy.force.dto
 * @Description 
 * @author tutu
 * @date 2014-11-20
 */
@Document(collection="mf")
public abstract class MF {
	protected String tid;
	protected String id;
	protected String name;
	public TypeEnum type;
	public TypeEnum getType() {
		return type;
	}
	public enum TypeEnum { TEXT, NUM , FORMULA }
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
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
	public abstract BasicBSONObject toBson();
}

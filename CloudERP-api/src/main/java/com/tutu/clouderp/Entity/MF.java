package com.tutu.clouderp.Entity;

import org.mongodb.morphia.annotations.Entity;



/**
 * 元数据字段
 * 
 * @Title MF.java
 * @Package com.passionguy.force.dto
 * @Description 
 * @author tutu
 * @date 2014-11-20
 */
@Entity("mf")
public abstract class MF extends BaseEntity{
	protected String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	// --------crud操作用------------
	private String rawValue;
	protected String getRawValue() {
		return rawValue;
	}
	protected void setRawValue(String rawValue) {
		this.rawValue = rawValue;
	}
	abstract Object getRealValue();
	
}

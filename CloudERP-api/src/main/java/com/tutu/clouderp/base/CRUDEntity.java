package com.tutu.clouderp.base;

import org.bson.BasicBSONObject;

public class CRUDEntity extends BasicBSONObject {
	private static final long serialVersionUID = 6136907910550323817L;
	private String tid;
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
}

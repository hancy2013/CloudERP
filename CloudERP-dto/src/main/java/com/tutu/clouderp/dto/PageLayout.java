package com.tutu.clouderp.dto;

import org.mongodb.morphia.annotations.Reference;

public class PageLayout {
	@Reference
	private MT mt;

	public MT getMt() {
		return mt;
	}

	public void setMt(MT mt) {
		this.mt = mt;
	}
}

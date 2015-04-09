package com.tutu.clouderp.dto;

import java.util.Set;

import org.mongodb.morphia.annotations.Entity;

import com.tutu.clouderp.model.MT;

@Entity("mtauthority")
public class MTAuthority{
	private MT mt;
	private Set<String> mtAuthoritys;
	public MT getMt() {
		return mt;
	}
	public void setMt(MT mt) {
		this.mt = mt;
	}
	public Set<String> getMtAuthoritys() {
		return mtAuthoritys;
	}
	public void setMtAuthoritys(Set<String> mtAuthoritys) {
		this.mtAuthoritys = mtAuthoritys;
	}
	
}

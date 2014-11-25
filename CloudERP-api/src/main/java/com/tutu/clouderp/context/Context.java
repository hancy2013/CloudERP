package com.tutu.clouderp.context;

import com.tutu.clouderp.auth.entity.MM;
import com.tutu.clouderp.auth.entity.Org;
import com.tutu.clouderp.auth.entity.User;

public class Context {
	private User user;
	private Org org;
	private MM mm;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Org getOrg() {
		return org;
	}
	public void setOrg(Org org) {
		this.org = org;
	}
	public MM getMm() {
		return mm;
	}
	public void setMm(MM mm) {
		this.mm = mm;
	}
	
}

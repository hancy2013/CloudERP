package com.tutu.clouderp.dto;

import java.util.List;

import org.mongodb.morphia.annotations.Id;

public class Role {
	@Id
	private String id;
	private String name;
	private List<MTAuthority> mtAuthoritys;
	private PageLayout pageLayout;
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
	public List<MTAuthority> getMtAuthoritys() {
		return mtAuthoritys;
	}
	public void setMtAuthoritys(List<MTAuthority> mtAuthoritys) {
		this.mtAuthoritys = mtAuthoritys;
	}
	public PageLayout getPageLayout() {
		return pageLayout;
	}
	public void setPageLayout(PageLayout pageLayout) {
		this.pageLayout = pageLayout;
	}
	
	
}

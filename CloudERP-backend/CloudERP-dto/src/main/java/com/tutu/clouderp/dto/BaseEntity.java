package com.tutu.clouderp.dto;

import java.util.Date;

import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.PostPersist;
import org.mongodb.morphia.annotations.Reference;

import com.tutu.clouderp.dto.auth.User;

public class BaseEntity {
	@Id
	private String id;
	private Date createDate;
	@Reference
	private User creator;
	private Date lastUpdated;
	@Reference
	private User lastModifier;
	private Boolean delFlag;

//	@PrePersist
//	void prePersist() {
//		lastUpdated = new Date();
//		lastModifier = ContextHolder.getContext().getUser();
//	}

	@PostPersist
	void preSave() {
		createDate = lastUpdated;
		creator = lastModifier;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public User getLastModifier() {
		return lastModifier;
	}

	public void setLastModifier(User lastModifier) {
		this.lastModifier = lastModifier;
	}

	public Boolean getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
}
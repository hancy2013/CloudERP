package com.tutu.clouderp.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mongodb.DBObject;

public interface DataService {
	void delete(String tid, String id);

	void create(String mid, HttpServletRequest request);

	List<DBObject> read(String collectionName, Integer page, Integer pageSize);
}

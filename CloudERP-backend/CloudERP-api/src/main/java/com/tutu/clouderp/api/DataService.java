package com.tutu.clouderp.api;

import javax.servlet.http.HttpServletRequest;

public interface DataService {
	void delete(String tid, String id);

	void add(String mid, HttpServletRequest request);
}

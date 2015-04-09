package com.tutu.clouderp.api;

import java.util.List;

import com.tutu.clouderp.model.MT;

public interface MTService {
	public List<MT> list();
	public MT mt(String mid);
}

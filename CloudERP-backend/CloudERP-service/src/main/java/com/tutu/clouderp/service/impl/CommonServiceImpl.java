package com.tutu.clouderp.service.impl;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.tutu.clouderp.api.CommonService;
import com.tutu.clouderp.context.ContextHolder;
@Service("commService")
public class CommonServiceImpl implements CommonService{
	private DBCollection getCollection(String tid){
		return ContextHolder.getContext().getDatastore().getDB().getCollection(tid);
	}
	@Override
	public void delete(String tid, String id) {
		BasicDBObject query = new BasicDBObject("id", new ObjectId(id));
		getCollection(tid).findAndRemove(query);
	}

}

package com.tutu.clouderp.base;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.tutu.clouderp.context.ContextHolder;
@Service("baseService")
public class BaseServiceImpl implements BaseService{
	private DBCollection getCollection(String tid){
		return ContextHolder.getContext().getDatastore().getDB().getCollection(tid);
	}
	@Override
	public void delete(String tid, String id) {
		BasicDBObject query = new BasicDBObject("id", new ObjectId(id));
		getCollection(tid).findAndRemove(query);
	}

}

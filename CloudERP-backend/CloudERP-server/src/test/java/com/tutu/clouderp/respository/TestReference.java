package com.tutu.clouderp.respository;

import java.net.UnknownHostException;
import java.util.List;

import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.Mongo;
import com.tutu.clouderp.dto.Org;

public class TestReference {
	@Test
	public void TestReference() throws UnknownHostException{
		Mongo mongo=new Mongo("127.0.0.1",27017);
		Datastore ds=new Morphia().createDatastore(mongo, "somedatabase");
//		Org parentOrg=ds.get(Org.class,"547b33577d8dc8ba351295e3");
//		Org org=new Org();
//		org.setName("测试机构3");
//		org.setParentOrg(parentOrg);
		List<Org> orgs=ds.find(Org.class).asList();
		orgs.get(0);
//		Org org=new Org();
//		org.setName("testorg1");
//		Org org2=new Org();
//		org2.setName("testorg2");
//		org2.setParentOrg(org);
//		ds.save(org);
//		ds.save(org2);
	}
}

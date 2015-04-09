package com.tutu.clouderp.respository;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.Mongo;
import com.tutu.clouderp.model.MF;
import com.tutu.clouderp.model.MFText;
import com.tutu.clouderp.model.MT;

public class TestWithoutAuth {
	public Datastore ds;
	@Before
	public void initDs() throws UnknownHostException{
		Mongo mongo=new Mongo("10.255.242.25",27017);
		ds=new Morphia().createDatastore(mongo, "sysmongo");
	}
	

	@Test
	public void createMT() throws UnknownHostException{
		MT mt=new MT();
		mt.setName("客户");
		List<MF> mfs=new ArrayList<MF>();
		
		MFText mfText=new MFText();
		mfText.setLabel("名称");
		mfText.setKey("name");
		mfText.setIsunique(true);
		mfText.setPlaceholder("张三...");
		mfText.setDescription("名称");
		mfText.setRequired(true);
		
		mfs.add(mfText);
		mt.setMfs(mfs);
		ds.save(mt);
	}
}

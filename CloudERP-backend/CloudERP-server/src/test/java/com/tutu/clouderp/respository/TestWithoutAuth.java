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
import com.tutu.clouderp.model.MFDate;
import com.tutu.clouderp.model.MFNumber;
import com.tutu.clouderp.model.MFSelect;
import com.tutu.clouderp.model.MFText;
import com.tutu.clouderp.model.MT;

public class TestWithoutAuth {
	public Datastore ds;
	@Before
	public void initDs() throws UnknownHostException{
		Mongo mongo=new Mongo("localhost",27017);
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
		
		MFDate mfDate=new MFDate();
		mfDate.setKey("birthday");
		mfDate.setLabel("生日");
		mfDate.setFormat("yyyy-MM-dd");

		MFSelect mfSelect=new MFSelect();
		mfSelect.setKey("gender");
		mfSelect.setLabel("性别");
		mfSelect.setOptions(new String[]{"男","女"});
		
		MFNumber mfNumber=new MFNumber();
		mfNumber.setKey("age");
		mfNumber.setLabel("年龄");
		
		mfs.add(mfText);
		mfs.add(mfDate);
		mfs.add(mfSelect);
		mfs.add(mfNumber);
		mt.setMfs(mfs);
		ds.save(mt);
	}
}

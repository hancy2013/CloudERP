package com.tutu.clouderp.respository;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mongodb.MongoClient;
import com.tutu.clouderp.Entity.MF;
import com.tutu.clouderp.Entity.MFText;
import com.tutu.clouderp.Entity.MT;
import com.tutu.clouderp.auth.entity.MM;
import com.tutu.clouderp.auth.entity.Org;
import com.tutu.clouderp.auth.entity.User;
import com.tutu.clouderp.context.Context;
import com.tutu.clouderp.context.ContextHolder;
import com.tutu.clouderp.session.Hex;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:context.xml")
public class TestMorphia extends AbstractJUnit4SpringContextTests{
//	@Resource
//	private UserResource userResource;
    
    @Test
    public void RegistOrg() throws UnknownHostException{
    	MongoClient mongo = new MongoClient("10.255.242.25",27017);
    	Datastore datastore = new Morphia().createDatastore(mongo, "auth");
    	MM mm=new MM();
    	mm.setId(new ObjectId());
    	mm.setHostip("10.255.242.25");
    	mm.setPort(27017);
    	mm.setWeight(1);
    	datastore.save(mm);
    	
    	Org org=new Org();
		ObjectId objectId=new ObjectId();
		org.setId(objectId);
		org.setName("测试机构");
		org.setMmid(mm.getId().toString());
		org.setDbid("somedatabase");
		datastore.save(org);
		User user=new User("admin@test.com",new String(Hex.encode("000000".getBytes())));
		user.setMoid(org.getId().toString());
		datastore.save(user);
    }
    
    @Test
	public void LoginAndCreateMT() throws UnknownHostException{
    	MongoClient mongo = new MongoClient("10.255.242.25",27017);
    	Datastore datastore = new Morphia().createDatastore(mongo, "auth");
		String username="admin@test.com";
		String password="000000";
		Context context=new Context();
		Query<User> query=datastore.createQuery(User.class).filter("name", username);
		User user=(User)query.asList().get(0);
		context.setUser(user);
		Org org=datastore.get(Org.class, new ObjectId(user.getMoid()));
		context.setOrg(org);
		MM mm=datastore.get(MM.class, new ObjectId(org.getMmid()));
		context.setMm(mm);
		ContextHolder.setContext(context);
		
		
		MongoClient mongo2 = new MongoClient(ContextHolder.getContext().getMm().getHostip(),ContextHolder.getContext().getMm().getPort());
		Datastore datastore2 = new Morphia().createDatastore(mongo2, org.getDbid());
			MT mt=new MT();
			mt.setOid(org.getId().toString());
			mt.setName("测试表");
			MF mf=new MFText();
			mf.setName("测试字段"); 
			List<MF> mfs=new ArrayList<MF>();
			mfs.add(mf);
			mt.setMfs(mfs);
			datastore2.save(mt);
			
			
//			mfRepository.save(mf);
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}

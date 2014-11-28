package com.tutu.clouderp.respository;

import java.net.UnknownHostException;

import javax.annotation.Resource;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tutu.clouderp.Entity.MT;
import com.tutu.clouderp.auth.dao.SystemDatastore;
import com.tutu.clouderp.auth.entity.MM;
import com.tutu.clouderp.auth.entity.Tenant;
import com.tutu.clouderp.auth.entity.User;
import com.tutu.clouderp.context.Context;
import com.tutu.clouderp.context.ContextHolder;
import com.tutu.clouderp.rest.resources.UserResource;
import com.tutu.clouderp.session.Hex;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:context.xml")
public class TestMorphia extends AbstractJUnit4SpringContextTests {
	@Resource
	private UserResource userResource;
	@Autowired
	private SystemDatastore systemDatastore;

	@Test
	public void RegistOrg() throws UnknownHostException {
		MM mm = new MM();
		mm.setId(new ObjectId());
		mm.setHostip("10.255.242.25");
		mm.setPort(27017);
		mm.setWeight(1);
		systemDatastore.save(mm);

		Tenant tenant = new Tenant();
		tenant.setName("测试机构");
		tenant.setMm(mm);
		tenant.setDbname("somedatabase");
		systemDatastore.save(tenant);
		User user = new User("admin@test.com", new String(Hex.encode("000000".getBytes())));
		user.setTenant(tenant);
		systemDatastore.save(user);
	}

	@Test
	public void LoginAndCreateMT() throws UnknownHostException {
		String username = "admin@test.com";
		String password = "000000";
		try {
			userResource.authenticate(username, password);
		} catch (Exception e) {
			return;
		}
		Context context = new Context();
		User user = systemDatastore.get(User.class, username);
		context.setUser(user);
		ContextHolder.setContext(context);

		MT mt = new MT();
		mt.setName("测试表");
//		MF mf = new MFText();
//		mf.setName("测试字段");
//		List<MF> mfs = new ArrayList<MF>();
//		mfs.add(mf);
//		mt.setMfs(mfs);
		ContextHolder.getContext().getDatastore().save(mt);
		MT mymt=ContextHolder.getContext().getDatastore().get(MT.class,"5477db7611d504bf46c88862");
	}
	
	public void operateWithdbObject(){
		
	}

}

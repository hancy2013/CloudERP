//package com.tutu.clouderp.respository;
//
//import java.net.UnknownHostException;
//import java.security.NoSuchAlgorithmException;
//
//import javax.annotation.Resource;
//
//import org.bson.types.ObjectId;
//import org.junit.Test;
//
//import com.tutu.clouderp.api.UserService;
//import com.tutu.clouderp.auth.dao.SystemDatastore;
//import com.tutu.clouderp.basicTest.BaseServiceTests;
//import com.tutu.clouderp.context.Context;
//import com.tutu.clouderp.context.ContextHolder;
//import com.tutu.clouderp.dto.MT;
//import com.tutu.clouderp.dto.Org;
//import com.tutu.clouderp.dto.auth.MM;
//import com.tutu.clouderp.dto.auth.Tenant;
//import com.tutu.clouderp.dto.auth.User;
//import com.tutu.clouderp.session.PwdUtils;
//
////@RunWith(SpringJUnit4ClassRunner.class)
////@ContextConfiguration(locations = "classpath*:conf/spring.xml")
//public class TestMorphia extends BaseServiceTests {
//	public UserService userService;
//	private SystemDatastore systemDatastore;
//	
//	public void Login() throws UnknownHostException{
//		String username = "admin@test.com";
//		String password = "000000";
//		try {
//			userService.authenticate(username, password);
//		} catch (Exception e) {
//			return;
//		}
//		Context context = new Context();
//		User user = systemDatastore.get(User.class, username);
//		context.setUser(user);
//		ContextHolder.setContext(context);
//	}
//	
//	@Test
//	public void RegistTenant() throws UnknownHostException, NoSuchAlgorithmException {
//		userService=context.getBean(UserService.class);
//		systemDatastore=context.getBean(SystemDatastore.class);
//		MM mm = new MM();
//		mm.setId(new ObjectId());
//		mm.setHostip("127.0.0.1");
//		mm.setPort(27017);
//		mm.setWeight(1);
//		systemDatastore.save(mm);
//
//		Tenant tenant = new Tenant();
//		tenant.setName("娴嬭瘯鏈烘瀯");
//		tenant.setMm(mm);
//		tenant.setDbname("somedatabase");
//		systemDatastore.save(tenant);
//		User user = new User("admin@test.com", PwdUtils.eccrypt("000000"));
//		user.setTenant(tenant);
//		systemDatastore.save(user);
//	}
//
//	@Test
//	public void LoginAndCreateMT() throws UnknownHostException {
//		userService=context.getBean(UserService.class);
//		systemDatastore=context.getBean(SystemDatastore.class);
//		String username = "admin@test.com";
//		String password = "000000";
//		try {
//			userService.authenticate(username, password);
//		} catch (Exception e) {
//			return;
//		}
//		Context context = new Context();
//		User user = systemDatastore.get(User.class, username);
//		context.setUser(user);
//		ContextHolder.setContext(context);
//
//		MT mt = new MT();
//		mt.setName("娴嬭瘯琛�);
////		MF mf = new MFText();
////		mf.setName("娴嬭瘯瀛楁");
////		List<MF> mfs = new ArrayList<MF>();
////		mfs.add(mf);
////		mt.setMfs(mfs);
//		ContextHolder.getContext().getDatastore().save(mt);
//		MT mymt=ContextHolder.getContext().getDatastore().get(MT.class,"5477db7611d504bf46c88862");
//	}
//	@Test
//	public void createOrg(){
//		Org parentOrg=ContextHolder.getContext().getDatastore().get(Org.class,new ObjectId("54788dd194226b0e1fd382be"));
//		Org org=new Org();
//		org.setName("娆＄骇鏈烘瀯");
//		org.setParentOrg(parentOrg);
//		ContextHolder.getContext().getDatastore().save(org);
//	}
//
//}

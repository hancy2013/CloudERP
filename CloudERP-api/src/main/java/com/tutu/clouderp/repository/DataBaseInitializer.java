package com.tutu.clouderp.repository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.tutu.clouderp.Entity.NewsEntry;
import com.tutu.clouderp.auth.entity.MM;
import com.tutu.clouderp.auth.entity.User;
import com.tutu.clouderp.auth.repository.MMRepository;
import com.tutu.clouderp.auth.repository.UserRepository;
import com.tutu.clouderp.session.Hex;


/**
 * Initialize the database with some test entries.
 * 
 * @author Philip W. Sorst <philip@sorst.net>
 */
public class DataBaseInitializer
{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private NewsRepository newsRepository;
	@Autowired
	private MMRepository mmRespository;
	protected DataBaseInitializer()
	{
		/* Default constructor for reflection instantiation */
	}


	public DataBaseInitializer(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}


	public void initDataBase()
	{
		User userUser = new User("user", new String(Hex.encode("user".getBytes())));
		userUser.addRole("user");
		this.userRepository.save(userUser);
//		userRepository.save(userUser);
		User adminUser = new User("admin", new String(Hex.encode("admin".getBytes())));
		adminUser.addRole("user");
		adminUser.addRole("admin");
		this.userRepository.save(adminUser);
//		userRepository.save(adminUser);
		long timestamp = System.currentTimeMillis() - 1000 * 60 * 60 * 24;
		for (int i = 0; i < 10; i++) {
			NewsEntry newsEntry = new NewsEntry();
			newsEntry.setContent("This is example content " + i);
			newsEntry.setDate(new Date(timestamp));
			this.newsRepository.save(newsEntry);
			timestamp += 1000 * 60 * 60;
		}
		MM mm=new MM();
		mm.setHostip("127.0.0.1");
		mm.setPort(27017);
		mm.setWeight(1);
		mmRespository.save(mm);
	}

}
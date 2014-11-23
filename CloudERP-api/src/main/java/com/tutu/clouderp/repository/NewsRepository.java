package com.tutu.clouderp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tutu.clouderp.Entity.NewsEntry;

public interface NewsRepository extends MongoRepository<NewsEntry, String> {
	NewsEntry findById(String id);
	
	void delete(String id);
}

package com.tutu.clouderp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tutu.clouderp.Entity.MT;

public interface MTRepository extends MongoRepository<MT, String> {
	
}

package com.tutu.clouderp.auth.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tutu.clouderp.auth.entity.MM;

public interface MMRepository extends MongoRepository<MM, String> {
	
}

package com.tutu.clouderp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tutu.clouderp.Entity.MF;

public interface MFRepository extends MongoRepository<MF, String> {
	
}

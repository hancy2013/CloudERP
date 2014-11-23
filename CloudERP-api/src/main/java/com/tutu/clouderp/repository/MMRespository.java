package com.tutu.clouderp.repository;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tutu.clouderp.Entity.MM;

public interface MMRespository extends MongoRepository<MM, String> {
	
}

package com.tutu.clouderp.auth.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tutu.clouderp.auth.entity.Org;

public interface OrgRepository extends MongoRepository<Org, String> {

}

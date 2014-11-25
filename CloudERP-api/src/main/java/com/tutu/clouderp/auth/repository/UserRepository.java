package com.tutu.clouderp.auth.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tutu.clouderp.auth.entity.User;

/**
 * Interface for todo repository.
 */
public interface UserRepository extends MongoRepository<User, String> {

    /**
     * Find user by id.
     * @param id the user id
     * @return the user with the given id or null if no user found
     */
    User findById(String id);

    /**
     * Find user by email.
     * @param email the user email
     * @return the user with the given email or null if no user found
     */
    User findByName(String name);

}

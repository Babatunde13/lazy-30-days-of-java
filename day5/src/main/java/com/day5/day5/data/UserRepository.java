package com.day5.day5.data;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    @Query("{ 'username': ?0 }")
    User findUserByUsername(String username);
}

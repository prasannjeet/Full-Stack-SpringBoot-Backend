package com.prasannjeet.bike.repository;

import com.prasannjeet.bike.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    public User findOneByName(String name);
    public User findOneById(String id);
}

package com.cubereum.api.Repository;

import com.cubereum.api.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    public User findByEmail(String email);

}

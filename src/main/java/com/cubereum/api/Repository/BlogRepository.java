package com.cubereum.api.Repository;

import com.cubereum.api.Entity.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends MongoRepository<Blog, String> {
}

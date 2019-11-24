package com.cubereum.api.Service;

import com.cubereum.api.Entity.Blog;
import com.cubereum.api.Entity.User;
import com.cubereum.api.Repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserService userService;

    public Blog addBlog(Blog blog) {
        User loggedInUser = userService.getUserFromRequest();
        blog.setUser(loggedInUser);
        return blogRepository.save(blog);
    }

    public Blog updateBlog(Blog blog) {
        User loggedInUser = userService.getUserFromRequest();
        User blogUser = blog.getUser();
        if(blogUser == loggedInUser)
            return blogRepository.save(blog);
        return blog;
    }

    public boolean deleteBlog(Blog blog) {
        User loggedInUser = userService.getUserFromRequest();
        User blogUser = blog.getUser();
        if(blogUser == loggedInUser) {
            blogRepository.delete(blog);
            return true;
        }
        else
            return false;
    }

    public Optional<Blog> getBlog(String id) {
        return blogRepository.findById(id);
    }

    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }
}

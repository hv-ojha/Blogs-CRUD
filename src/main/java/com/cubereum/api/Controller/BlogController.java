package com.cubereum.api.Controller;

import com.cubereum.api.Entity.Blog;
import com.cubereum.api.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public ResponseEntity getBlogs() {
        return ResponseEntity.ok(blogService.getBlogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity getBlog(@PathVariable String id) {
        Optional<Blog> blog = blogService.getBlog(id);
        return ResponseEntity.of(blog);
    }

    @PostMapping("/add")
    public ResponseEntity postBlog(@RequestBody Blog blog) {
        return ResponseEntity.ok(blogService.addBlog(blog));
    }

    @PostMapping("/update")
    public ResponseEntity updateBlog(@RequestBody Blog blog) {
        return ResponseEntity.ok(blogService.updateBlog(blog));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@PathVariable String id) {
        Optional<Blog> blog = blogService.getBlog(id);
        if(blog.isPresent()) {
            return ResponseEntity.ok(blogService.deleteBlog(blog.get()));
        }
        return ResponseEntity.ok("False");
    }
}

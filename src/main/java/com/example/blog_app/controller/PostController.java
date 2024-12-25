package com.example.blog_app.controller;

import com.example.blog_app.entity.Post;
import com.example.blog_app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/createPost")
    public ResponseEntity<String> createPost(@RequestBody Post post){
        Post newPost = postService.createPost(post);
        return new ResponseEntity<>("Post created successfully, id = " + newPost.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/getPost/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id){
        Post post = postService.getPost(id);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/getAll")
    public List<Post> getAllPost(){
        return postService.getAllPost();
    }

    @PutMapping("/updatePost/{id}")
    public ResponseEntity<String> updatePost(@RequestBody Post post, @PathVariable Long id){
        postService.updatePost(post, id);

        return new ResponseEntity<>("Post update successfully", HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById (@PathVariable Long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("Post delete successfully", HttpStatus.OK);
    }
}

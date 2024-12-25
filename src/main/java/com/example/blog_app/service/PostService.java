package com.example.blog_app.service;

import com.example.blog_app.Repository.PostRepository;
import com.example.blog_app.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post createPost(Post post){
    return postRepository.save(post);
    }

    public Post getPost(Long id){
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException(id + "This is doesn't exist."));
    }

    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public void updatePost (Post post, Long id){
        if (postRepository.findById(id).isPresent()){
            Post newPost = new Post();
            newPost.setId(id);
            newPost.setTitle(post.getTitle());
            newPost.setDescription(post.getDescription());

           postRepository.save(newPost);
        }
        else {
         throw new RuntimeException(id + "This is doesn't exist.");
        }
    }

    public void deletePostById(Long id){
        if (postRepository.findById(id).isPresent()){
            postRepository.deleteById(id);
        }
        else {
            throw new RuntimeException(id + "This is doesn't exist.");
        }
    }
}

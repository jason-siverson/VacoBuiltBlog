package com.example.vacobuiltblog.web;

import com.example.vacobuiltblog.database.PostRepository;
import com.example.vacobuiltblog.model.Post;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostsController {

    private final PostRepository repository;

    PostsController(PostRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/posts")
    List<Post> all() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "timestamp"));
    }

    @PostMapping("/posts/")
    Post createPost(@RequestBody Post newPost) {
        //todo - check timestamp
        return repository.save(newPost);
    }

    @GetMapping("/posts/{id}")
    Optional<Post> findPost(@PathVariable Long id) {
        return repository.findById(id);
    }

    @PutMapping("/posts/{id}")
    Post updatePost(@RequestBody Post updatedPost, @PathVariable Long id) {
        return repository.findById(id)
                .map(post -> {
                    post.setTitle(updatedPost.getTitle());
                    post.setContents(updatedPost.getContents());
                    post.setCategory(updatedPost.getCategory());
                    return repository.save(updatedPost);
                })
                .orElseGet(() -> {
                    updatedPost.setId(id);
                    return repository.save(updatedPost);
                });
    }

    @DeleteMapping("/posts/{id}")
    void deletePost(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @DeleteMapping("/posts/")
    void deleteAllPosts() {
        repository.deleteAll();
    }
}

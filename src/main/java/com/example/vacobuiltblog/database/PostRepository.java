package com.example.vacobuiltblog.database;

import com.example.vacobuiltblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}

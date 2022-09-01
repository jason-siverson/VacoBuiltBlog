package com.example.vacobuiltblog.database;

import com.example.vacobuiltblog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Long> {

}

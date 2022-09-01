package com.example.vacobuiltblog.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter @Setter @NoArgsConstructor
public class Category implements Serializable {

    private @Id Long id;
    private String name;

    public Category(String name) {
        this.name = name;
    }
}

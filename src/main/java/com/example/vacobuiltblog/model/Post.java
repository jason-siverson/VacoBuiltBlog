package com.example.vacobuiltblog.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Getter @Setter @NoArgsConstructor
public class Post implements Serializable {

    private @Id Long id;
    private String title;
    private String contents;
    private Date timestamp;
    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}

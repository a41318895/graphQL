package com.akichou.graphql.entity;

import com.akichou.graphql.enumeration.TypeEnum;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "book")
@Data
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "book_id")
    private String id ;

    @Column(name = "title")
    private String title ;

    @Column(name = "page")
    private Integer page ;

    @Column(name = "publication_year")
    private Integer publicationYear ;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity author ;

    @Enumerated(EnumType.STRING)
    private TypeEnum type ;
}

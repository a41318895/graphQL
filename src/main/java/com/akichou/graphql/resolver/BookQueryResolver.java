package com.akichou.graphql.resolver;

import com.akichou.graphql.entity.BookEntity;
import com.akichou.graphql.enumeration.TypeEnum;
import com.akichou.graphql.repository.BookRepository;
import graphql.GraphQLException;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookQueryResolver {

    private final BookRepository bookRepository ;

    @QueryMapping
    public BookEntity bookById(@Argument String bookId) {

        return bookRepository.findById(bookId)
                .orElseThrow(() -> new GraphQLException("Book not found"));
    }

    @QueryMapping
    public List<BookEntity> allBooks() {

        return bookRepository.findAll() ;
    }

    @QueryMapping
    public List<BookEntity> booksByTitle(@Argument String title) {

        return bookRepository.findByTitleContainingIgnoreCase(title) ;
    }

    @QueryMapping
    public List<BookEntity> booksByType(@Argument TypeEnum type) {

        return bookRepository.findByType(type) ;
    }
}

package com.akichou.graphql.resolver;

import com.akichou.graphql.entity.AuthorEntity;
import com.akichou.graphql.repository.AuthorRepository;
import graphql.GraphQLException;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuthorQueryResolver {

    private final AuthorRepository authorRepository ;

    @QueryMapping
    public AuthorEntity authorById(@Argument String authorId) {

        return authorRepository.findById(authorId)
                .orElseThrow(() -> new GraphQLException("Author not found"));
    }

    @QueryMapping
    public List<AuthorEntity> authorsByLastName(@Argument String lastName) {

        return authorRepository.findByLastName(lastName) ;
    }
}

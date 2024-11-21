package com.akichou.graphql.resolver;

import com.akichou.graphql.entity.AuthorEntity;
import com.akichou.graphql.input.CreateAuthorInput;
import com.akichou.graphql.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AuthorMutationResolver {

    private final AuthorRepository authorRepository ;

    @MutationMapping
    public AuthorEntity createAuthor(@Argument CreateAuthorInput createAuthorInput) {

        AuthorEntity author = new AuthorEntity() ;
        author.setFirstName(createAuthorInput.getFirstName()) ;
        author.setLastName(createAuthorInput.getLastName()) ;
        author.setEmail(createAuthorInput.getEmail()) ;

        return authorRepository.save(author) ;
    }

    @MutationMapping
    public AuthorEntity updateAuthor(@Argument String authorId,
                                     @Argument CreateAuthorInput createAuthorInput) {

        AuthorEntity author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found")) ;

        author.setFirstName(createAuthorInput.getFirstName()) ;
        author.setLastName(createAuthorInput.getLastName()) ;
        author.setEmail(createAuthorInput.getEmail()) ;

        return authorRepository.save(author) ;
    }

    @MutationMapping
    public boolean deleteAuthor(@Argument String authorId) {

        authorRepository.deleteById(authorId) ;

        return true ;
    }
}

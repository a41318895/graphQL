package com.akichou.graphql.resolver;

import com.akichou.graphql.entity.AuthorEntity;
import com.akichou.graphql.entity.BookEntity;
import com.akichou.graphql.input.CreateBookInput;
import com.akichou.graphql.repository.AuthorRepository;
import com.akichou.graphql.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class BookMutationResolver {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    @MutationMapping
    public BookEntity createBook(@Argument CreateBookInput createBookInput) {

        AuthorEntity author = authorRepository.findById(createBookInput.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found")) ;

        BookEntity book = new BookEntity() ;
        book.setTitle(createBookInput.getTitle()) ;
        book.setPage(createBookInput.getPage()) ;
        book.setType(createBookInput.getType()) ;
        book.setPublicationYear(createBookInput.getPublicationYear()) ;
        book.setAuthor(author) ;

        return bookRepository.save(book) ;
    }

    @MutationMapping
    public BookEntity updateBook(@Argument String bookId,
                                 @Argument CreateBookInput createBookInput) {

        BookEntity book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found")) ;

        book.setTitle(createBookInput.getTitle()) ;
        book.setPage(createBookInput.getPage()) ;
        book.setType(createBookInput.getType()) ;
        book.setPublicationYear(createBookInput.getPublicationYear()) ;

        return bookRepository.save(book) ;
    }

    @MutationMapping
    public boolean deleteBook(@Argument String bookId) {

        bookRepository.deleteById(bookId) ;
        return true ;
    }
}

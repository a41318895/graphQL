package com.akichou.graphql.repository;

import com.akichou.graphql.entity.BookEntity;
import com.akichou.graphql.enumeration.TypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, String> {

    List<BookEntity> findByType(TypeEnum type) ;

    List<BookEntity> findByTitleContainingIgnoreCase(String title);
}

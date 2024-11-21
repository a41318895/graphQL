package com.akichou.graphql.input;

import com.akichou.graphql.enumeration.TypeEnum;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookInput {

    @NotBlank(message = "The book title can't be blank")
    @Size(max = 60, message = "The book title can't over 60 chara")
    private String title ;

    @Min(value = 1, message = "The page must bigger than 0")
    @Max(value = 9999, message = "The page must smaller than 10000")
    private Integer page ;

    @NotBlank(message = "The author id can't be blank")
    private String authorId ;

    private Integer publicationYear ;

    private TypeEnum type ;
}

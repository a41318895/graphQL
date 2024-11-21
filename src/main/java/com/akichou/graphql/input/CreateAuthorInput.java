package com.akichou.graphql.input;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAuthorInput {

    @NotBlank
    @Min(value = 1, message = "The first name chara must mote than 0")
    @Max(value = 10, message = "The first name chara must smaller than 10")
    private String firstName ;

    @NotBlank
    @Min(value = 1, message = "The last name chara must mote than 0")
    @Max(value = 10, message = "The last name chara must smaller than 10")
    private String lastName ;

    private String email ;
}
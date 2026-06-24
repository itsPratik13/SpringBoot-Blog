package com.tut.blog.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryDTO {

    @NotBlank(message = "category must have a name")
    @Size(min = 3,max = 100,message = "Category must have name size {min} & {max} characters")
    private String name;
}

package com.tut.blog.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class APIError {
    private int status;
    private String message;
    List<buildError> errors;


    public static class buildError{
     private String field,message;
    }

}

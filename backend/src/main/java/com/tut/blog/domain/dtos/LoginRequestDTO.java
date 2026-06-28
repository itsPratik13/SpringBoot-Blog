package com.tut.blog.domain.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Data
public class LoginRequestDTO {
    private String email;
    private String password;

}

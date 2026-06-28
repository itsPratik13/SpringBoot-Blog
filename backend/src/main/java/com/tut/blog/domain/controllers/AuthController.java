package com.tut.blog.domain.controllers;

import com.tut.blog.domain.dtos.AuthResponseDTO;
import com.tut.blog.domain.dtos.LoginRequestDTO;
import com.tut.blog.domain.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
       UserDetails userDetails= authenticationService.authenticate(loginRequestDTO.getEmail(),loginRequestDTO.getPassword());
       String tokenValue=authenticationService.generateToken(userDetails);
      AuthResponseDTO authresponse= AuthResponseDTO.builder().token(tokenValue).expiresIn(86400L).build();
      return ResponseEntity.ok(authresponse);
    }
}

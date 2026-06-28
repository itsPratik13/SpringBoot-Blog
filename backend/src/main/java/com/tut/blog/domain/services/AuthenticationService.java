package com.tut.blog.domain.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public UserDetails authenticate(String email,String password){

    }
    public String generateToken(UserDetails userDetails){

    }
}

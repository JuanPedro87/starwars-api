package com.example.start.wars.auth;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by jpcs1 on 14/07/17.
 */
@Service
public class FakeAuthProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication)throws AuthenticationException {
        String name = authentication.getName();
        String password= authentication.getCredentials().toString();

        if(name.equals(password)) {
            return new UsernamePasswordAuthenticationToken(name,password, new ArrayList<>());
        }
        throw  new BadCredentialsException("Incorrect");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);

    }
}

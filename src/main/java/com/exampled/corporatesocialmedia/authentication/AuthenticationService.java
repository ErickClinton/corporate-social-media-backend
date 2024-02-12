package com.exampled.corporatesocialmedia.authentication;

import com.exampled.corporatesocialmedia.authentication.dto.AuthenticationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    public ResponseEntity login(AuthenticationDto data){
        var userNamePassWord = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(userNamePassWord);

        return ResponseEntity.ok().build();
    }
}

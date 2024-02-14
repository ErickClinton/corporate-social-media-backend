package com.exampled.corporatesocialmedia.authentication;

import com.exampled.corporatesocialmedia.authentication.dto.AuthenticationDto;
import com.exampled.corporatesocialmedia.infra.secutiry.TokenService;
import com.exampled.corporatesocialmedia.user.entities.UsersEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationService(final AuthenticationManager authenticationService, final TokenService tokenService){
        this.authenticationManager = authenticationService;
        this.tokenService = tokenService;
    }

    public ResponseEntity login(AuthenticationDto data){
        var userNamePassWord = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(userNamePassWord);

        var token = tokenService.generateToken((UsersEntity) auth.getPrincipal());
        return ResponseEntity.ok(token);
    }
}

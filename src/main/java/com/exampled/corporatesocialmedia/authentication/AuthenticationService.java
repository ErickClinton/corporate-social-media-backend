package com.exampled.corporatesocialmedia.authentication;

import com.exampled.corporatesocialmedia.authentication.dto.AuthenticationDto;
import com.exampled.corporatesocialmedia.infra.secutiry.TokenService;
import com.exampled.corporatesocialmedia.user.entities.UsersEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private static final Logger logger = Logger.getLogger(AuthenticationController.class.getName());

    public AuthenticationService(final AuthenticationManager authenticationService, final TokenService tokenService){
        this.authenticationManager = authenticationService;
        this.tokenService = tokenService;
    }

    public ResponseEntity login(AuthenticationDto data){
            logger.info("Start method login - Request - " + data);
            var userNamePassWord = new UsernamePasswordAuthenticationToken(data.email(), data.password());
            var auth = this.authenticationManager.authenticate(userNamePassWord);

            var token = tokenService.generateToken((UsersEntity) auth.getPrincipal());
            logger.info("End method login - Response - "+token);
            return ResponseEntity.ok(token);
        }

}

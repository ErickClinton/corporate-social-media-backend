package com.exampled.corporatesocialmedia.authentication;

import com.exampled.corporatesocialmedia.authentication.dto.AuthenticationDto;
import jakarta.validation.Valid;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final Logger logger = Logger.getLogger(AuthenticationController.class.getName());
    private final AuthenticationService authenticationService;

    public AuthenticationController(final AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDto data){
        try{
            logger.info("Start method login");
            return authenticationService.login(data);
        }catch(Exception e){
            logger.severe("Error method - login - " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error when loggin in");
        }
    }

}

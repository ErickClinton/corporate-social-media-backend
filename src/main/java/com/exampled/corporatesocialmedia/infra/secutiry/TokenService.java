package com.exampled.corporatesocialmedia.infra.secutiry;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.exampled.corporatesocialmedia.user.entities.UsersEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.logging.Logger;

@Service
public class TokenService {
    @Value("${api.security.token.secret}") String secret;
    private final Logger logger = Logger.getLogger(TokenService.class.getName());

    public String generateToken(UsersEntity user) {
        try {
            logger.info("Start method generateToken - Request - "+user);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(user.getEmail())
                    .withExpiresAt(this.genExpirationDate())
                    .sign(algorithm);
            logger.info("End method generateToken - Response - "+token);
            return token;
        }catch(JWTCreationException exception){
            logger.severe("Error method generateToken - Error - "+exception);
            throw new RuntimeException("Error while generating token", exception);
        }
    }

    public String validateToken(String token){
        try{
            logger.info("Start method validateToken - Request - "+token);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch(JWTVerificationException exception){
            logger.severe("Error method validateToken - Error - "+exception.getMessage());
            throw new JWTVerificationException(String.valueOf(exception));
        }
    }

    private Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}

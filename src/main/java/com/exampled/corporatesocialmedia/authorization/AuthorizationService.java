package com.exampled.corporatesocialmedia.authorization;

import com.exampled.corporatesocialmedia.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class AuthorizationService implements UserDetailsService {

    private final UserRepository usersRepository;
    private static final Logger logger = Logger.getLogger(AuthorizationService.class.getName());

    public AuthorizationService(final UserRepository userRepository){
        this.usersRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            return usersRepository.findByEmail(username);
    }
}

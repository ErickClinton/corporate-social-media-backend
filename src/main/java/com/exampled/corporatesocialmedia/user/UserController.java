package com.exampled.corporatesocialmedia.user;

import com.exampled.corporatesocialmedia.user.dto.CreateUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UsersService usersService;

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PostMapping
    public Void saveUser(final @RequestBody CreateUserDto newUser){
        usersService.saveUser(newUser);
        return null;
    }

}

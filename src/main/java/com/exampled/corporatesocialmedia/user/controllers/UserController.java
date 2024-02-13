package com.exampled.corporatesocialmedia.user.controllers;

import com.exampled.corporatesocialmedia.user.dto.CreateUserDTO;
import com.exampled.corporatesocialmedia.user.dto.FindAllUsersDTO;
import com.exampled.corporatesocialmedia.user.useCase.CreateUserUseCase;
import com.exampled.corporatesocialmedia.user.useCase.ListAllUsersUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private CreateUserUseCase createUserUseCase;
    @Autowired
    private ListAllUsersUseCase listAllUsersUseCase;
    @PostMapping("/register")
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    public ResponseEntity<Object> registerUser(@RequestBody CreateUserDTO createUserDTO){
        try{
            this.createUserUseCase.execute(createUserDTO);
            return ResponseEntity.ok().build();
        }catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/find-all")
    public List<FindAllUsersDTO> getAll(){
        return this.listAllUsersUseCase.execute();
    }
    // List All Users
    // Get User By ID
    // Delete User
}

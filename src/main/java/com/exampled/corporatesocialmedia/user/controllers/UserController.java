package com.exampled.corporatesocialmedia.user.controllers;

import com.exampled.corporatesocialmedia.user.dto.CreateUserDTO;
import com.exampled.corporatesocialmedia.user.dto.GetUserDTO;
import com.exampled.corporatesocialmedia.user.useCase.CreateUserUseCase;
import com.exampled.corporatesocialmedia.user.useCase.DeleteUserUseCase;
import com.exampled.corporatesocialmedia.user.useCase.GetUserByIdUseCase;
import com.exampled.corporatesocialmedia.user.useCase.ListAllUsersUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.logging.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class.getName());
    private final CreateUserUseCase createUserUseCase;
    private final ListAllUsersUseCase listAllUsersUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final DeleteUserUseCase deleteUserUseCase;
    public UserController(final CreateUserUseCase createUserUseCase, final ListAllUsersUseCase listAllUsersUseCase, final GetUserByIdUseCase getUserByIdUseCase, final DeleteUserUseCase deleteUserUseCase){
        this.createUserUseCase = createUserUseCase;
        this.listAllUsersUseCase = listAllUsersUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        this.getUserByIdUseCase = getUserByIdUseCase;
    }

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
    public List<GetUserDTO> getAll(){
        return this.listAllUsersUseCase.execute();
    }

    @GetMapping("/find-by-id/{id}")
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    public ResponseEntity getUserById(@PathVariable("id") UUID id){
        try{
            return ResponseEntity.ok().body(this.getUserByIdUseCase.execute(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") UUID id){
        this.deleteUserUseCase.execute(id);
    }
}

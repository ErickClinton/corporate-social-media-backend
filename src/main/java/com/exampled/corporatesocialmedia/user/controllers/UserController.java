package com.exampled.corporatesocialmedia.user.controllers;

import com.exampled.corporatesocialmedia.user.dto.CreateUserDTO;
import com.exampled.corporatesocialmedia.user.dto.GetUserDTO;
import com.exampled.corporatesocialmedia.user.useCase.CreateUserUseCase;
import com.exampled.corporatesocialmedia.user.useCase.DeleteUserUseCase;
import com.exampled.corporatesocialmedia.user.useCase.GetUserByIdUseCase;
import com.exampled.corporatesocialmedia.user.useCase.ListAllUsersUseCase;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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
            logger.info("Start method registerUser");
            this.createUserUseCase.saveUser(createUserDTO);
            return ResponseEntity.ok().build();
        }catch (DataIntegrityViolationException e) {
            logger.severe("Error method saveUser - Error - " + e.getMessage());
            return ResponseEntity.badRequest().body("Error to insert in Data base");
        }
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/find-all")
    public List<GetUserDTO> findAll(){
        try{
            logger.info("Start method getAll");
            return this.listAllUsersUseCase.getAll();
        }catch(Exception e){
            logger.severe("Error method getAll - Error - "+e.getMessage());
            return Collections.emptyList();
        }
    }

    @GetMapping("/find-by-id/{id}")
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    public ResponseEntity findUserById(@PathVariable("id") UUID id){
        try{
            logger.info("Start method findUserById");
            return ResponseEntity.ok().body(this.getUserByIdUseCase.getUserById(id));
        }catch (Exception e){
            logger.severe("Error method findUserById - Error - " + e.getMessage());
            return ResponseEntity.badRequest().body("No found user");
        }
    }
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") UUID id){
        try{
            logger.info("Start method delete");
            this.deleteUserUseCase.delete(id);
        }catch(Exception e){
            logger.severe("Error method delete - Error - " + e.getMessage());
        }
    }


}

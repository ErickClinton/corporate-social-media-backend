package com.exampled.corporatesocialmedia.user;

import com.exampled.corporatesocialmedia.user.dto.FindAllUsersDto;
import com.exampled.corporatesocialmedia.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UsersService usersService;

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PostMapping("/create")
    public void save(final @RequestBody UserDto newUser){
        usersService.saveUser(newUser);
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/find-all")
    public List<FindAllUsersDto> getAll(){
        return usersService.findAll();
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/find-by-id/{id}")
    public UsersEntity getById(@PathVariable("id") UUID id){
        return usersService.findById(id);
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") UUID id){
        usersService.delete(id);
    }

}

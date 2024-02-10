package com.exampled.corporatesocialmedia.user;

import com.exampled.corporatesocialmedia.user.dto.CreateUserDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity(name="users")
public class UsersEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;
    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    private String password;

    public void createUser(CreateUserDto user){
        this.name = user.name();
        this.email = user.email();
        this.password = user.password();
    }

}
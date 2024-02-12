package com.exampled.corporatesocialmedia.user;

import com.exampled.corporatesocialmedia.user.dto.UserDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    private String password;

    public void user(UserDto user){
        this.name = user.name();
        this.email = user.email();
        this.password = user.password();
    }

}
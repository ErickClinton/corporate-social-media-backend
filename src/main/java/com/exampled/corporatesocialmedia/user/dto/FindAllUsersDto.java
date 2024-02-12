package com.exampled.corporatesocialmedia.user.dto;

import com.exampled.corporatesocialmedia.user.UsersEntity;

import java.util.UUID;

public record FindAllUsersDto(UUID id, String name, String email, String password) {
    public FindAllUsersDto(UsersEntity usersEntity){
        this(usersEntity.getId(),usersEntity.getName(),usersEntity.getEmail(),usersEntity.getPassword());
    }
}

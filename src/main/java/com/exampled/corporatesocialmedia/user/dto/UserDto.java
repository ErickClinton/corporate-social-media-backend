package com.exampled.corporatesocialmedia.user.dto;


import com.exampled.corporatesocialmedia.enums.UserRoleEnum;

public record UserDto(String name, String email, String password, UserRoleEnum role) {
}

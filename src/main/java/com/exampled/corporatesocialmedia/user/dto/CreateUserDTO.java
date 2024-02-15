package com.exampled.corporatesocialmedia.user.dto;

import com.exampled.corporatesocialmedia.enums.UserRoleEnum;

import java.util.UUID;

public record CreateUserDTO(
        String name,
        String email,
        String password,
        UserRoleEnum role,
        UUID id_squad,
        String contract_type,
        int seniority) {
}

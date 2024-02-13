package com.exampled.corporatesocialmedia.user.dto;

import com.exampled.corporatesocialmedia.enums.UserRoleEnum;
import com.exampled.corporatesocialmedia.user.entities.UsersEntity;

import java.util.UUID;

public record FindAllUsersDTO(UUID id, String name, String email, UserRoleEnum role, int seniority, String contract_type, UUID id_squad) {
    public FindAllUsersDTO(UsersEntity user){
        this(user.getId(), user.getName(), user.getEmail(), user.getRole(), user.getSeniority(), user.getContract_type(), user.getId_squad());
    }
}

package com.exampled.corporatesocialmedia.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.UUID;

public interface UsersRepository extends JpaRepository<UsersEntity,Long> {
    UserDetails findByEmail(String email);
    UsersEntity findById(UUID id);
    void deleteById(UUID id);

}

package com.exampled.corporatesocialmedia.user.repositories;

import com.exampled.corporatesocialmedia.user.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long> {
    UsersEntity findByEmail(String email);
    void deleteById(UUID id);
}

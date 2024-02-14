package com.exampled.corporatesocialmedia.user.repositories;

import com.exampled.corporatesocialmedia.user.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, UUID> {
    UserDetails findByEmail(String email);
    Optional<UsersEntity> findById(UUID id);
    void deleteById(UUID id);
}

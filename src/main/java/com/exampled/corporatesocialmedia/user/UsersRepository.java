package com.exampled.corporatesocialmedia.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsersRepository extends JpaRepository<UsersEntity,Long> {

    UserDetails findByEmail(String email);
}

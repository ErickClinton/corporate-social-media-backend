package com.exampled.corporatesocialmedia.user.useCase;

import com.exampled.corporatesocialmedia.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteUserUseCase {
    @Autowired
    private UserRepository userRepository;

    public void  execute(UUID id){
        this.userRepository.deleteById(id);
    }
}

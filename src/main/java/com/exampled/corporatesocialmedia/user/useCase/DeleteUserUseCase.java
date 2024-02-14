package com.exampled.corporatesocialmedia.user.useCase;

import com.exampled.corporatesocialmedia.user.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteUserUseCase {

    private final UserRepository userRepository;
    public DeleteUserUseCase(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void  execute(UUID id){
        this.userRepository.deleteById(id);
    }
}

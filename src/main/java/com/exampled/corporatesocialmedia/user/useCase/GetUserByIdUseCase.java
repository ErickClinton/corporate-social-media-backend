package com.exampled.corporatesocialmedia.user.useCase;

import com.exampled.corporatesocialmedia.user.dto.GetUserDTO;
import com.exampled.corporatesocialmedia.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetUserByIdUseCase {
    @Autowired
    private UserRepository userRepository;
    public GetUserDTO execute(UUID id) throws Exception {
        var user = this.userRepository.findById(id);
        if(user.isEmpty()) throw new Exception("User not found");
        return new GetUserDTO(user.get());
    }
}

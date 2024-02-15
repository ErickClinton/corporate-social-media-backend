package com.exampled.corporatesocialmedia.user.useCase;

import com.exampled.corporatesocialmedia.user.dto.GetUserDTO;
import com.exampled.corporatesocialmedia.user.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.logging.Logger;

@Service
public class GetUserByIdUseCase {

    private final Logger logger = Logger.getLogger(GetUserByIdUseCase.class.getName());
    private final UserRepository userRepository;
    public GetUserByIdUseCase(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public GetUserDTO getUserById(UUID id){
        logger.info("Start method getUserById - Request - "+ id);
        var user = this.userRepository.findById(id);
        logger.info("Start method getUserById - Response - "+ new GetUserDTO(user.get()));
        return new GetUserDTO(user.get());
    }
}

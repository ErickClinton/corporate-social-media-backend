package com.exampled.corporatesocialmedia.user.useCase;

import com.exampled.corporatesocialmedia.user.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class DeleteUserUseCase {

    private final Logger logger = Logger.getLogger(DeleteUserUseCase.class.getName());
    private final UserRepository userRepository;
    public DeleteUserUseCase(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void delete(UUID id){
        logger.info("Start method delete - request - "+id);
        boolean deleted = this.userRepository.existsById(id);
        if (deleted) {
            this.userRepository.deleteById(id);
            logger.info("End method delete - response - " + id);
        } else {
            logger.warning("Error method delete - Error");
            throw new EntityNotFoundException("Not found user by id - "+id);
        }
    }
}

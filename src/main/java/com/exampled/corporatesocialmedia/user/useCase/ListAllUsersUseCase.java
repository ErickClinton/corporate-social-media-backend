package com.exampled.corporatesocialmedia.user.useCase;

import com.exampled.corporatesocialmedia.user.controllers.UserController;
import com.exampled.corporatesocialmedia.user.dto.GetUserDTO;
import com.exampled.corporatesocialmedia.user.entities.UsersEntity;
import com.exampled.corporatesocialmedia.user.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ListAllUsersUseCase {
    private static final Logger logger = Logger.getLogger(ListAllUsersUseCase.class.getName());

    private final UserRepository userRepository;
    public ListAllUsersUseCase(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<GetUserDTO> getAll(){
            logger.info("Start method ListAllUsersUseCase - Request");
            List<UsersEntity> users = this.userRepository.findAll();
            logger.info("End method ListAllUsersUseCase - Response - "+users);
            return users.stream().map(GetUserDTO::new).toList();
    }
}

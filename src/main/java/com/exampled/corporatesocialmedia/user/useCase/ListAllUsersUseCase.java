package com.exampled.corporatesocialmedia.user.useCase;

import com.exampled.corporatesocialmedia.user.dto.GetUserDTO;
import com.exampled.corporatesocialmedia.user.entities.UsersEntity;
import com.exampled.corporatesocialmedia.user.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllUsersUseCase {

    private final UserRepository userRepository;
    public ListAllUsersUseCase(final UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<GetUserDTO> execute(){
        List<UsersEntity> users = this.userRepository.findAll();
        return users.stream().map(GetUserDTO::new).toList();
    }
}

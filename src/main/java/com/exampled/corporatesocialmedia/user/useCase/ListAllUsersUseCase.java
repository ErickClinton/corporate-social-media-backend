package com.exampled.corporatesocialmedia.user.useCase;

import com.exampled.corporatesocialmedia.user.dto.FindAllUsersDTO;
import com.exampled.corporatesocialmedia.user.entities.UsersEntity;
import com.exampled.corporatesocialmedia.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllUsersUseCase {
    @Autowired
    private UserRepository userRepository;

    public List<FindAllUsersDTO> execute(){
        List<UsersEntity> users = this.userRepository.findAll();
        return users.stream().map(FindAllUsersDTO::new).toList();
    }
}

package com.exampled.corporatesocialmedia.user;

import com.exampled.corporatesocialmedia.user.dto.CreateUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public Void saveUser(CreateUserDto newUser){
        UsersEntity newUserEntity = new UsersEntity();
        this.createUser(newUserEntity,newUser);
        usersRepository.save(newUserEntity);
        return null;
    }

    private Void createUser(UsersEntity userEntity,CreateUserDto newUser){
        userEntity.createUser(newUser);
        return null;
    }

}

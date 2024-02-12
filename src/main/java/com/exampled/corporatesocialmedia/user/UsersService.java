package com.exampled.corporatesocialmedia.user;
import com.exampled.corporatesocialmedia.user.dto.FindAllUsersDto;
import com.exampled.corporatesocialmedia.user.dto.UserDto;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public void saveUser(UserDto newUser){
        UsersEntity newUserEntity = new UsersEntity();
        newUserEntity.user(newUser);
        usersRepository.save(newUserEntity);
    }

    public List<FindAllUsersDto> findAll(){
        return usersRepository.findAll().stream().map(FindAllUsersDto:: new).toList();
   }

    public UsersEntity findById(Long id){
        return usersRepository.findById(id).get();
    }

    public void delete(Long id){
        usersRepository.deleteById(id);
    }
}

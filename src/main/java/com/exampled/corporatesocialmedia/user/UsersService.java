package com.exampled.corporatesocialmedia.user;
import com.exampled.corporatesocialmedia.user.dto.FindAllUsersDto;
import com.exampled.corporatesocialmedia.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public void saveUser(UserDto newUser){
        UsersEntity newUserEntity = new UsersEntity();

        String encryptedPassWord = new BCryptPasswordEncoder().encode(newUser.password());
        newUserEntity.user(newUser,encryptedPassWord);

        usersRepository.save(newUserEntity);
    }

    public List<FindAllUsersDto> findAll(){
        return usersRepository.findAll().stream().map(FindAllUsersDto:: new).toList();
   }

    public UsersEntity findById(UUID id){
        return usersRepository.findById(id);
    }

    public void delete(UUID id){
        usersRepository.deleteById(id);
    }
}

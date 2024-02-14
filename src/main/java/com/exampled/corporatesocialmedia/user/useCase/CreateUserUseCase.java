package com.exampled.corporatesocialmedia.user.useCase;

import com.exampled.corporatesocialmedia.user.dto.CreateUserDTO;
import com.exampled.corporatesocialmedia.user.entities.UsersEntity;
import com.exampled.corporatesocialmedia.user.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {

    private final UserRepository usersRepository;
    public CreateUserUseCase(final UserRepository userRepository){
        this.usersRepository = userRepository;
    }

    public void execute(CreateUserDTO user) throws Exception {
        if(this.usersRepository.findByEmail(user.email()) != null) throw new Exception("User already exists");
        String encryptedPassword = new BCryptPasswordEncoder().encode(user.password());
        var newUser = UsersEntity.builder()
                .email(user.email())
                .password(encryptedPassword)
                .name(user.name())
                .role(user.role())
                .contract_type(user.contract_type())
                .id_squad(user.id_squad())
                .seniority(user.seniority())
                .build();
        this.usersRepository.save(newUser);
    }
}

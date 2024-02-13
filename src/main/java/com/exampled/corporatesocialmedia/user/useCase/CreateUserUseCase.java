package com.exampled.corporatesocialmedia.user.useCase;

import com.exampled.corporatesocialmedia.user.dto.CreateUserDTO;
import com.exampled.corporatesocialmedia.user.entities.UsersEntity;
import com.exampled.corporatesocialmedia.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {
    @Autowired
    private UserRepository usersRepository;
    public void execute(CreateUserDTO dto) throws Exception {
        if(this.usersRepository.findByEmail(dto.email()) != null) throw new Exception("User already exists");
        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.password());
        var user = UsersEntity.builder()
                .email(dto.email())
                .password(encryptedPassword)
                .name(dto.name())
                .role(dto.role())
                .contract_type(dto.contract_type())
                .id_squad(dto.id_squad())
                .seniority(dto.seniority())
                .build();
        this.usersRepository.save(user);
        return;
    }
}

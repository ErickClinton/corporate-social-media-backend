package com.exampled.corporatesocialmedia.user;

import com.exampled.corporatesocialmedia.enums.UserRoleEnum;
import com.exampled.corporatesocialmedia.user.dto.UserDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsersEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    private String password;

    @NotNull
    private UserRoleEnum role;

    public void user(UserDto user, String encryptedPassword){
        this.name = user.name();
        this.email = user.email();
        this.password = encryptedPassword;
        this.role = user.role();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRoleEnum.Admin) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),new SimpleGrantedAuthority("ROLE_MANAGER"),new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
        else if(this.role == UserRoleEnum.Manager) return List.of(new SimpleGrantedAuthority("ROLE_MANAGER"),new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
        else return List.of(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
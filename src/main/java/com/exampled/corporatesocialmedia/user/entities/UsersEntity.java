package com.exampled.corporatesocialmedia.user.entities;

import com.exampled.corporatesocialmedia.enums.UserRoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "users")
public class UsersEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private UserRoleEnum role;
    @Column(nullable = false)
    private int seniority;
    @Column(nullable = false)
    private String contract_type;
    @Column(nullable = false)
    private UUID id_squad;

    public UsersEntity(String email, String name, String password, UserRoleEnum role, String contract_type, UUID id_squad, int seniority) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
        this.contract_type = contract_type;
        this.id_squad = id_squad;
        this.seniority = seniority;
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
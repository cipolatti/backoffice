package com.unitech.backoffice.model;

import com.unitech.backoffice.dto.user.RegisterUserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "user")
@Entity(name = "User")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String login;
    @Setter
    private String password;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleModel> roleModels;

      public UserModel(RegisterUserDto data) {
        this.name = data.name();
        this.login = data.login();
        this.password = data.password();
    }

    public UserModel(String username, String password, Collection<? extends GrantedAuthority> authorities) {
          this.login = username;
          this.password = password;
          this.roleModels = (List<RoleModel>) authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roleModels;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
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

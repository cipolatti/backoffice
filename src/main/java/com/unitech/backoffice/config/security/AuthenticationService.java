package com.unitech.backoffice.config.security;

import com.unitech.backoffice.model.UserModel;
import com.unitech.backoffice.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserModel userModel = userRepository.findByLogin(username);
        return new UserModel(userModel.getUsername(), userModel.getPassword(), userModel.getAuthorities());
    }
}
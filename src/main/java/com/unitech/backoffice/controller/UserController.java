package com.unitech.backoffice.controller;

import com.unitech.backoffice.dto.user.DetailsUserDto;
import com.unitech.backoffice.dto.user.RegisterUserDto;
import com.unitech.backoffice.model.UserModel;
import com.unitech.backoffice.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/user")
public class UserController {
    public UserController(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    private PasswordEncoder encoder;

    @Autowired
    private UserRepository repository;

    @PostMapping
    @Transactional
    @Secured("ROLE_USER")
    public ResponseEntity register(@RequestBody @Valid RegisterUserDto data, UriComponentsBuilder uriBuilder) {
        var user = new UserModel(data);
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
        var uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetailsUserDto(user));
    }
}

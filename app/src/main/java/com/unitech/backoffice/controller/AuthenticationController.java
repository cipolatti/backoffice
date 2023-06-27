package com.unitech.backoffice.controller;

import com.unitech.backoffice.config.security.DataTokenJWTDto;
import com.unitech.backoffice.config.security.TokenService;
import com.unitech.backoffice.dto.authentication.DataAuthenticationDto;
import com.unitech.backoffice.model.UserModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DataAuthenticationDto data) {
        var token = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = manager.authenticate(token);
        var tokenJWT = tokenService.generateToken((UserModel) authentication.getPrincipal());
        return ResponseEntity.ok(new DataTokenJWTDto(tokenJWT));
    }
}

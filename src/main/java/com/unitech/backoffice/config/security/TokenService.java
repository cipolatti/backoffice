package com.unitech.backoffice.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.unitech.backoffice.model.Teacher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(Teacher teacher) {
        try {
            var algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API Unitech.backoffice")
                    .withSubject(teacher.getLogin())
                    .withExpiresAt(dateExpired())
                    .withClaim("id", teacher.getId())
                    .withClaim("name", teacher.getName())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw  new RuntimeException("Erro ao gerar o token jwt. ", exception);
        }
    }

    private Instant dateExpired() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}

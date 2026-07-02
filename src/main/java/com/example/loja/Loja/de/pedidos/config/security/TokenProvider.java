package com.example.loja.Loja.de.pedidos.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.loja.Loja.de.pedidos.model.auth.Roles;
import com.example.loja.Loja.de.pedidos.model.auth.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class TokenProvider {

    @Value("${jwt.key}")
    private String chaveToken;

    @Value("${jwt.expiration}")
    private long expiracao;

    public String generateToken(User user) {
        Date now = new Date();
        Date expirationTime = new Date(now.getTime() + expiracao);

        //Passando o tipo de algoritmo que vai ser usado
        Algorithm algorithm = Algorithm.HMAC256(chaveToken);

        List<String> roles = user.getRoles().stream()
                .map(Roles::getName)
                .toList();

        return JWT.create().withClaim("userId", user.getId())
                .withSubject(user.getEmail())
                .withClaim("roles", roles)
                .withExpiresAt(expirationTime)
                .withIssuedAt(Instant.now())
                .sign(algorithm);
    }

    public Optional<JWTUserData> validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(chaveToken);

            DecodedJWT decode = JWT.require(algorithm).build().verify(token);

            List<String> roles = decode.getClaim("roles").asList(String.class);

            return Optional.of(JWTUserData.builder()
                    .userId(decode.getClaim("userId").asLong())
                    .email(decode.getSubject())
                    .roles(roles)
                    .build());
        } catch (JWTVerificationException e) {
            return Optional.empty();
        }
    }

}

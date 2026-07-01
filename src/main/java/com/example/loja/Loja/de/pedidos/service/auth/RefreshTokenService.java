package com.example.loja.Loja.de.pedidos.service.auth;

import com.example.loja.Loja.de.pedidos.model.auth.RefreshToken;
import com.example.loja.Loja.de.pedidos.model.auth.User;
import com.example.loja.Loja.de.pedidos.repository.auth.RefreshTokenRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    @Value("${jwt.refresh.expiration}")
    private long expirationRefreshToken;

    public RefreshTokenService(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    public RefreshToken createRefreshToken(User user) {
        this.refreshTokenRepository.deleteByUser(user);

        //Salvando refresh token
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setUser(user);
        refreshToken.setExpiryDate(expirationDateRefreshToken());
        return refreshTokenRepository.save(refreshToken);
    }

    //Busca o refresh token pelo token recebido do cliente
    public Optional<RefreshToken> findByToken(String token) {
        return this.refreshTokenRepository.findByToken(token);
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().isBefore(Instant.now())) {
            refreshTokenRepository.delete(token);
            throw new RuntimeException("Refresh token expirado, faça login novamente.");
        }
        return token;
    }

    public Instant expirationDateRefreshToken() {
        return Instant.now().plusMillis(expirationRefreshToken);
    }

}

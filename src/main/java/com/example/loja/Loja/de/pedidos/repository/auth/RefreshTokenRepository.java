package com.example.loja.Loja.de.pedidos.repository.auth;

import com.example.loja.Loja.de.pedidos.model.auth.RefreshToken;
import com.example.loja.Loja.de.pedidos.model.auth.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {

    Optional<RefreshToken> findByToken(String token);

    @Transactional
    void deleteByUser(User user);

}

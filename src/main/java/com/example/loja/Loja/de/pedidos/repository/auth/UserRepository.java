package com.example.loja.Loja.de.pedidos.repository.auth;

import com.example.loja.Loja.de.pedidos.model.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   Optional<UserDetails> findByEmail(String email);

}

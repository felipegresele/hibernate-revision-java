package com.example.loja.Loja.de.pedidos.mapper;

import com.example.loja.Loja.de.pedidos.dto.request.auth.RegisterUserRequestDto;
import com.example.loja.Loja.de.pedidos.dto.response.auth.RegisterUserResponseDto;
import com.example.loja.Loja.de.pedidos.model.auth.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {

    private final PasswordEncoder passwordEncoder;

    public AuthMapper(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterUserResponseDto userToResponse(User user) {
        return RegisterUserResponseDto.builder()
                .name(user.getNome())
                .email(user.getEmail())
                .password(user.getSenha())
                .build();
    }

    public User requestToUser(RegisterUserRequestDto dto) {
        User newUser = new User();
        newUser.setNome(dto.getNome());
        newUser.setEmail(dto.getEmail());
        newUser.setSenha(passwordEncoder.encode(dto.getSenha()));
        return newUser;
    }

}

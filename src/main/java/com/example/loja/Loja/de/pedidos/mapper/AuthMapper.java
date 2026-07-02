package com.example.loja.Loja.de.pedidos.mapper;

import com.example.loja.Loja.de.pedidos.dto.request.auth.RegisterUserRequestDto;
import com.example.loja.Loja.de.pedidos.dto.response.auth.RegisterUserResponseDto;
import com.example.loja.Loja.de.pedidos.model.auth.Roles;
import com.example.loja.Loja.de.pedidos.model.auth.User;
import com.example.loja.Loja.de.pedidos.repository.auth.RolesRepository;
import com.example.loja.Loja.de.pedidos.repository.auth.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
public class AuthMapper {

    private final PasswordEncoder passwordEncoder;
    private final RolesRepository rolesRepository;
    private final UserRepository userRepository;

    public AuthMapper(PasswordEncoder passwordEncoder, RolesRepository rolesRepository, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.rolesRepository = rolesRepository;
        this.userRepository = userRepository;
    }

    public RegisterUserResponseDto userToResponse(User user) {
        return RegisterUserResponseDto.builder()
                .name(user.getNome())
                .email(user.getEmail())
                .password(user.getSenha())
                .roles(user.getRoles())
                .build();
    }

    public User requestToUser(RegisterUserRequestDto dto) {
        Roles role = this.rolesRepository.findById(dto.getRoleId().longValue()).orElseThrow(() -> new RuntimeException("Role invalída"));

        Optional<UserDetails> userExists = this.userRepository.findByEmail(dto.getEmail());
        if (userExists.isPresent()) {
            throw new RuntimeException("Usuário com email já cadastrado!");
        }

        User newUser = new User();
        newUser.setNome(dto.getNome());
        newUser.setEmail(dto.getEmail());
        newUser.setSenha(passwordEncoder.encode(dto.getSenha()));
        newUser.setRoles(Set.of(role));
        return newUser;
    }

}

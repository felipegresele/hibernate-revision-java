package com.example.loja.Loja.de.pedidos.service.auth;

import com.example.loja.Loja.de.pedidos.dto.request.auth.RegisterUserRequestDto;
import com.example.loja.Loja.de.pedidos.dto.response.auth.RegisterUserResponseDto;
import com.example.loja.Loja.de.pedidos.mapper.AuthMapper;
import com.example.loja.Loja.de.pedidos.model.auth.User;
import com.example.loja.Loja.de.pedidos.repository.auth.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    private UserRepository userRepository;
    private AuthMapper authMapper;

    public AuthService(UserRepository userRepository, AuthMapper authMapper) {
        this.userRepository = userRepository;
        this.authMapper = authMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public RegisterUserResponseDto registerUser(RegisterUserRequestDto dto) {
        User userSaved = authMapper.requestToUser(dto);
        this.userRepository.save(userSaved);

        return this.authMapper.userToResponse(userSaved);
    }
}

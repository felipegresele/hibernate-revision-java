package com.example.loja.Loja.de.pedidos.dto.response.auth;

import com.example.loja.Loja.de.pedidos.model.auth.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterUserResponseDto {

    private String name;
    private String email;
    private String password;
    private Set<Roles> roles;

}

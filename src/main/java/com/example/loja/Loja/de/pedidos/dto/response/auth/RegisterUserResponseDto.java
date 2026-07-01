package com.example.loja.Loja.de.pedidos.dto.response.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterUserResponseDto {

    private String name;
    private String email;
    private String password;

}

package com.example.loja.Loja.de.pedidos.config.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JWTUserData {

    private Long userId;
    private String email;

}

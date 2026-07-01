package com.example.loja.Loja.de.pedidos.dto.request.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequestDto {

    @NotBlank
    private String nome;
    @Email
    private String email;
    @NotBlank
    private String senha;

}

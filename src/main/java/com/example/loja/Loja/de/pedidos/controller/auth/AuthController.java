package com.example.loja.Loja.de.pedidos.controller.auth;

import com.example.loja.Loja.de.pedidos.config.security.TokenProvider;
import com.example.loja.Loja.de.pedidos.dto.request.auth.LoginRequestDto;
import com.example.loja.Loja.de.pedidos.dto.request.auth.RefreshTokenRequestDto;
import com.example.loja.Loja.de.pedidos.dto.request.auth.RegisterUserRequestDto;
import com.example.loja.Loja.de.pedidos.dto.response.auth.LoginResponseDto;
import com.example.loja.Loja.de.pedidos.dto.response.auth.RegisterUserResponseDto;
import com.example.loja.Loja.de.pedidos.model.auth.RefreshToken;
import com.example.loja.Loja.de.pedidos.model.auth.User;
import com.example.loja.Loja.de.pedidos.service.auth.AuthService;
import com.example.loja.Loja.de.pedidos.service.auth.RefreshTokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;

    public AuthController(AuthService authService, AuthenticationManager authenticationManager, TokenProvider tokenProvider, RefreshTokenService refreshTokenService) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.refreshTokenService = refreshTokenService;
    }

    @ApiResponse(responseCode = "201")
    @Operation(summary = "Endpoint para registar usuário novo")
    @PostMapping("/register")
    public ResponseEntity<RegisterUserResponseDto> register(@Valid @RequestBody RegisterUserRequestDto dto) {
        RegisterUserResponseDto user = this.authService.registerUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @ApiResponse(responseCode = "200")
    @Operation(summary = "Endpoint para criar Acess Token do usuário autenticado")
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto dto) {
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword());
        Authentication authentication = this.authenticationManager.authenticate(userAndPass);

        User user = (User) authentication.getPrincipal();
        String token = this.tokenProvider.generateToken(user);

        RefreshToken refreshToken = this.refreshTokenService.createRefreshToken(user);

        return ResponseEntity.ok(new LoginResponseDto(token, refreshToken.getToken()));
    }

    @ApiResponse(responseCode = "200")
    @Operation(summary = "Endpoint para revalidar token após tempo de expiração, sem precisar fazer login novamente")
    @PostMapping("/refresh")
    public ResponseEntity<LoginResponseDto> refresh(@Valid @RequestBody RefreshTokenRequestDto dto) {

        RefreshToken refreshToken = this.refreshTokenService.findByToken(dto.getRefreshToken())
                .orElseThrow(() -> new RuntimeException("Refresh token invalido"));

        //Verifica se ainda nao expirou, se sim exclui do banco e lança exceção
        this.refreshTokenService.verifyExpiration(refreshToken);

        //Gera um novo acess token pro dono desse refresh token
        User user = refreshToken.getUser();
        String newAcessToken = this.tokenProvider.generateToken(user);

        return ResponseEntity.ok(new LoginResponseDto(newAcessToken, refreshToken.getToken()));

    }

}

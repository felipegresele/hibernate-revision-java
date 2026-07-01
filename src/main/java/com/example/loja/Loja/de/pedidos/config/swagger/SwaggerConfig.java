package com.example.loja.Loja.de.pedidos.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    public OpenAPI getOpenApi() {

        Info info = new Info();
        info.title("Revisão Spring Boot - Security");
        info.description("API desenvolvida para estudos e aperfeiçoamento do ecossistema Spring. O projeto aplica boas práticas de desenvolvimento, arquitetura em camadas e recursos como Spring Security, Spring Data JPA, Cache, validações e documentação com OpenAPI/Swagger, simulando um ambiente de desenvolvimento real.");

        return new OpenAPI().info(info);

    }

}

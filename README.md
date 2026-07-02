# Loja de Pedidos

API REST desenvolvida em **Spring Boot** para gerenciamento de pedidos, livros, alunos/cursos e autenticação de usuários com JWT.

## 🚀 Tecnologias

- **Java 17**
- **Spring Boot 4.1.0**
  - Spring Data JPA
  - Spring Web (MVC)
  - Spring Security
  - Spring Validation
  - Spring Cache
  - Spring Data Redis
- **PostgreSQL** — banco de dados relacional
- **Flyway** — versionamento e migração de banco de dados
- **JWT (java-jwt)** — autenticação/autorização baseada em token
- **Redis** — utilizado para blacklist de tokens no logout
- **Springdoc OpenAPI (Swagger)** — documentação da API
- **Lombok** — redução de boilerplate
- **Maven** — gerenciador de dependências e build

## 📁 Estrutura do projeto

```
src/main/java/com/example/loja/Loja/de/pedidos
├── config/          # Configurações (CORS, Security, Swagger, JWT)
├── controller/       # Endpoints REST (auth, aluno, item, livro, pedido, usuario)
├── dto/              # Objetos de requisição e resposta
├── enums/             # Enumerações (ex: RolesEnum)
├── mapper/            # Conversão entre entidades e DTOs
├── model/             # Entidades JPA (auth, aluno, livro, pedido)
├── repository/        # Interfaces de acesso a dados (Spring Data JPA)
└── service/           # Regras de negócio
```

## 🔌 Principais endpoints

| Recurso | Rota base | Métodos |
|---|---|---|
| Autenticação | `/auth` | `POST /register`, `POST /login`, `POST /refresh` |
| Usuários | `/api/users` | `GET` |
| Livros | `/api/livro` | `GET`, `GET /{id}`, `POST` |
| Pedidos | `/api/pedido` | `GET`, `GET /{id}`, `POST` |
| Itens | `/api/item` | `GET`, `GET /{id}`, `POST` |
| Alunos | `/api/aluno` | `GET`, `GET /{id}`, `POST` |
| Cursos | `/api/curso` | `GET`, `GET /{id}`, `POST` |

A documentação interativa (Swagger UI) fica disponível em:
```
http://localhost:8080/swagger/index.html
```

## ⚙️ Configuração

O projeto usa o arquivo `src/main/resources/application.properties`. As principais variáveis são:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/estudos
spring.datasource.username=postgres
spring.datasource.password=1234

jwt.key=${JWT_KEY}
jwt.expiration=300000
jwt.refresh.expiration=3600000
```

> ⚠️ **Antes de rodar**, defina a variável de ambiente `JWT_KEY` com uma chave secreta e ajuste usuário/senha do banco conforme seu ambiente. Evite versionar credenciais reais em produção.

### Pré-requisitos

- Java 17+
- Maven (ou use o wrapper `./mvnw`)
- PostgreSQL rodando localmente (banco `estudos`, ou ajuste o nome na configuração)
- Redis rodando localmente (usado para blacklist de tokens)

## ▶️ Como executar

```bash
# clonar o repositório
git clone <url-do-repositorio>
cd Loja-de-pedidos

# configurar variável de ambiente da chave JWT
export JWT_KEY=sua_chave_secreta

# rodar a aplicação
./mvnw spring-boot:run
```

A aplicação sobe por padrão em `http://localhost:8080`.

## 🧪 Testes

```bash
./mvnw test
```

## 📄 Licença

Projeto de estudo — sinta-se à vontade para adaptar conforme necessário.

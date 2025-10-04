# Thomas Pereira - Web API

Aplicação Spring Boot multi-módulo para gerenciamento de vendedores, endereços e pagamentos, com integração a APIs externas.


## 🎯 Sobre o Projeto

Sistema de gerenciamento que integra funcionalidades de:
- Cadastro e consulta de vendedores
- Busca de endereços via CEP (OpenCEP API)
- Processamento de pagamentos (Cielo API)
- Gerenciamento de extratos de pagamento

## 🏗️ Arquitetura

O projeto utiliza arquitetura multi-módulo Maven para melhor organização e separação de responsabilidades:

```
thomaspereira-parent
│
├── common-domain      → Entidades, DTOs e interfaces compartilhadas
├── external-api       → Feign Clients para APIs externas
└── main-app          → Aplicação principal (Controllers, Services, Repositories)
```

### Fluxo de Dependências

```
common-domain (base)
    ↑
external-api (Feign Clients)
    ↑
main-app (aplicação principal)
```

## 🚀 Tecnologias

- **Java 17**
- **Spring Boot 3.5.6**
- **Spring Cloud 2025.0.0**
- **Spring Data JPA**
- **Spring Cloud OpenFeign**
- **H2 Database** (em memória)
- **Maven**

## 📦 Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code)

## ⚙️ Instalação

1. Clone o repositório:
```bash
git clone https://github.com/thovipe/thomaspereira-parent.git
cd thomaspereira-parent
```


## 🔧 Configuração

Crie ou edite o arquivo `main-app/src/main/resources/application.properties`:

```properties
# Server Configuration
server.port=8080

# Database H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# OpenCEP API
opencep.url=https://opencep.com/v1

# Cielo API
cielo.url=https://apisandbox.cieloecommerce.cielo.com.br


```
**Collection**  
thomaspereiraapi.postman_collection.json

## 📝 Licença

Este projeto é de uso educacional.

## 👤 Autor

Thomas Pereira

---

⭐ Se este projeto foi útil, considere dar uma estrela!
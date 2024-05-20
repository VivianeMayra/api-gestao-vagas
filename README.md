# API Gestão de Vagas

O projeto **API Gestão de Vagas** é um serviço web RESTful desenvolvido com Spring Boot, projetado para gerenciar candidaturas de profissionais à vagas disponibilizadas por empresas.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Spring Boot**: Framework utilizado para construir a API.
- **Hibernate**: ORM para interações com o banco de dados.
- **Spring Security**: Biblioteca utilizada para autenticação e autorização de candidatos e empresas.
- **JPA**: API de Persistência Java para persistência de dados.
- **Lombok**: Reduz código boilerplate para classes modelo.
- **PostgreSQL**: Banco de dados utilizado para armazenar os dados dos candidatos, empresas e vagas.
- **Docker**: Utilizado para criar e gerenciar o banco de dados PostgresSQL.

## Começando

### Pré-requisitos

- Java 17 ou superior instalado.
- Maven instalado.
- Docker instalado.

### Instalação e Execução

1. **Clone o repositório**:

   ```bash
   git clone https://github.com/seudonome/api-gestao-vagas.git
   cd api-gestao-vagas
   ```

2. **Configure o banco de dados usando Docker**:

- Crie e inicie um contêiner Docker com PostgresSQL:

  ```bash
    docker run --name postgres-db -e POSTGRES_DB=apigestaovagas -e POSTGRES_USER=yourusername -e POSTGRES_PASSWORD=yourpassword -p 5432:5432 -d postgres
  ```

- Atualize o arquivo application.properties com os detalhes do seu banco de dados:

  ```bash
  spring.datasource.url=jdbc:postgresql://localhost:5432/apigestaovagas
  spring.datasource.username=yourusername
  spring.datasource.password=yourpassword
  spring.jpa.hibernate.ddl-auto=update
  ```

3. **Construa e execute a aplicação**

```bash
 ./mvnw spring-boot:run
```

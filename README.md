# TP3 - PetFriends

Este projeto é o **Trabalho Prático 3** do curso de **Domain-Driven Design (DDD) e Arquitetura de Softwares Escaláveis com Java**.  
Ele consiste em um sistema de pedidos para o contexto de **PetFriends**, utilizando **Spring Boot**, **Axon Framework**, **CQRS**, **Event Sourcing** e **JPA/H2**.

---

## Estrutura do Projeto

- `commands/` → Commands e base de Commands  
- `events/` → Eventos e base de Eventos  
- `aggregates/` → Aggregates com CommandHandler e EventSourcingHandler  
- `service/` → Serviços que enviam Commands  
- `query/` → Serviços de consulta (Query)  
- `repository/` → Interfaces JpaRepository  
- `controller/` → Controllers REST para Commands e Queries

---

## Tecnologias Utilizadas

- Java 17  
- Spring Boot  
- Axon Framework  
- Spring Data JPA / H2  
- Maven  
- Git / GitHub

---

## Como Rodar

1. Clonar o repositório:

```bash
git clone https://github.com/johanna0593/V---Domain-Driven-Design-Tp3.git
cd V---Domain-Driven-Design-Tp3
Rodar via IntelliJ ou Maven:

bash
Copiar código
mvn spring-boot:run
Acesse o Swagger (se disponível) em: http://localhost:8080/swagger-ui.html

Use Postman ou Insomnia para testar:

json
Copiar código
POST http://localhost:8080/api/pedidos
{
  "nomeCliente": "Johanna",
  "valorTotal": 120.0
}

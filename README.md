# TP3 - PetFriends

Este projeto é o **Trabalho Prático 3** do curso de **Domain-Driven Design (DDD) e Arquitetura de Softwares Escaláveis com Java**.  
Ele consiste em um sistema de pedidos para o contexto de **PetFriends**, utilizando **Spring Boot**, **Axon Framework**, **CQRS**, **Event Sourcing** e **JPA/H2**.

---

## Questões do TP3

1. **Classe base de evento:** Crie um trecho de código Java para uma classe base de um evento a ser persistido em um event store.  
2. **Classe base de command:** Crie um trecho de código Java para uma classe base de um command que vai provocar a persistência de um evento em um event store.  
3. **Classe de evento:** Crie um trecho de código Java para uma classe que estenda a classe base de evento da questão 2.  
4. **Classe de command:** Crie um trecho de código Java para uma classe que estenda a classe base de command da questão 3.  
5. **Classe command service:** Crie uma classe de serviço que utilize o CommandGateway para executar o command criado na questão 3.  
6. **Classe do agregado 1:** Crie um trecho de código Java para uma classe que implemente um CommandHandler que use o command criado na questão 5.  
7. **Classe do agregado 2:** Crie na mesma classe da questão 6 para implementar um EventSourcingHandler que responda à criação do evento da questão 4.  
8. **Classe query service 1:** Crie um serviço de consulta que mostre todos os eventos da entidade criada na questão 7.  
9. **Interface repository:** Crie um JpaRepository para cuidar da persistência da entidade criada na questão 7.  
10. **Classe query service 2:** Crie no serviço de consulta da questão 10 um método para obter o registro da entidade da questão 7 pelo ID.  
11. **Classe Rest Controller 1:** Crie uma rota Rest em um controller que execute o command criado na questão 3.  
12. **Classe Rest Controller:** Crie uma rota Rest em um controller que execute a query criada na questão 8 e outra que execute a query da questão 10.

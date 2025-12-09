package com.petfriends.petfriends_tp3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "PetFriends - Pedido API", version = "1.0", description = "APIs para o agregado Pedido"))
public class PetfriendsApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetfriendsApplication.class, args);
    }
}

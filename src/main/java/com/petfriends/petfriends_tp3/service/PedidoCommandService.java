package com.petfriends.petfriends_tp3.service;

import com.petfriends.petfriends_tp3.command.CriarPedidoCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class PedidoCommandService {

    private final CommandGateway commandGateway;

    public PedidoCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public CompletableFuture<String> criarPedido(CriarPedidoCommand cmd) {
        return commandGateway.send(cmd);
    }
}

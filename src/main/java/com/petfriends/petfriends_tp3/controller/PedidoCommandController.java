package com.petfriends.petfriends_tp3.controller;

import com.petfriends.petfriends_tp3.command.CriarPedidoCommand;
import com.petfriends.petfriends_tp3.service.PedidoCommandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoCommandController {

    private final PedidoCommandService commandService;

    public PedidoCommandController(PedidoCommandService commandService) {
        this.commandService = commandService;
    }

    @PostMapping
    public ResponseEntity<String> criarPedido(@RequestBody CriarPedidoRequest body) throws ExecutionException, InterruptedException {
        String pedidoId = UUID.randomUUID().toString();
        CriarPedidoCommand cmd = new CriarPedidoCommand(pedidoId, body.getClienteId(), body.getItens(), body.getTotal());
        String result = commandService.criarPedido(cmd).get();
        return ResponseEntity.ok(result == null ? pedidoId : result);
    }

    public static class CriarPedidoRequest {
        private String clienteId;
        private List<String> itens;
        private double total;

        public String getClienteId() { return clienteId; }
        public void setClienteId(String clienteId) { this.clienteId = clienteId; }
        public List<String> getItens() { return itens; }
        public void setItens(List<String> itens) { this.itens = itens; }
        public double getTotal() { return total; }
        public void setTotal(double total) { this.total = total; }
    }
}

package com.petfriends.petfriends_tp3.controller;

import com.petfriends.petfriends_tp3.query.PedidoQueryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoQueryController {

    private final PedidoQueryService queryService;

    public PedidoQueryController(PedidoQueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping("/eventos")
    public Object listarEventos() {
        return queryService.listarTodosEventos();
    }

    @GetMapping("/{id}")
    public Object buscarPorId(@PathVariable String id) {
        return queryService.buscarPorId(id);
    }
}

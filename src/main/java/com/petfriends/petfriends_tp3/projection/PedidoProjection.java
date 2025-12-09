package com.petfriends.petfriends_tp3.projection;

import com.petfriends.petfriends_tp3.entity.PedidoEntity;
import com.petfriends.petfriends_tp3.repository.PedidoRepository;
import com.petfriends.petfriends_tp3.event.PedidoCriadoEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class PedidoProjection {

    private final PedidoRepository repository;

    public PedidoProjection(PedidoRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(PedidoCriadoEvent event) {
        PedidoEntity p = new PedidoEntity();
        p.setId(event.getPedidoId());
        p.setClienteId(event.getClienteId());
        p.setItens(event.getItens());
        p.setTotal(event.getTotal());
        p.setStatus(event.getStatus());
        repository.save(p);
    }
}

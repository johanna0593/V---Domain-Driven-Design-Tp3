package com.petfriends.petfriends_tp3.aggregate;

import com.petfriends.petfriends_tp3.command.CriarPedidoCommand;
import com.petfriends.petfriends_tp3.event.PedidoCriadoEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.List;

@Aggregate
public class PedidoAggregate {

    @AggregateIdentifier
    private String pedidoId;
    private String clienteId;
    private List<String> itens;
    private double total;
    private String status;

    public PedidoAggregate() {} // construtor vazio exigido

    @CommandHandler
    public PedidoAggregate(CriarPedidoCommand cmd) {
        if (cmd.getItens() == null || cmd.getItens().isEmpty()) {
            throw new IllegalArgumentException("Pedido deve ter ao menos um item");
        }
        if (cmd.getTotal() <= 0) {
            throw new IllegalArgumentException("Total do pedido deve ser positivo");
        }

        PedidoCriadoEvent evt = new PedidoCriadoEvent(
                cmd.getAggregateId(),
                cmd.getClienteId(),
                cmd.getItens(),
                cmd.getTotal()
        );

        AggregateLifecycle.apply(evt);
    }

    @EventSourcingHandler
    public void on(PedidoCriadoEvent evt) {
        this.pedidoId = evt.getAggregateId();
        this.clienteId = evt.getClienteId();
        this.itens = evt.getItens();
        this.total = evt.getTotal();
        this.status = evt.getStatus();
    }
}

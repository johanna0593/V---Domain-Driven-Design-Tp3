package com.petfriends.petfriends_tp3.event;

import com.petfriends.petfriends_tp3.entity.PedidoEntity;
import com.petfriends.petfriends_tp3.repository.PedidoRepository;
import com.petfriends.petfriends_tp3.command.CriarPedidoCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class PedidoCriadoEvent extends EventBase {
    private final String pedidoId;
    private final String clienteId;
    private final List<String> itens;
    private final double total;
    private final String status;

    public PedidoCriadoEvent(String pedidoId, String clienteId, List<String> itens, double total) {
        super(pedidoId, 1);
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
        this.itens = itens;
        this.total = total;
        this.status = "CRIADO";
    }

    public String getPedidoId() { return pedidoId; }
    public String getClienteId() { return clienteId; }
    public List<String> getItens() { return itens; }
    public double getTotal() { return total; }
    public String getStatus() { return status; }

    @Aggregate
    public static class PedidoAggregate {

        @AggregateIdentifier
        private String pedidoId;
        private String clienteId;
        private List<String> itens;
        private double total;
        private String status;

        // construtor vazio exigido por Axon
        public PedidoAggregate() {}

        // CommandHandler: cria o agregado aplicando o evento
        @CommandHandler
        public PedidoAggregate(CriarPedidoCommand cmd) {
            if (cmd.getItens() == null || cmd.getItens().isEmpty()) {
                throw new IllegalArgumentException("Pedido precisa ter pelo menos um item");
            }
            if (cmd.getTotal() <= 0) {
                throw new IllegalArgumentException("Total do pedido deve ser positivo");
            }
            PedidoCriadoEvent evt = new PedidoCriadoEvent(cmd.getPedidoId(), cmd.getClienteId(), cmd.getItens(), cmd.getTotal());
            AggregateLifecycle.apply(evt);
        }

        @EventSourcingHandler
        public void on(PedidoCriadoEvent evt) {
            this.pedidoId = evt.getPedidoId();
            this.clienteId = evt.getClienteId();
            this.itens = evt.getItens();
            this.total = evt.getTotal();
            this.status = evt.getStatus();
        }

    }

    @Service
    public static class PedidoQueryService {

        private final PedidoRepository repository;

        public PedidoQueryService(PedidoRepository repository) {
            this.repository = repository;
        }

        // questão 8: retorna todos os pedidos (projeção)
        public List<PedidoEntity> findAll() {
            return repository.findAll();
        }

        // questão 10: buscar por id (método pedido)
        public Optional<PedidoEntity> findById(String id) {
            return repository.findById(id);
        }
    }
}

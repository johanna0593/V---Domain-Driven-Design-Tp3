package com.petfriends.petfriends_tp3.command;

import com.petfriends.petfriends_tp3.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class CriarPedidoCommand extends CommandBase {
    private final String clienteId;
    private final List<String> itens;
    private final double total;

    public CriarPedidoCommand(String pedidoId, String clienteId, List<String> itens, double total) {
        super(pedidoId);
        this.clienteId = clienteId;
        this.itens = itens;
        this.total = total;
    }

    public String getPedidoId() { return getAggregateId(); }
    public String getClienteId() { return clienteId; }
    public List<String> getItens() { return itens; }
    public double getTotal() { return total; }

    public static interface PedidoRepository extends JpaRepository<PedidoEntity, String> {
    }
}

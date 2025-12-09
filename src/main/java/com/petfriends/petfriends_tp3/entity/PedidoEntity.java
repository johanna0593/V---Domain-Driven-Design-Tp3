package com.petfriends.petfriends_tp3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;

import java.util.List;

@Entity(name = "pedidos")
public class PedidoEntity {

    @Id
    private String id;
    private String clienteId;
    private double total;
    private String status;

    @ElementCollection
    @CollectionTable(name = "pedido_itens", joinColumns = @JoinColumn(name = "pedido_id"))
    @Column(name = "item")
    private List<String> itens;

    // getters e setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getClienteId() { return clienteId; }
    public void setClienteId(String clienteId) { this.clienteId = clienteId; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<String> getItens() { return itens; }
    public void setItens(List<String> itens) { this.itens = itens; }
}

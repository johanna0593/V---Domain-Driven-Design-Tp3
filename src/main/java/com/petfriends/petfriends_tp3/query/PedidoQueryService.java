// src/main/java/com/petfriends/petfriends_tp3/query/PedidoQueryService.java
package com.petfriends.petfriends_tp3.query;

import com.petfriends.petfriends_tp3.entity.PedidoEntity;
import com.petfriends.petfriends_tp3.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoQueryService {

    private final PedidoRepository repository;

    public PedidoQueryService(PedidoRepository repository) {
        this.repository = repository;
    }

    public List<PedidoEntity> listarTodosEventos() {
        return repository.findAll();
    }

    public Optional<PedidoEntity> buscarPorId(String id) {
        return repository.findById(id);
    }
}

package com.petfriends.petfriends_tp3.repository;

import com.petfriends.petfriends_tp3.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, String> {

}

package com.utn.persistenciaJPA.repositorios;

import com.utn.persistenciaJPA.entidades.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido,Long> {
}

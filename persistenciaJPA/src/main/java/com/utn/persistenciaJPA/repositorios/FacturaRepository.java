package com.utn.persistenciaJPA.repositorios;

import com.utn.persistenciaJPA.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FacturaRepository extends JpaRepository<Factura,Long> {
}

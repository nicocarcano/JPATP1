package com.utn.persistenciaJPA.repositorios;

import com.utn.persistenciaJPA.entidades.Cliente;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

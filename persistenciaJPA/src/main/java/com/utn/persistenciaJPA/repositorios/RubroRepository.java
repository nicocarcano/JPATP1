package com.utn.persistenciaJPA.repositorios;

import com.utn.persistenciaJPA.entidades.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RubroRepository extends JpaRepository<Rubro,Long> {
}

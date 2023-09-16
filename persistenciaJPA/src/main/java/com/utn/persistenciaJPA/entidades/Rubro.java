package com.utn.persistenciaJPA.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rubro extends BaseEntidad {
    private String denominacion;


    //RELACION ONE TO MANY DE RUBRO A PRODUCTO

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)

    @JoinColumn(name = "rubro_id")

    @Builder.Default
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto produ) {

        productos.add(produ);

    }
}









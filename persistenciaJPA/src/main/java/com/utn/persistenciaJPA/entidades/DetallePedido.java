package com.utn.persistenciaJPA.entidades;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetallePedido extends BaseEntidad{
    private int cantidad;
    private double subtotal;

    @ManyToOne()
    @JoinColumn(name="producto_id")
    private Producto productos;
}

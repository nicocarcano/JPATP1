package com.utn.persistenciaJPA.entidades;

import com.fasterxml.jackson.databind.ser.Serializers;
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
public class Pedido extends BaseEntidad {
    private Estado estado;
    private String fecha;
    private TipoEnvio tipoEnvio;
    private double total;


    public enum Estado {Iniciado, Preparacion, Entregado}

    public enum TipoEnvio {delivery, retiro}

    //RELACION ONE TO MANY DE PEDIDO A DETALLEPEDIDO

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)

    @JoinColumn(name = "pedido_id")

    @Builder.Default
    private List<DetallePedido> detalles = new ArrayList<>();

    public void agregarDetalle(DetallePedido deta) {

        detalles.add(deta);
    }


    public void mostrarDetalle() {
        System.out.println("Detalles de " + getId());
        for (DetallePedido detallePedido : detalles) {
            System.out.println("Cantidad: " + detallePedido.getCantidad() + ", subtotal: " + detallePedido.getSubtotal());
        }


    }

    //RELACION ONE TO ONE PEDIDO A FACTURA

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "factura_id")
    private Factura factura;

    public void mostrarFactura() {
        System.out.println("Factura de " + getId() + "es: "+ factura.getNumero());
    }
}
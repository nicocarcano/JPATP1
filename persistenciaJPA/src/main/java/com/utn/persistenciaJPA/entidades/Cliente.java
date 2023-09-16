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
public class Cliente extends BaseEntidad{

    private String nombre;
    private String apellido;
    private int telefono;
    private String email;

    //RELACION ONE TO MANY DE CLIENTE A DOMICILIO

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)

    @JoinColumn(name = "cliente_id")

    @Builder.Default
    private List<Domicilio> domicilios = new ArrayList<>();

    public void agregarDomicilio(Domicilio domi){

        domicilios.add(domi);
    }


    public void mostrarDomicilios() {
        System.out.println("Domicilios de " + nombre + " " + apellido + ":");
        for (Domicilio domicilio : domicilios) {
            System.out.println("Calle: " + domicilio.getCalle() + ", Número: " + domicilio.getNumero());
        }


    }

    //RELACION ONE TO MANY DE CLIENTE A PEDIDO

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)

    @JoinColumn(name = "cliente_id")

    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    public void agregarPedido(Pedido pedi){

        pedidos.add(pedi);
    }


    public void mostrarPedido() {
        System.out.println("Pedidos de " + nombre + " " + apellido + ":");
        for (Pedido pedido : pedidos) {
            System.out.println("Estado: " + pedido.getEstado() + ", fecha: " + pedido.getFecha() + ", Tipo de envio: " + pedido.getTipoEnvio() + ", Total: " + pedido.getTotal());
        }


    }


}

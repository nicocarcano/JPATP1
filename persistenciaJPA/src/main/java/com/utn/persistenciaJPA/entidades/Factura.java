package com.utn.persistenciaJPA.entidades;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura extends BaseEntidad{

    private int numero;
    private String fecha;
    private double descuento;
    private FormaPago formaPago;
    private int totalFactura;

    public enum FormaPago{efectivo, mercadopago}

}

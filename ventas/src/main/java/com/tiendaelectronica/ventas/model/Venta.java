package com.tiendaelectronica.ventas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
public class Venta {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long idVenta;
    @Temporal(TemporalType.DATE)
    private LocalDate fechaVenta;
    private Long idCarrito;
}

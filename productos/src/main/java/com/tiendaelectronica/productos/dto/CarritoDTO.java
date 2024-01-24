package com.tiendaelectronica.productos.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarritoDTO {
    private Long id;
    private double total;
    private List<Long> idProductos;
}

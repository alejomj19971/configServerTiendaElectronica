package com.tiendaelectronica.ventas.dto;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class CarritoDTO {

    private Long id;
    private double total;
    private List<Long> idProductos;
    
}

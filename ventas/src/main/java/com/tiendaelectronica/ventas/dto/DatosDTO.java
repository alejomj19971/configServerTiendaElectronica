package com.tiendaelectronica.ventas.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DatosDTO {

    private Long idVenta;
    private Long idCarrito;
    private double total;
    private LocalDate fechaVenta;
    private List<Long> idProductos;
    private List<ProductoDTO>productos;


}

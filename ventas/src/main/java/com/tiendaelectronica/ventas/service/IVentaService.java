package com.tiendaelectronica.ventas.service;

import com.tiendaelectronica.ventas.dto.CarritoDTO;
import com.tiendaelectronica.ventas.dto.DatosDTO;
import com.tiendaelectronica.ventas.model.Venta;

import java.util.List;

public interface IVentaService {

    public String crearVenta(Venta venta);
    public List<Venta> traerVentas();

    public Venta buscarVenta(Long idVenta);

    public String eliminarVenta(Long idVenta);

    public Venta editarVenta(Venta venta);

    public DatosDTO traerDatos(Long idVenta);

    public CarritoDTO traerCarrito(long idCarrito);

}

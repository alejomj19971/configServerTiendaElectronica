package com.tiendaelectronica.carrito.service;

import com.tiendaelectronica.carrito.model.Carrito;

import java.util.List;

public interface ICarritoService {
    public List<Carrito> traerCarritos();
    public Carrito buscarCarrito(Long id);
    public String crearCarrito(Carrito carrito);

    public String eliminarCarrito(Long carrito);

    public Carrito editarCarrito(Carrito carrito);

    public Carrito  agregarProducto(Long id,Long codigo);

    public Carrito  eliminarProducto(Long id,Long codigo);
}

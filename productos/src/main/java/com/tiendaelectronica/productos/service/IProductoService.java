package com.tiendaelectronica.productos.service;

import com.tiendaelectronica.productos.model.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> traerProductos();
    public Producto buscarProducto(Long codigo);
    public String crearProducto(Producto producto);

    public String eliminarProducto(Long codigo);

    public Producto editarProducto(Producto producto);
}

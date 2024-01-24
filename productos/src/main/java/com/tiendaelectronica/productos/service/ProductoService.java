package com.tiendaelectronica.productos.service;


import com.tiendaelectronica.productos.model.Producto;
import com.tiendaelectronica.productos.respository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {


    @Autowired
    IProductoRepository productoRepo;
    @Override
    public List<Producto> traerProductos() {
        return productoRepo.findAll();
    }

    @Override
    public Producto buscarProducto(Long codigo) {
        return productoRepo.findById(codigo).orElse(null);
    }

    @Override
    public String crearProducto(Producto producto) {
        productoRepo.save(producto);
        return "Producto creado correctamente";
    }

    @Override
    public String eliminarProducto(Long codigo) {

        productoRepo.deleteById(codigo);
        return "Producto eliminado correctamente";
    }

    @Override
    public Producto editarProducto(Producto producto) {
        Producto productoEncontrado = productoRepo.findById(producto.getCodigo()).orElse(null);
        productoEncontrado.setNombre(producto.getNombre());
        productoEncontrado.setMarca(producto.getMarca());
        productoEncontrado.setPrecio(producto.getPrecio());
        return productoEncontrado;
    }
}

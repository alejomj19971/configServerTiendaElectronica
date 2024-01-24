package com.tiendaelectronica.productos.controller;

import com.tiendaelectronica.productos.dto.CarritoDTO;
import com.tiendaelectronica.productos.model.Producto;
import com.tiendaelectronica.productos.respository.IProductoRepository;
import com.tiendaelectronica.productos.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Value("${server.port}")
    private int serverPort;
    @Autowired
    IProductoService productoService;

    @Autowired
    IProductoRepository productoRepo;

    @GetMapping("/traer")
    public List<Producto> traerLosProductos(){
        System.out.println("Estoy en : "+serverPort);
        return productoService.traerProductos();
    }
    @GetMapping("/buscar/{codigo}")
    public Producto buscarUnProducto(@PathVariable Long codigo){
        return productoService.buscarProducto(codigo);
    }

    @PostMapping("/crear")
    public String crearUnProducto(@RequestBody Producto producto){

        productoService.crearProducto(producto);
        return " Producto creado exitosamente";
    }

    @GetMapping("/traer/carrito")
    public List<Producto> traerProductosDeCarrito(@RequestParam List<Long> idProductos){
        System.out.println("Estamos en el puerto : "+serverPort);
        return productoRepo.buscarProductosPorIdProductos(idProductos);

    }



}

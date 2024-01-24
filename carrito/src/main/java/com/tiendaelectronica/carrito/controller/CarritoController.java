package com.tiendaelectronica.carrito.controller;

import com.tiendaelectronica.carrito.dto.ProductoDTO;
import com.tiendaelectronica.carrito.model.Carrito;
import com.tiendaelectronica.carrito.repository.ICarritoRepository;
import com.tiendaelectronica.carrito.repository.IProductoClient;
import com.tiendaelectronica.carrito.service.ICarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carritos")
public class CarritoController {
     @Autowired
     ICarritoService carritoService;

     @Value("${server.port}")
     private int serverPort;
     @Autowired
     ICarritoRepository carroRepo;
     @Autowired
     IProductoClient productoClient;
     @GetMapping("/traer")
    public List<Carrito> traerLosCarritos(){

         return carritoService.traerCarritos();
     }
     @GetMapping("/traer/carrito")
    public Carrito buscarUnCarrito(@RequestParam Long id){
         System.out.println("Estoy en "+serverPort);
         return carroRepo.getCarritoById(id);
     }
     @PostMapping("/crear")
    public String crearUncarrito(@RequestBody Carrito carrito){


         carritoService.crearCarrito(carrito);

         return " Carrito creado exitosamente";
     }

    @PutMapping("/agregar/producto")
    public Carrito agregarUnProducto(@RequestParam Long id,@RequestParam Long codigo){
         return carritoService.agregarProducto(id, codigo);

    }

    @PutMapping("/eliminar/producto")
    public Carrito eliminarProducto(@RequestParam Long id,@RequestParam Long codigo){
        return carritoService.eliminarProducto(id, codigo);

    }

    @GetMapping("/traer/lista")
    public List<ProductoDTO> traerListaDeProductos(@RequestParam Long id){
         Carrito carrito= this.buscarUnCarrito(id);
         return productoClient.getProductsByCarId(carrito.getIdProductos());
    }




}

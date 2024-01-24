package com.tiendaelectronica.ventas.controller;

import com.tiendaelectronica.ventas.dto.CarritoDTO;
import com.tiendaelectronica.ventas.dto.DatosDTO;
import com.tiendaelectronica.ventas.model.Venta;
import com.tiendaelectronica.ventas.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {


    @Autowired
    IVentaService ventaService;


    @GetMapping("/traer/datos/{idVenta}")
    public DatosDTO traerDatosVenta(@PathVariable Long idVenta){

        return ventaService.traerDatos(idVenta);

    }

    @GetMapping("/traer")
    public List<Venta> traerLasVentas(){

        return ventaService.traerVentas();
    }

    @PostMapping("/crear")
    public String crearVenta(@RequestBody  Venta venta){
        ventaService.crearVenta(venta);
        return "Venta creada correctamente";
    }

    @GetMapping("traer/carrito")
    public CarritoDTO traerElCarrito(@RequestParam Long idCarrito){


        return ventaService.traerCarrito(idCarrito);
    }





}

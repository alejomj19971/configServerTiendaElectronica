package com.tiendaelectronica.ventas.service;

import com.tiendaelectronica.ventas.dto.CarritoDTO;
import com.tiendaelectronica.ventas.dto.DatosDTO;
import com.tiendaelectronica.ventas.dto.ProductoDTO;
import com.tiendaelectronica.ventas.model.Venta;
import com.tiendaelectronica.ventas.repository.ICarritoClient;
import com.tiendaelectronica.ventas.repository.IProductClient;
import com.tiendaelectronica.ventas.repository.IVentaRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService implements IVentaService {

   @Autowired
   IVentaRepository ventaRepo;

   @Autowired
   ICarritoClient carritoClient;

   @Autowired
   IProductClient productClient;

    @Override
    public String crearVenta(Venta venta) {

        ventaRepo.save(venta);
        return "Venta creada correctamente";
    }

    @Override
    public List<Venta> traerVentas() {
        return ventaRepo.findAll();
    }

    @Override
    public Venta buscarVenta(Long idVenta) {
        return ventaRepo.findById(idVenta).orElse(null);
    }

    @Override
    public String eliminarVenta(Long idVenta) {
        ventaRepo.deleteById(idVenta);
        return "Venta eliminada correctamente";
    }

    @Override
    public Venta editarVenta(Venta venta) {
        Venta ventaEncontrada =this.buscarVenta(venta.getIdVenta());
        ventaEncontrada.setFechaVenta(venta.getFechaVenta());
        ventaEncontrada.setIdCarrito(venta.getIdCarrito());
        ventaRepo.save(ventaEncontrada);
        return ventaEncontrada;
    }

    @Override

    public DatosDTO traerDatos(Long idVenta) {
        //Buscar la venta

        Venta venta =ventaRepo.findById(idVenta).orElse(null);
        CarritoDTO carrito= carritoClient.traerElcarrito(venta.getIdCarrito());
        createException();

        List<ProductoDTO>productos=productClient.getProductsByCarId(carrito.getIdProductos());

        DatosDTO datos=new DatosDTO();
        datos.setIdProductos(carrito.getIdProductos());
        datos.setIdVenta(venta.getIdVenta());
        datos.setIdCarrito(carrito.getId());
        datos.setFechaVenta(venta.getFechaVenta());
        datos.setProductos(productos);
        datos.setTotal(carrito.getTotal());

        return datos;
    }

    @Override
    @CircuitBreaker(name ="carritos-service",fallbackMethod = "fallbackGetCarrito")
    @Retry(name = "carritos-service")
    public CarritoDTO traerCarrito(long idCarrito) {


        return carritoClient.traerElcarrito(idCarrito);
    }

    public CarritoDTO fallbackGetCarrito(Throwable throwable){

        CarritoDTO carritoMalo= new CarritoDTO();
        List<Long> listaIdsMalos= new ArrayList<>();
        listaIdsMalos.add(0L);
        carritoMalo.setId(0L);
        carritoMalo.setTotal(0000);
        carritoMalo.setIdProductos(listaIdsMalos);

        return carritoMalo;

    }

    public void createException(){

        throw  new IllegalArgumentException("Prueba Resiliencia y Circuit breaker");

    }
}

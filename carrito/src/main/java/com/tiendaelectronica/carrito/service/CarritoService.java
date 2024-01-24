package com.tiendaelectronica.carrito.service;

import com.tiendaelectronica.carrito.dto.ProductoDTO;
import com.tiendaelectronica.carrito.model.Carrito;
import com.tiendaelectronica.carrito.repository.ICarritoRepository;
import com.tiendaelectronica.carrito.repository.IProductoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class CarritoService implements ICarritoService {

    @Value("${server.port}")
    private int serverPort;

    @Autowired
    ICarritoRepository carritoRepo;

    @Autowired
    IProductoClient productoClient;
    @Override
    public List<Carrito> traerCarritos() {
        return carritoRepo.findAll();
    }

    @Override
    public Carrito buscarCarrito(Long id) {
        System.out.println("Estoy en "+serverPort);
        return carritoRepo.findById(id).orElse(null);
    }

    @Override
    public String crearCarrito(Carrito carrito) {
        calcularPrecioTotal(carrito);
        carritoRepo.save(carrito);
        return "Carrito creado con éxito";
    }

    @Override
    public String eliminarCarrito(Long id) {
        carritoRepo.deleteById(id);
        return "Carrito Eliminado con éxito";
    }

    @Override
    public Carrito editarCarrito(Carrito carrito) {
        Carrito carroEncontrado= carritoRepo.findById(carrito.getId()).orElse(null);
        carroEncontrado.setTotal(carrito.getTotal());


        return carroEncontrado;
    }

    @Override
    public Carrito agregarProducto(Long id, Long codigo) {



        Carrito carro = this.buscarCarrito(id);
        List<Long> idsNuevos = new LinkedList<>();
        List<Long> codigos=carro.getIdProductos();
        codigos.add(codigo);

        carro.setIdProductos(codigos);
        calcularPrecioTotal(carro);



        /* for(Long codProd:codigos){

            if(!codProd.equals(codigo)){

                idsNuevos.add(codProd);

            }

        }*/
        carritoRepo.save(carro);

        return carro;



    }

    @Override
    public Carrito eliminarProducto(Long id,Long codigo) {
        Carrito carro = this.buscarCarrito(id);
        List<Long> idsNuevos = new LinkedList<>();
        List<Long> codigos=carro.getIdProductos();
        codigos.remove(codigo);


        carro.setIdProductos(codigos);
        calcularPrecioTotal(carro);

        /* for(Long codProd:codigos){

            if(!codProd.equals(codigo)){

                idsNuevos.add(codProd);

            }

        }*/
        carritoRepo.save(carro);

        return carro;
    }

public void calcularPrecioTotal(Carrito carrito){

        double precioTotal=0;
    List<ProductoDTO> productosDelCarro=productoClient.getProductsByCarId(carrito.getIdProductos());
    for(ProductoDTO producto:productosDelCarro){

        precioTotal+=producto.getPrecio();

    }
    carrito.setTotal(precioTotal);


}

}

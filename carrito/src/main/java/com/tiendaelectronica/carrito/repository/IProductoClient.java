package com.tiendaelectronica.carrito.repository;

import com.tiendaelectronica.carrito.dto.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name ="productos-service")
public interface IProductoClient {

    @GetMapping("productos/traer/carrito")
    public List<ProductoDTO> getProductsByCarId(@RequestParam List<Long> idProductos);



}

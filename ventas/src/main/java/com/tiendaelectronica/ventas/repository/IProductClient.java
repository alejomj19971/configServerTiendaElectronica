package com.tiendaelectronica.ventas.repository;

import com.tiendaelectronica.ventas.dto.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient(name ="productos-service")
public interface IProductClient {

    @GetMapping("productos/traer/carrito")
    public List<ProductoDTO> getProductsByCarId(@RequestParam List<Long> idProductos);


}

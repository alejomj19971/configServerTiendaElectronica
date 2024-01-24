package com.tiendaelectronica.ventas.repository;

import com.tiendaelectronica.ventas.dto.CarritoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="carritos-service")
public interface ICarritoClient {
    @GetMapping("carritos/traer/carrito")
    public CarritoDTO traerElcarrito(@RequestParam Long id);



}

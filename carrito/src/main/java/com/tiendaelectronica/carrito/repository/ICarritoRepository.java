package com.tiendaelectronica.carrito.repository;

import com.tiendaelectronica.carrito.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface ICarritoRepository extends JpaRepository<Carrito,Long> {
    @Query("SELECT c FROM Carrito c WHERE c.id=:idCarrito")
    public Carrito getCarritoById(@RequestParam("idCarrito") Long idCarrito);



}

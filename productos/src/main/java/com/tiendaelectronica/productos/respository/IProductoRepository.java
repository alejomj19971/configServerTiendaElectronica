package com.tiendaelectronica.productos.respository;

import com.tiendaelectronica.productos.dto.CarritoDTO;
import com.tiendaelectronica.productos.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Producto,Long> {
    @Query("SELECT p from Producto p WHERE p.codigo IN:idProductos")
    public List<Producto> buscarProductosPorIdProductos(@RequestParam("idProductos") List<Long> idProductos);


}

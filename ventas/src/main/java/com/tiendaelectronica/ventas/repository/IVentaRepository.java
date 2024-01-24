package com.tiendaelectronica.ventas.repository;

import com.tiendaelectronica.ventas.model.Venta;
import org.bouncycastle.crypto.agreement.jpake.JPAKERound1Payload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta,Long> {

}

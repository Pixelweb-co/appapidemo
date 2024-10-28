package com.franquicias.app.repositories;

import com.franquicias.app.models.Producto;
import com.franquicias.app.models.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Optional<Producto> findTopBySucursalOrderByStockDesc(Sucursal sucursal);
}

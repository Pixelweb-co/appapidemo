package com.franquicias.app.controllers;

import com.franquicias.app.models.Producto;
import com.franquicias.app.dtos.ProductoDTO;
import com.franquicias.app.models.Sucursal;
import com.franquicias.app.dtos.SucursalDTO;
import com.franquicias.app.services.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/franquicias/{franquiciaId}/sucursales")
@CrossOrigin(origins = "*")
public class SucursalController {
    @Autowired
    private SucursalService sucursalService;

    @PostMapping
    public ResponseEntity<Sucursal> addSucursal(@PathVariable Long franquiciaId, @RequestBody SucursalDTO sucursalDTO) {
        String nombre = sucursalDTO.getNombre();
        List<Producto> productos = new ArrayList<>();

        if (sucursalDTO.getProductos() != null) {
            for (ProductoDTO productoDTO : sucursalDTO.getProductos()) {
                Producto producto = new Producto();
                producto.setNombre(productoDTO.getNombre());
                producto.setStock(productoDTO.getStock());
                productos.add(producto);
            }
        }

        Sucursal sucursal = sucursalService.addSucursal(franquiciaId, nombre, productos);
        return ResponseEntity.status(HttpStatus.CREATED).body(sucursal);
    }
}

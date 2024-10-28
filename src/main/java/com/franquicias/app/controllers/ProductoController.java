package com.franquicias.app.controllers;

import com.franquicias.app.dtos.ProductoDTO;
import com.franquicias.app.models.Producto;
import com.franquicias.app.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/franquicias/{franquiciaId}/sucursales/{sucursalId}/productos")
@CrossOrigin(origins = "*")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<Producto> addProducto(@PathVariable Long franquiciaId, @PathVariable Long sucursalId, @RequestBody Map<String, Object> request) {
        String nombre = (String) request.get("nombre");
        Integer stock = (Integer) request.get("stock");
        return ResponseEntity.ok(productoService.addProducto(sucursalId, nombre, stock));
    }

    @DeleteMapping("/{productoId}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long franquiciaId, @PathVariable Long sucursalId, @PathVariable Long productoId) {
        productoService.deleteProducto(productoId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{productoId}/stock")
    public ResponseEntity<Producto> updateStock(@PathVariable Long franquiciaId,
                                                @PathVariable Long sucursalId,
                                                @PathVariable Long productoId,
                                                @RequestBody Map<String, Integer> request) {
        Integer stock = request.get("stock");
        Producto updatedProducto = productoService.updateStock(productoId, stock);
        return ResponseEntity.ok(updatedProducto);
    }

    @GetMapping("/max-stock")
    public ResponseEntity<List<Producto>> getMaxStockProductsByFranquicia(@PathVariable Long franquiciaId) {
        return ResponseEntity.ok(productoService.getMaxStockProductsByFranquicia(franquiciaId));
    }
}

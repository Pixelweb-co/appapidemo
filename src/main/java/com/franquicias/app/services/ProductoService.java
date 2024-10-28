package com.franquicias.app.services;


import com.franquicias.app.models.Franquicia;
import com.franquicias.app.models.Producto;
import com.franquicias.app.models.Sucursal;
import com.franquicias.app.repositories.ProductoRepository;
import com.franquicias.app.repositories.SucursalRepository;
import com.franquicias.app.repositories.FranquiciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private SucursalRepository sucursalRepository;
    @Autowired
    private FranquiciaRepository franquiciaRepository;

    public Producto addProducto(Long sucursalId, String nombre, Integer stock) {
        Sucursal sucursal = sucursalRepository.findById(sucursalId)
                .orElseThrow(() -> new ResourceNotFoundException("Sucursal no encontrada"));

        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setStock(stock);
        producto.setSucursal(sucursal); // Establecer la sucursal

        return productoRepository.save(producto);
    }

    public void deleteProducto(Long productoId) {
        productoRepository.deleteById(productoId);
    }

    public Producto updateStock(Long productoId, Integer stock) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con id: " + productoId));
        producto.setStock(stock);
        return productoRepository.save(producto);
    }

    public List<Producto> getMaxStockProductsByFranquicia(Long franquiciaId) {
        Franquicia franquicia = franquiciaRepository.findById(franquiciaId)
                .orElseThrow(() -> new ResourceNotFoundException("Franquicia no encontrada con id: " + franquiciaId));

        List<Producto> productosMaxStock = new ArrayList<>();
        for (Sucursal sucursal : franquicia.getSucursales()) {
            productoRepository.findTopBySucursalOrderByStockDesc(sucursal)
                    .ifPresent(productosMaxStock::add);
        }
        return productosMaxStock;
    }
}

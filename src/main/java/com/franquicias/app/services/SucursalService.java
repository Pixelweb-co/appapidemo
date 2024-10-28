package com.franquicias.app.services;

import com.franquicias.app.models.Franquicia;
import com.franquicias.app.models.Producto;
import com.franquicias.app.models.Sucursal;
import com.franquicias.app.repositories.FranquiciaRepository;
import com.franquicias.app.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private FranquiciaRepository franquiciaRepository;

    public Sucursal addSucursal(Long franquiciaId, String nombre, List<Producto> productos) {
        Franquicia franquicia = franquiciaRepository.findById(franquiciaId)
                .orElseThrow(() -> new ResourceNotFoundException("Franquicia no encontrada"));

        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(nombre);
        sucursal.setFranquicia(franquicia);
        sucursal.setProductos(productos);

        return sucursalRepository.save(sucursal);
    }
}

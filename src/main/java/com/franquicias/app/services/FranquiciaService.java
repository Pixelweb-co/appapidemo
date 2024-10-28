package com.franquicias.app.services;

import com.franquicias.app.models.Franquicia;
import com.franquicias.app.repositories.FranquiciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FranquiciaService {
    @Autowired
    private FranquiciaRepository franquiciaRepository;

    public Franquicia addFranquicia(String nombre) {
        Franquicia franquicia = new Franquicia();
        franquicia.setNombre(nombre);
        return franquiciaRepository.save(franquicia);
    }

    public List<Franquicia> getAllFranquicias() {
        return franquiciaRepository.findAll();
    }
}

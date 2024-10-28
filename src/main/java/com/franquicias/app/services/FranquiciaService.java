package com.franquicias.app.services;

import com.franquicias.app.models.Franquicia;
import com.franquicias.app.repositories.FranquiciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class FranquiciaService {
    private final FranquiciaRepository franquiciaRepository;

    public FranquiciaService(FranquiciaRepository franquiciaRepository) {
        this.franquiciaRepository = franquiciaRepository;
    }

    @Transactional
    public Franquicia addFranquicia(@RequestBody Franquicia franquicia) {
        if (franquicia.getNombre() == null || !franquicia.getNombre().isEmpty() ) {
            throw new IllegalArgumentException("El nombre de la franquicia no puede estar vacío.");
        }

        return franquiciaRepository.save(franquicia);
    }

    public List<Franquicia> getAllFranquicias() {
        return franquiciaRepository.findAll();
    }
}

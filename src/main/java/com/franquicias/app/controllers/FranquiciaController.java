package com.franquicias.app.controllers;

import com.franquicias.app.models.Franquicia;
import com.franquicias.app.services.FranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/franquicias")
@CrossOrigin(origins = "*")
public class FranquiciaController {
    @Autowired
    private FranquiciaService franquiciaService;

    @PostMapping
    public ResponseEntity<Franquicia> addFranquicia(@RequestBody Map<String, String> request) {
        String nombre = request.get("nombre");
        return ResponseEntity.ok(franquiciaService.addFranquicia(nombre));
    }

    @GetMapping
    public ResponseEntity<List<Franquicia>> obtenerFranquicias() {
        try {
            List<Franquicia> franquicias = franquiciaService.getAllFranquicias();
            return ResponseEntity.ok(franquicias);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}

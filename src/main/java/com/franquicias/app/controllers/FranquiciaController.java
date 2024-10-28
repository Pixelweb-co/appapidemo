package com.franquicias.app.controllers;

import com.franquicias.app.dtos.FranquiciaDTO;
import com.franquicias.app.models.Franquicia;
import com.franquicias.app.services.FranquiciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/franquicias")
@CrossOrigin(origins = "*")
public class FranquiciaController {
    @Autowired
    private FranquiciaService franquiciaService;

    @PostMapping("/")
    public ResponseEntity<Franquicia> addFranquicia(@RequestBody Franquicia franquicia) {

        Franquicia savedfranquicia = franquiciaService.addFranquicia(franquicia);
        return ResponseEntity.ok(savedfranquicia);
    }

    @GetMapping("/")
    public ResponseEntity<List<FranquiciaDTO>> obtenerFranquicias() {
        List<FranquiciaDTO> franquiciasDTO = franquiciaService.getAllFranquicias().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(franquiciasDTO);
    }

    private FranquiciaDTO convertToDTO(Franquicia franquicia) {
        FranquiciaDTO dto = new FranquiciaDTO();
        dto.setId(franquicia.getId());
        dto.setNombre(franquicia.getNombre());
        dto.setSucursales(franquicia.getSucursales());
        return dto;
    }
}

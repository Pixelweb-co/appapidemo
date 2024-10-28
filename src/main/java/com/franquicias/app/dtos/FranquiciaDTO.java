package com.franquicias.app.dtos;

import com.franquicias.app.models.Sucursal;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class FranquiciaDTO {
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    @ArraySchema(schema = @Schema(implementation = Sucursal.class))
    private List<Sucursal> sucursales;
}

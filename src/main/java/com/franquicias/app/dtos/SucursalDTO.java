package com.franquicias.app.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SucursalDTO {
    private String nombre;
    private List<ProductoDTO> productos;
}

package com.franquicias.app.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.franquicias.app.models.Sucursal;

@Entity
@Table(name = "franquicias")
public class Franquicia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column
    @Getter
    @Setter
    @Schema(example = "string", description = "Nombre de la franquicia")
    private String nombre;

    @OneToMany(mappedBy = "franquicia", cascade = CascadeType.ALL)
    @Setter
    @Getter
    @Schema(description = "Lista de sucursales de la franquicia")
    private List<Sucursal> sucursales;

}

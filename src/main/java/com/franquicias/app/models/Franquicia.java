package com.franquicias.app.models;

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
    private String nombre;

    @OneToMany(mappedBy = "franquicia", cascade = CascadeType.ALL)
    @Setter
    @Getter
    private List<Sucursal> sucursales;

}

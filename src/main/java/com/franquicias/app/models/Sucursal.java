package com.franquicias.app.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import com.franquicias.app.models.Producto;

@Entity
@Table(name = "sucursales")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column
    @Getter
    @Setter
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "franquicia_id")
    @Getter
    @Setter
    private Franquicia franquicia;

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<Producto> productos;
}

package com.franquicias.app.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.franquicias.app.models.Sucursal;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column
    @Getter
    @Setter
    private String nombre;

    @Setter
    @Getter
    @Column
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "sucursal_id")
    @Getter
    @Setter
    private Sucursal sucursal;
}

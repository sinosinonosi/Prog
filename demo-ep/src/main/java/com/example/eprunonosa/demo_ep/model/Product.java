package com.example.eprunonosa.demo_ep.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;
    private Integer cantidad;
    private Double costeFabricacion;

    @JsonBackReference  // Evita la recursión infinita
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoria;
}

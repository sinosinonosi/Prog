package com.example.cquintas.demo_cq.model;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productos")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private float precio;
    private int cantidad;
    private float costeFabricacion;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Category categoria;
}




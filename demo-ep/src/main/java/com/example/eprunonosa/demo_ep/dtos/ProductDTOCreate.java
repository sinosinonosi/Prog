package com.example.eprunonosa.demo_ep.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTOCreate {
    private Integer id;
    private String nombre;
    private float precio;
    private int cantidad;
    private float costeFabricacion;

    private Long idCategoria;
}

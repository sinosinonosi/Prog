package com.example.eprunonosa.demo_ep.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTOCreate {
    private Long id;
    private String nombre;
    private Double precio;
    private int cantidad;
    private Double costeFabricacion;

    private Long idCategoria;
}

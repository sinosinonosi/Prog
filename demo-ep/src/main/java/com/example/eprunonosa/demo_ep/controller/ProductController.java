package com.example.eprunonosa.demo_ep.controller;

import com.example.eprunonosa.demo_ep.dtos.ProductDTO;
import com.example.eprunonosa.demo_ep.dtos.ProductDTOCreate;
import com.example.eprunonosa.demo_ep.model.Product;
import com.example.eprunonosa.demo_ep.services.ProductService;
import com.example.eprunonosa.demo_ep.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/product")
    public List<ProductDTO> listProducts() {
        return productService.listProducts().stream()
                .map(this::convertirAProductoDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Integer id) {
        Product product = productService.findById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(convertirAProductoDTO(product), HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody ProductDTOCreate productDTOCreate) {
        if (productDTOCreate.getNombre() == null || productDTOCreate.getPrecio() == null) {
            return new ResponseEntity<>("Product name and price must not be null", HttpStatus.BAD_REQUEST);
        }

        Product product = new Product();
        product.setNombre(productDTOCreate.getNombre());
        product.setPrecio(productDTOCreate.getPrecio());
        product.setCantidad(productDTOCreate.getCantidad());
        product.setCosteFabricacion(productDTOCreate.getCosteFabricacion());
        product.setCategoria(categoryService.findById(productDTOCreate.getIdCategoria()));

        try {
            productService.save(product);
            return new ResponseEntity<>(convertirAProductoDTO(product), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody ProductDTOCreate productDTOCreate) {
        Product currentProduct = productService.findById(id);
        if (currentProduct == null) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
        currentProduct.setNombre(productDTOCreate.getNombre());
        currentProduct.setPrecio(productDTOCreate.getPrecio());
        currentProduct.setCantidad(productDTOCreate.getCantidad());
        currentProduct.setCosteFabricacion(productDTOCreate.getCosteFabricacion());
        currentProduct.setCategoria(categoryService.findById(productDTOCreate.getIdCategoria()));

        try {
            productService.save(currentProduct);
            return new ResponseEntity<>(convertirAProductoDTO(currentProduct), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        try {
            if (!productService.deleteById(id)) {
                return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ProductDTO convertirAProductoDTO(Product product) {
        ProductDTO productoDTO = new ProductDTO();
        productoDTO.setId(product.getId());
        productoDTO.setNombre(product.getNombre());
        productoDTO.setPrecio(product.getPrecio());
        productoDTO.setNombtreCategoria(product.getCategoria().getShortName());
        return productoDTO;
    }
}

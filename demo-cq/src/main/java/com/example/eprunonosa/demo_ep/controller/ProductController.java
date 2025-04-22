package com.example.cquintas.demo_cq.controller;

import com.example.cquintas.demo_cq.dtos.ProductDTO;
import com.example.cquintas.demo_cq.dtos.ProductDTOCreate;
import com.example.cquintas.demo_cq.model.Product;
import com.example.cquintas.demo_cq.services.ProductService;
import com.example.cquintas.demo_cq.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/product")
    public List<ProductDTO> listProducts() {
        List<ProductDTO> productosDTO = new ArrayList<>();
        List<Product> productos = productService.listProducts();
        for (Product product : productos) {
            productosDTO.add(convertirAProductoDTO(product));
        }
        return productosDTO;
    }

    @GetMapping("/product/{id}")
    public ProductDTO findById(@PathVariable Integer id) {
        Product product = productService.findById(id);
        return convertirAProductoDTO(product);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody ProductDTOCreate productDTOCreate) {
        Product product = new Product();
        product.setNombre(productDTOCreate.getNombre());
        product.setPrecio(productDTOCreate.getPrecio());
        product.setCantidad(productDTOCreate.getCantidad());
        product.setCosteFabricacion(productDTOCreate.getCosteFabricacion());
        product.setCategoria(categoryService.findById(productDTOCreate.getIdCategoria()));
        try {
            productService.save(product);
            return new ResponseEntity<>(product,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Integer id, @RequestBody ProductDTOCreate product) {
        try {
            Product currentProduct = productService.findById(id);
            currentProduct.setNombre(product.getNombre());
            currentProduct.setPrecio(product.getPrecio());
            productService.save(currentProduct);
            return new ResponseEntity<>(currentProduct, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        try {
            productService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }
    private ProductDTO convertirAProductoDTO(Product product) {
        ProductDTO productoDTO = new ProductDTO();
        productoDTO.setNombre(product.getNombre());
        productoDTO.setPrecio(product.getPrecio());
        productoDTO.setId(product.getId());
        productoDTO.setNombtreCategoria(product.getCategoria().getShortName());
        return productoDTO;
    }

}

package com.example.cquintas.demo_cq.services;

import com.example.cquintas.demo_cq.dtos.ProductDTO;
import com.example.cquintas.demo_cq.dtos.ProductDTOCreate;
import com.example.cquintas.demo_cq.model.Product;
import com.example.cquintas.demo_cq.model.Category;
import com.example.cquintas.demo_cq.repository.CategoryRepository;
import com.example.cquintas.demo_cq.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product findById(Integer id) {
        return productRepository.findById(id).get();
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }


}

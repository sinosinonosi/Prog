package com.example.eprunonosa.demo_ep.services;

import com.example.eprunonosa.demo_ep.model.Product;
import com.example.eprunonosa.demo_ep.repository.CategoryRepository;
import com.example.eprunonosa.demo_ep.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

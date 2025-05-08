package com.example.eprunonosa.demo_ep.services;

import com.example.eprunonosa.demo_ep.model.Product;
import com.example.eprunonosa.demo_ep.repository.CategoryRepository;
import com.example.eprunonosa.demo_ep.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        return productRepository.findById(id).orElse(null);
    }

    public boolean deleteById(Integer id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

package com.example.eprunonosa.demo_ep.repository;

import com.example.eprunonosa.demo_ep.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}

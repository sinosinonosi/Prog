package com.example.cquintas.demo_cq.repository;

import com.example.cquintas.demo_cq.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}

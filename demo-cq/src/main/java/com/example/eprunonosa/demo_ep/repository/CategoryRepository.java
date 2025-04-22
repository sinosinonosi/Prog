package com.example.cquintas.demo_cq.repository;

import com.example.cquintas.demo_cq.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

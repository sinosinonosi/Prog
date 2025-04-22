package com.example.eprunonosa.demo_ep.repository;

import com.example.eprunonosa.demo_ep.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

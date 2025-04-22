package com.example.eprunonosa.demo_ep.services;

import com.example.eprunonosa.demo_ep.model.Category;
import com.example.eprunonosa.demo_ep.repository.CategoryRepository;
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
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}

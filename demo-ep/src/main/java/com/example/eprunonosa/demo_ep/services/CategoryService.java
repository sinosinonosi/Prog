package com.example.eprunonosa.demo_ep.services;

import com.example.eprunonosa.demo_ep.model.Category;
import com.example.eprunonosa.demo_ep.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        return categoryRepository.findById(id).orElse(null);
    }

    public boolean deleteById(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

package com.example.eprunonosa.demo_ep.controller;

import com.example.eprunonosa.demo_ep.model.Category;
import com.example.eprunonosa.demo_ep.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public List<Category> listCategories() {
        return categoryService.listCategories();
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("/category")
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        try {
            categoryService.save(category);
            return new ResponseEntity<>(category, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        Category currentCategory = categoryService.findById(id);
        if (currentCategory == null) {
            return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
        }
        currentCategory.setShortName(category.getShortName());
        currentCategory.setDescription(category.getDescription());
        categoryService.save(currentCategory);
        return new ResponseEntity<>(currentCategory, HttpStatus.OK);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        if (!categoryService.deleteById(id)) {
            return new ResponseEntity<>("Category not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

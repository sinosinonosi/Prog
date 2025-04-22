package com.example.cquintas.demo_cq.controller;

import com.example.cquintas.demo_cq.model.Category;
import com.example.cquintas.demo_cq.services.CategoryService;
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
    public Category findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PostMapping("/category")
    public ResponseEntity<?> addcategory(@RequestBody Category category) {
        try {
            categoryService.save(category);
            return new ResponseEntity<>(category, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        try {
            Category currentcategory = categoryService.findById(id);
            currentcategory.setShortName(category.getShortName());
            currentcategory.setDescription(category.getDescription());
            categoryService.save(currentcategory);
            return new ResponseEntity<>(currentcategory, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> deletecategory(@PathVariable Long id) {
        try {
            categoryService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
    }
}

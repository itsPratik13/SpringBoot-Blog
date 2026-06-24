package com.tut.blog.domain.controllers;

import com.tut.blog.domain.dtos.CategoryDTO;
import com.tut.blog.domain.dtos.CreateCategoryDTO;
import com.tut.blog.domain.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> listCategories() {
        return ResponseEntity.ok(categoryService.categoryList());//responseEntity= res in express
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody @Valid CreateCategoryDTO createCategoryDTO) {
        return ResponseEntity.status(201).body(categoryService.createCategory(createCategoryDTO));
    }
}

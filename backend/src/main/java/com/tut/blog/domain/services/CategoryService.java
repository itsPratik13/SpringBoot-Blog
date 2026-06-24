package com.tut.blog.domain.services;

import com.tut.blog.domain.dtos.CategoryDTO;
import com.tut.blog.domain.dtos.CreateCategoryDTO;
import com.tut.blog.domain.entities.Category;
import com.tut.blog.domain.mapper.CategoryMapper;
import com.tut.blog.domain.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDTO> categoryList() {
        return categoryRepository.findAll().stream().map(categoryMapper::toDto).toList();
    }

    public CategoryDTO createCategory(CreateCategoryDTO createCategoryDTO) {
        Category newCategory = categoryMapper.toEntity(createCategoryDTO);
        Category savedCategory = categoryRepository.save(newCategory);
        return categoryMapper.toDto(savedCategory);
    }

    public void deleteCategory(UUID id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        if (!category.getPosts().isEmpty()) {
            throw new IllegalStateException("Category has posts associated to it");
        }
        categoryRepository.deleteById(id);
    }
}

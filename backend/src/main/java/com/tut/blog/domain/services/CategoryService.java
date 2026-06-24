package com.tut.blog.domain.services;

import com.tut.blog.domain.dtos.CategoryDTO;
import com.tut.blog.domain.dtos.CreateCategoryDTO;
import com.tut.blog.domain.entities.Category;
import com.tut.blog.domain.mapper.CategoryMapper;
import com.tut.blog.domain.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public List<CategoryDTO> categoryList(){
        return categoryRepository.findAll().stream().map(categoryMapper::toDto).toList();
    }
    public CategoryDTO createCategory(CreateCategoryDTO createCategoryDTO){
        Category newCategory=categoryMapper.toEntity(createCategoryDTO);
        Category savedCategory=categoryRepository.save(newCategory);
        return categoryMapper.toDto(savedCategory);
    }
}

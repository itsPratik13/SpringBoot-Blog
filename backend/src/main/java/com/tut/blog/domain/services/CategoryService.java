package com.tut.blog.domain.services;

import com.tut.blog.domain.dtos.CategoryDTO;
import com.tut.blog.domain.entities.Category;
import com.tut.blog.domain.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<CategoryDTO> categoryList(){
        return categoryRepository.findAll().stream().map(category -> CategoryDTO.builder().id(category.getId()).name(category.getName()).postCount(category.getPosts()==null ? 0 :category.getPosts().size()).build()).toList();
    }
}

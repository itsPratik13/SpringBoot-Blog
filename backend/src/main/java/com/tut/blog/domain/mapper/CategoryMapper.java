package com.tut.blog.domain.mapper;

import com.tut.blog.domain.dtos.CategoryDTO;
import com.tut.blog.domain.dtos.CreateCategoryDTO;
import com.tut.blog.domain.entities.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component

public class CategoryMapper {
    public CategoryDTO toDto(Category category){
        if(category==null){
            return null;
        }
        return CategoryDTO.builder().id(category.getId()).name(category.getName()).postCount(category.getPosts()==null ? 0 :category.getPosts().size()).build();
    }
    public Category toEntity(CreateCategoryDTO dto){
        Category category=new Category();
        category.setName(dto.getName());
        return category;
    }
}

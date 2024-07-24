package org.example.hanteo.api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.hanteo.api.service.dto.CategoryResponse;
import org.example.hanteo.domain.category.Category;
import org.example.hanteo.domain.category.CategoryRepositoryCustom;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepositoryCustom categoryRepositoryCustom;

    public CategoryResponse getCategory(Long categoryId) throws NotFoundException {
        Category category = categoryRepositoryCustom.findCategoryWithChildrenById(categoryId).orElseThrow(NotFoundException::new);
        return CategoryResponse.of(category);
    }

    public CategoryResponse getCategory(String categoryName)throws NotFoundException {
        Category category = categoryRepositoryCustom.findCategoryWithChildrenByName(categoryName).orElseThrow(NotFoundException::new);
        return CategoryResponse.of(category);
    }

}

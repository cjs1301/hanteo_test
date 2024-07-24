package org.example.hanteo.api.controller;

import lombok.RequiredArgsConstructor;
import org.example.hanteo.api.service.CategoryService;
import org.example.hanteo.api.service.dto.CategoryResponse;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/{categoryId}")
    public CategoryResponse getCategory(@PathVariable("categoryId") Long categoryId) throws ChangeSetPersister.NotFoundException {
        return categoryService.getCategory(categoryId);
    }
    @GetMapping
    public CategoryResponse getCategory(@RequestParam String name) throws ChangeSetPersister.NotFoundException {
        return categoryService.getCategory(name);
    }
}

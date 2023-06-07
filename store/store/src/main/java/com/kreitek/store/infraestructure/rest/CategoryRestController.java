package com.kreitek.store.infraestructure.rest;

import com.kreitek.store.application.dto.CategoryDTO;
import com.kreitek.store.application.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryRestController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @CrossOrigin
    @GetMapping(value = "/categories", produces = "application/json")
    ResponseEntity<List<CategoryDTO>> getAllCategories(@RequestParam(name = "partialName", required = false) String partialName){
        List<CategoryDTO> categories;
        if (partialName == null){
            categories = this.categoryService.getAllCategories();
        }else {
            categories = this.categoryService.getAllCategoriesByName(partialName);
        }
        return new  ResponseEntity<>(categories, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/categories", produces = "application/json", consumes = "application/json")
    ResponseEntity<CategoryDTO> insertCategory(@RequestBody CategoryDTO categoryDTO){
        categoryDTO = this.categoryService.saveCategory(categoryDTO);
        return new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);
    }

    @CrossOrigin
    @PatchMapping(value = "/categories", produces = "application/json", consumes = "application/json")
    ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO categoryUpdated = this.categoryService.saveCategory(categoryDTO);
        return new ResponseEntity<>(categoryUpdated, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/categories/{categoryId}")
    ResponseEntity<?> deleteCategoryById(@PathVariable Long categoryId) {
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/categories/{categoryId}")
    ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long categoryId) {
        Optional<CategoryDTO> category = this.categoryService.getCategoryById(categoryId);

        if (category.isPresent()) {
            return new ResponseEntity<>(category.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

package com.kreitek.store.domain.persistence;

import com.kreitek.store.domain.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryPersistence {
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(Long categoryId);
    Category saveCategory(Category category);
    void deleteCategory(Long categoryId);
    List<Category> getCategoriesByName(String partialName);
}

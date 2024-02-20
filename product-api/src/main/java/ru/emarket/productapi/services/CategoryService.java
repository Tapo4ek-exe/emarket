package ru.emarket.productapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.emarket.productapi.models.Category;
import ru.emarket.productapi.repositories.CategoryRepository;
import ru.emarket.productapi.specifications.CategorySpecificationAll;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.query(new CategorySpecificationAll());
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.get(id).orElse(null);
    }

    public void createCategory(Category category) {
        categoryRepository.add(category);
    }

    public void updateCategory(Category category) {
        categoryRepository.update(category);
    }

    public void deleteCategory(Category category) {
        categoryRepository.remove(category);
    }
}

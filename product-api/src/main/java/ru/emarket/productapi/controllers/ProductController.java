package ru.emarket.productapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.emarket.productapi.models.Product;
import ru.emarket.productapi.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/get")
    public List<Product> getAllCategories(@RequestParam Long categoryId) {
        return productService.getProductsByCategory(categoryId);
    }

    @PostMapping("/create")
    public void createCategory(@RequestBody Product product) {
        productService.createProduct(product);
    }

    @PutMapping("/update")
    public void updateCategory(@RequestBody Product product) {
        productService.updateProduct(product);
    }

    @DeleteMapping("/delete")
    public void deleteCategory(@RequestBody Product product) {
        productService.deleteProduct(product);
    }
}

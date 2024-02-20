package ru.emarket.productapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.emarket.productapi.models.Product;
import ru.emarket.productapi.repositories.ProductRepository;
import ru.emarket.productapi.specifications.ProductSpecificationByCategory;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Long id) {
        return productRepository.get(id).orElse(null);
    }

    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.query(new ProductSpecificationByCategory(categoryId));
    }

    public void createProduct(Product product) {
        productRepository.add(product);
    }

    public void updateProduct(Product product) {
        productRepository.update(product);
    }

    public void deleteProduct(Product product) {
        productRepository.remove(product);
    }
}

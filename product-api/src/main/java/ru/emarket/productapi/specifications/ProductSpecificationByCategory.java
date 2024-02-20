package ru.emarket.productapi.specifications;

import ru.emarket.productapi.models.Product;

public class ProductSpecificationByCategory implements Specification<Product> {
    private final Long categoryId;

    public ProductSpecificationByCategory(Long categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isSatisfiedBy(Product product) {
        return categoryId.equals(product.getCategoryId());
    }

    public String getSQL() {
        return "SELECT * FROM Product WHERE categoryId=?";
    }

    public Object[] getSQLParams() {
        return new Object[]{categoryId};
    }
}

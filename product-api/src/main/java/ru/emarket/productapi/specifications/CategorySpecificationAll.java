package ru.emarket.productapi.specifications;

import ru.emarket.productapi.models.Category;

public class CategorySpecificationAll implements Specification<Category> {
    public boolean isSatisfiedBy(Category category) {
        return true;
    }

    public String getSQL() {
        return "SELECT * FROM Category";
    }

    public Object[] getSQLParams() {
        return new Object[0];
    }
}

package ru.emarket.productapi.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.emarket.productapi.dao.CategoryDAO;
import ru.emarket.productapi.models.Category;
import ru.emarket.productapi.specifications.Specification;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository implements ru.emarket.productapi.repositories.Repository<Category, Long> {
    private final CategoryDAO categoryDAO;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryRepository(CategoryDAO categoryDAO, JdbcTemplate jdbcTemplate) {
        this.categoryDAO = categoryDAO;
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Category> get(Long id) {
        return categoryDAO.get(id);
    }

    public void add(Category category) {
        categoryDAO.create(category);
    }

    public void update(Category category) {
        categoryDAO.update(category);
    }

    public void remove(Category category) {
        categoryDAO.delete(category.getId());
    }

    public List<Category> query(Specification<Category> specification) {
        return jdbcTemplate.query(specification.getSQL(), new BeanPropertyRowMapper<>(Category.class),
                specification.getSQLParams());
    }
}

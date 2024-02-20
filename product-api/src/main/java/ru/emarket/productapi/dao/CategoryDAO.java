package ru.emarket.productapi.dao;

import ru.emarket.productapi.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

@Component
public class CategoryDAO implements DAO<Category, Long> {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CategoryDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Category> get(Long id) {
        return jdbcTemplate.query("SELECT * FROM Category WHERE id=?",
                new BeanPropertyRowMapper<>(Category.class), new Object[]{id})
                .stream().findFirst();
    }

    public void create(Category category) {
        jdbcTemplate.update("INSERT INTO Category(name, parentCategoryId) VALUES(?, ?)",
                category.getName(), category.getParentCategoryId());
    }

    public void update(Category category) {
        jdbcTemplate.update("UPDATE Category SET name=?, parentCategoryId=? WHERE id=?",
                category.getName(), category.getParentCategoryId(), category.getId());
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM Category WHERE id=?", id);
    }
}

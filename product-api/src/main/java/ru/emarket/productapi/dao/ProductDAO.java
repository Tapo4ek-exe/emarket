package ru.emarket.productapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.emarket.productapi.models.Product;

import java.util.Optional;

@Component
public class ProductDAO implements DAO<Product, Long> {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Product> get(Long id) {
        return jdbcTemplate.query("SELECT * FROM Product WHERE id=?",
                        new Object[]{id}, new BeanPropertyRowMapper<>(Product.class))
                .stream().findFirst();
    }

    public void create(Product product) {
        jdbcTemplate.update("INSERT INTO Product(brand, model, itemNumber, description, categoryId) VALUES(?, ?, ?, ?, ?)",
                product.getBrand(), product.getModel(), product.getItemNumber(),
                product.getDescription(), product.getCategoryId());
    }

    public void update(Product product) {
        jdbcTemplate.update("UPDATE Product SET brand=?, model=?, itemNumber=?, description=?, categoryId=? WHERE id=?",
                product.getBrand(), product.getModel(), product.getItemNumber(), product.getDescription(),
                product.getCategoryId(), product.getId());
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM Product WHERE id=?", id);
    }
}

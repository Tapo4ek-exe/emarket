package ru.emarket.productapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.emarket.productapi.models.SpecificationToProduct;

import java.util.Optional;

@Component
public class SpecificationToProductDAO implements DAO<SpecificationToProduct, Long> {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SpecificationToProductDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<SpecificationToProduct> get(Long id) {
        return jdbcTemplate.query("SELECT * FROM SpecificationToProduct WHERE id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(SpecificationToProduct.class))
                .stream().findFirst();
    }

    public void create(SpecificationToProduct specToProduct) {
        jdbcTemplate.update("INSERT INTO SpecificationToProduct (productId, specificationValueId) VALUES (?, ?)",
                specToProduct.getProductId(), specToProduct.getSpecificationValueId());
    }

    public void update(SpecificationToProduct specToProduct) {
        jdbcTemplate.update("UPDATE SpecificationToProduct SET productId=?, specificationValueId=? WHERE id=?",
                specToProduct.getProductId(), specToProduct.getSpecificationValueId(), specToProduct.getId());
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM SpecificationToProduct WHERE id=?", id);
    }
}

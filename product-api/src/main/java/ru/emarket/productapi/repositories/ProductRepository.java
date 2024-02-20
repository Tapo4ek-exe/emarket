package ru.emarket.productapi.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.emarket.productapi.dao.ProductDAO;
import ru.emarket.productapi.models.Product;
import ru.emarket.productapi.specifications.Specification;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements ru.emarket.productapi.repositories.Repository<Product, Long> {
    private final ProductDAO productDAO;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepository(ProductDAO productDAO, JdbcTemplate jdbcTemplate) {
        this.productDAO = productDAO;
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Product> get(Long id) {
        return productDAO.get(id);
    }

    public void add(Product product) {
        productDAO.create(product);
    }

    public void update(Product product) {
        productDAO.update(product);
    }

    public void remove(Product product) {
        productDAO.delete(product.getId());
    }

    public List<Product> query(Specification<Product> specification) {
        return jdbcTemplate.query(specification.getSQL(), new BeanPropertyRowMapper<>(Product.class),
                specification.getSQLParams());
    }
}

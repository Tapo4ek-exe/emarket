package ru.emarket.productapi.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.emarket.productapi.dao.SpecificationToProductDAO;
import ru.emarket.productapi.models.SpecificationToProduct;
import ru.emarket.productapi.specifications.Specification;

import java.util.List;
import java.util.Optional;

@Repository
public class SpecificationToProductRepository implements ru.emarket.productapi.repositories.Repository<SpecificationToProduct, Long> {
    private final SpecificationToProductDAO specToProductDAO;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SpecificationToProductRepository(SpecificationToProductDAO specToProductDAO, JdbcTemplate jdbcTemplate) {
        this.specToProductDAO = specToProductDAO;
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<SpecificationToProduct> get(Long id) {
        return specToProductDAO.get(id);
    }

    public void add(SpecificationToProduct specToProduct) {
        specToProductDAO.create(specToProduct);
    }

    public void update(SpecificationToProduct specToProduct) {
        specToProductDAO.update(specToProduct);
    }

    public void remove(SpecificationToProduct specToProduct) {
        specToProductDAO.delete(specToProduct.getId());
    }

    public List<SpecificationToProduct> query(Specification<SpecificationToProduct> specification) {
        return jdbcTemplate.query(specification.getSQL(), new BeanPropertyRowMapper<>(SpecificationToProduct.class),
                specification.getSQLParams());
    }
}

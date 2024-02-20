package ru.emarket.productapi.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.emarket.productapi.dao.SpecificationValueDAO;
import ru.emarket.productapi.models.SpecificationValue;
import ru.emarket.productapi.specifications.Specification;

import java.util.List;
import java.util.Optional;

@Repository
public class SpecificationValueRepository implements ru.emarket.productapi.repositories.Repository<SpecificationValue, Long> {
    private final SpecificationValueDAO specValueDAO;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SpecificationValueRepository(SpecificationValueDAO specValueDAO, JdbcTemplate jdbcTemplate) {
        this.specValueDAO = specValueDAO;
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<SpecificationValue> get(Long id) {
        return specValueDAO.get(id);
    }

    public void add(SpecificationValue specValue) {
        specValueDAO.create(specValue);
    }

    public void update(SpecificationValue specValue) {
        specValueDAO.update(specValue);
    }

    public void remove(SpecificationValue specValue) {
        specValueDAO.delete(specValue.getId());
    }

    public List<SpecificationValue> query(Specification<SpecificationValue> specification) {
        return jdbcTemplate.query(specification.getSQL(), new BeanPropertyRowMapper<>(SpecificationValue.class),
                specification.getSQLParams());
    }
}

package ru.emarket.productapi.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.emarket.productapi.dao.SpecificationDAO;
import ru.emarket.productapi.models.Specification;

import java.util.List;
import java.util.Optional;

@Repository
public class SpecificationRepository implements ru.emarket.productapi.repositories.Repository<Specification, Long> {
    private final SpecificationDAO specificationDAO;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SpecificationRepository(SpecificationDAO specificationDAO, JdbcTemplate jdbcTemplate) {
        this.specificationDAO = specificationDAO;
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Specification> get(Long id) {
        return specificationDAO.get(id);
    }

    public void add(Specification spec) {
        specificationDAO.create(spec);
    }

    public void update(Specification spec) {
        specificationDAO.update(spec);
    }

    public void remove(Specification spec) {
        specificationDAO.delete(spec.getId());
    }

    public List<Specification> query(ru.emarket.productapi.specifications.Specification<Specification> specification) {
        return jdbcTemplate.query(specification.getSQL(), new BeanPropertyRowMapper<>(Specification.class),
                specification.getSQLParams());
    }
}

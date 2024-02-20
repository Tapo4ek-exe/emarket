package ru.emarket.productapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.emarket.productapi.models.Specification;

import java.util.Optional;

@Component
public class SpecificationDAO implements DAO<Specification, Long> {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SpecificationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Specification> get(Long id) {
        return jdbcTemplate.query("SELECT * FROM Specification WHERE id=?",
                new BeanPropertyRowMapper<>(Specification.class), new Object[]{id})
                .stream().findFirst();
    }

    public void create(Specification specification) {
        jdbcTemplate.update("INSERT INTO Specification(name, description, unit) VALUES (?, ?, ?)",
                specification.getName(), specification.getDescription(), specification.getUnit());
    }

    public void update(Specification specification) {
        jdbcTemplate.update("UPDATE Specification SET name=?, description=?, unit=? WHERE id=?",
                specification.getName(), specification.getDescription(), specification.getUnit(),
                specification.getId());
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM Specification WHERE id=?", id);
    }
}

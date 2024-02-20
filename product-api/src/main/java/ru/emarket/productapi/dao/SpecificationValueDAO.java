package ru.emarket.productapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.emarket.productapi.models.SpecificationValue;

import java.util.Optional;

@Component
public class SpecificationValueDAO implements DAO<SpecificationValue, Long> {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SpecificationValueDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<SpecificationValue> get(Long id) {
        return jdbcTemplate.query("SELECT * FROM SpecificationValue WHERE id=?",
                        new BeanPropertyRowMapper<>(SpecificationValue.class), new Object[]{id})
                .stream().findFirst();
    }

    public void create(SpecificationValue specificationValue) {
        jdbcTemplate.update("INSERT INTO SpecificationValue(specificationId, valueInt, valueDouble, valueString) VALUES (? , ?, ?, ?)",
                specificationValue.getSpecificationId(), specificationValue.getValueInt(),
                specificationValue.getValueDouble(), specificationValue.getValueString());
    }

    public void update(SpecificationValue specificationValue) {
        jdbcTemplate.update("UPDATE SpecificationValue SET specificationId=?, valueInt=?, valueDouble=?, valueString=? WHERE id=?",
                specificationValue.getSpecificationId(), specificationValue.getValueInt(),
                specificationValue.getValueDouble(), specificationValue.getValueString(), specificationValue.getId());
    }

    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM SpecificationValue WHERE id=?", id);
    }
}

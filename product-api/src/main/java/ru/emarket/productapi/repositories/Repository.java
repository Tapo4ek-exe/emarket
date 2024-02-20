package ru.emarket.productapi.repositories;

import ru.emarket.productapi.specifications.Specification;

import java.util.List;
import java.util.Optional;

public interface Repository<TClass, TId> {
    Optional<TClass> get(TId id);

    void add(TClass object);

    void update(TClass object);

    void remove(TClass object);

    List<TClass> query(Specification<TClass> specification);
}

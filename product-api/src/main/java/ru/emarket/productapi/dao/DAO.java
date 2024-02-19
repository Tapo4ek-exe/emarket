package ru.emarket.productapi.dao;

import java.util.Optional;

public interface DAO<TClass, TId> {
    Optional<TClass> get(TId id);
    void create(TClass object);
    void update(TClass object);
    void delete(TId id);
}

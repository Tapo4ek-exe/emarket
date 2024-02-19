package main.java.ru.emarket.productapi.repositories;

import java.util.List;

public interface Repository<TClass, TId> {
    void add(TClass object);
    void update(TClass object);
    void remove(TClass object);
    List<TClass> query();
}

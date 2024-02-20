package ru.emarket.productapi.specifications;

public interface Specification<TClass> {
    boolean isSatisfiedBy(TClass object);
    String getSQL();
    Object[] getSQLParams();
}

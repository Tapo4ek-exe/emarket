package main.java.ru.emarket.productapi.specifications;

public interface Specification<TClass> {
    boolean isSatisfiedBy(TClass object);
}

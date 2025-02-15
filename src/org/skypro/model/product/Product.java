package org.skypro.model.product;

import org.skypro.model.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {

    private String name;

    public Product(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым или состоять только из пробелов");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public abstract double getPrice();

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + getPrice() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String getSearchTerm() {
        return name;
    }
}
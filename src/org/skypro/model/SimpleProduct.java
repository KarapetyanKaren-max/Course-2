package org.skypro.model;

import org.skypro.servi.Product;

import java.util.Objects;

public class SimpleProduct extends Product {
    private double price;

    public SimpleProduct(double price, String name) {
        super(name);
        validatePrice(price); // Validate price in the constructor
        this.price = price;
    }

    private void validatePrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Цена продукта должна быть строго больше 0");
        }
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "SimpleProduct{" +
                "name='" + getName() + '\'' + // Include product name for clarity
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SimpleProduct that = (SimpleProduct) o;
        return Double.compare(price, that.price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price);
    }
}




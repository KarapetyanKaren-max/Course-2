package org.skypro.model;

import org.skypro.servi.Product;

import java.util.Objects;

public class DiscountedProduct extends Product {
    private double basePrice; // Fixed typo in variable name
    private int discount;

    public DiscountedProduct(int discount, String name, double basePrice) {
        super(name);
        validateBasePrice(basePrice); // Validate base price
        validateDiscount(discount); // Validate discount percentage
        this.basePrice = basePrice;
        this.discount = discount;
    }

    private void validateBasePrice(double basePrice) {
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Базовая цена должна быть строго больше 0");
        }
    }

    private void validateDiscount(int discount) {
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в диапазоне от 0 до 100 включительно");
        }
    }

    public double getBasePrice() {
        return basePrice;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public double getPrice() {
        return basePrice * (1 - discount / 100.0);
    }

    @Override
    public String toString() {
        return "DiscountedProduct{" +
                "basePrice=" + basePrice +
                ", discount=" + discount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountedProduct that = (DiscountedProduct) o;
        return Double.compare(basePrice, that.basePrice) == 0 && discount == that.discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), basePrice, discount);
    }
}





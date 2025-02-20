package org.skypro.model.product;

import java.util.Objects;

public class DiscountedProduct extends Product {
    private final double basePrice;
    private final int discount;

    public DiscountedProduct(int discount, String name, double basePrice) {
        super(name);
        validateBasePrice(basePrice);
        validateDiscount(discount);
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





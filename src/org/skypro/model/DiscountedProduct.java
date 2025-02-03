package org.skypro.model;

import java.util.Objects;

public class DiscountedProduct extends Product {
    private double basePrise;
    private int discount;

    public DiscountedProduct(int discount, String name, double basePrise){
        super(name);
        this.discount = discount;
        this.basePrise = basePrise;
    }

    public double getBasePrise() {
        return basePrise;
    }

    public int getDiscount() {
        return discount;
    }
    @Override
    public double getPrice() {
        return basePrise * (1 - discount / 100.0);
    }

    @Override
    public String toString() {
        return "DiscountedProduct{" + name +
                " Prise = " + basePrise +
                ", discount = " + discount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountedProduct that = (DiscountedProduct) o;
        return Double.compare(basePrise, that.basePrise) == 0 && discount == that.discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), basePrise, discount);
    }

    @Override
    public String getSearchTerm() {
        return "";
    }
}




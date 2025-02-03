package org.skypro.model;

public class FixPriceProduct extends Product {
private static double price = 50;
    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "FixPriceProduct{" +
                " name = '" + name + '\'' +
                ", price = " + price +
                '}';

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String getSearchTerm() {
        return "";
    }
}

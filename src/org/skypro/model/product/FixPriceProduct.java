package org.skypro.model.product;

public class FixPriceProduct extends Product {

    private static final double DEFAULT_PRICE = 50.0;
    private final double price;


    public FixPriceProduct(String name) {
        super(name);
        this.price = DEFAULT_PRICE;
    }

    public FixPriceProduct(String name, double price) {
        super(name);
        this.price = price;
    }


    @Override
    public double getPrice() {
        return price;
    }
}
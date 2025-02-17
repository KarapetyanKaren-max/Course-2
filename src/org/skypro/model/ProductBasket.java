package org.skypro.model;

import org.skypro.model.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ProductBasket {
    private final List<Product> products;

    public ProductBasket() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        if (product == null || product.getPrice() <= 0) {
            throw new IllegalArgumentException("Продукт не может быть пустым или иметь отрицательную цену.");
        }
        products.add(product);
        System.out.println("Продукт в корзину добавлен");
    }
    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        return removedProducts;
    }

    public void printBasket() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public double priceBasket() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return "ProductBasket{" +
                "products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBasket that = (ProductBasket) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(products);
    }
}



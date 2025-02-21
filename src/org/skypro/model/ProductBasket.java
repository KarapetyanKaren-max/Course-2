package org.skypro.model;

import org.skypro.model.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ProductBasket {
    private final Map<String, List<Product>> products;

    public ProductBasket() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (product == null || product.getPrice() <= 0) {
            throw new IllegalArgumentException("Продукт не может быть пустым или иметь отрицательную цену.");
        }

        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
        System.out.println("Продукт в корзину добавлен");
    }

    public List<Product> removeByName(String name) {
        return products.remove(name);
    }

    public void printBasket() {
        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
            String productName = entry.getKey();
            List<Product> productList = entry.getValue();
            for (Product product : productList) {
                System.out.println(productName + ": " + product);
            }
        }
    }

    public double priceBasket() {
        double total = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                total += product.getPrice();
            }
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



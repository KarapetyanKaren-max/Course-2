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
        products.forEach((productName, productList) ->
                productList.forEach(product ->
                        System.out.println(productName + ": " + product)
                )
        );
    }

    public double priceBasket() {
        return products.values().stream()
                .flatMap(List::stream)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    private long getSpecialCount() {
        return products.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
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


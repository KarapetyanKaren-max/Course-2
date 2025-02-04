package org.skypro.model;

import org.skypro.servi.Product;

import java.util.Arrays;
import java.util.Objects;

public class ProductBasket {
        private Product[] products = new Product[5];

        // Этот класс содержит в себе одну корзину с продуктами, которые купил один пользователь
        // Вам нужно реализовать следующие публичные методы
        public void addProduct(Product product) {
            for (int number = 0; number < products.length; number++) {
                if (products[number] == null) {
                    products[number] = product;
                    System.out.println("Продукт в корзину добавлен");
                    break;
                }
                if (number == products.length - 1) {
                    System.out.println("корзина заполнена");
                }
            }
        }
        public double priceBasket() {
            double sum = 0;
            if (products[0] == null) {
                System.out.println("Корзина пуста");
            } else {
                for (Product variable : products) {
                    if (variable != null) {
                        sum = sum+variable.getPrice();
                    }
                }
                return sum;
            }
            return 0;
        }
        public void printBasket() {
            if (products[0] == null) {
                System.out.println("Корзина пуста");
            }
            for (Product variable : products) {
                if (variable != null) {
                    System.out.println(variable);
                }
            }
            System.out.println("Цена корзины: " + priceBasket());
        }
        public void deleteProduct () {
            for (int number = 0; number < products.length; number++) {
                products[number] = null;
            }
            System.out.println("Корзина очищена");
        }

    @Override
    public String toString() {
        return "ProductBasket{" +
                "products=" + Arrays.toString(products) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBasket basket = (ProductBasket) o;
        return Objects.deepEquals(products, basket.products);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(products);
    }
}

package org.skypro;

import org.skypro.model.*;
import org.skypro.servis.BestResultNotFound;
import org.skypro.servis.SearchEngine;

import java.util.List;

import static org.skypro.servis.SearchEngine.printSearchResults;

public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();
        try {
            basket.addProduct(new DiscountedProduct(50, "Молоко", 230));
            basket.addProduct(new SimpleProduct(25, "Хрен"));
            basket.addProduct(new SimpleProduct(120, "Масло"));
            basket.addProduct(new SimpleProduct(650, "Торт"));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при добавлении продукта: " + e.getMessage());
        }

        try {
            basket.addProduct(new SimpleProduct(0, "Неправильный продукт"));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при добавлении продукта: " + e.getMessage());
        }

        try {
            basket.addProduct(new DiscountedProduct(50, "Молоко", -10));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при добавлении продукта: " + e.getMessage());
        }

        try {
            basket.addProduct(new DiscountedProduct(150, "Молоко", 230));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при добавлении продукта: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Добавить продукт в корзину");
        basket.printBasket();
        System.out.println("Стоимость корзины: " + basket.priceBasket());

        SearchEngine engine = SearchEngine.getInstance();

        engine.add(new Article("Самое вкусное молоко ", "Оно полезное."));
        engine.add(new Article("Дохлая рыба", "Что купить: Дохлую рыбу или торт."));

        try {
            Searchable BestPosture = engine.findBestMatch("молоко");
            System.out.println("Наилучшая позицыя: " + BestPosture.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            Searchable noBestPosture = engine.findBestMatch("недоступный продукт");
            System.out.println("Наилучшая позицыя: " + noBestPosture.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }
    }









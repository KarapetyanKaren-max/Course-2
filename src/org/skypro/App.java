package org.skypro;

import org.skypro.model.*;
import org.skypro.servis.SearchEngine;

import java.util.List;

import static org.skypro.servis.SearchEngine.printSearchResults;

public class App {
        public static void main(String[] args) {

            ProductBasket basket = new ProductBasket();
            basket.addProduct(new DiscountedProduct(50, "Молоко", 230));
            basket.addProduct(new FixPriceProduct("Рыба"));
            basket.addProduct(new SimpleProduct(25, "Хрен"));
            basket.addProduct(new SimpleProduct(120, "Масло"));
            basket.addProduct(new SimpleProduct(650, "Торт"));
            System.out.println();
            System.out.println("Добавить продукт в корзину");
            basket.printBasket();
            System.out.println("Стоимость корзины: " + basket.priceBasket());

        SearchEngine engine = SearchEngine.getInstance();


        engine.add(new Article("Самое вкусное молоко", "Зачем нужен Хрен."));
        engine.add(new Article("Дохлая рыба", "Что купить: масло или торт."));


        System.out.println("Результаты поиска для 'молоко':");
        List<Searchable> results1 = engine.search("молоко");
        printSearchResults(results1);

        System.out.println("Результаты поиска для 'рыба':");
        List<Searchable> results2 = engine.search("рыба");
        printSearchResults(results2);

        System.out.println("Результаты поиска для 'Самое вкусное молоко':");
        List<Searchable> results3 = engine.search("Самое вкусное молоко");
        printSearchResults(results3);
    }
    }
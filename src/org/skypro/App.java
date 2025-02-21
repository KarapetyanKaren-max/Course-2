package org.skypro;

import org.skypro.exception.BestResultNotFound;
import org.skypro.model.*;
import org.skypro.model.article.Article;
import org.skypro.model.product.DiscountedProduct;
import org.skypro.model.product.FixPriceProduct;
import org.skypro.model.product.Product;
import org.skypro.model.product.SimpleProduct;
import org.skypro.servis.SearchEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        SearchEngine searchEngine = SearchEngine.getInstance();


        basket.addProduct(new DiscountedProduct(50, "Молоко", 230));
        basket.addProduct(new SimpleProduct(1, "Хрен"));
        basket.addProduct(new SimpleProduct(120, "Масло"));
        basket.addProduct(new SimpleProduct(650, "Торт"));
        basket.addProduct(new SimpleProduct(150, "Молоко"));


        List<Product> removedProducts = basket.removeByName("Молоко");
        System.out.println("Удаленные продукты:");
        for (Product product : removedProducts) {
            System.out.println(product);
        }

        System.out.println("Корзина после удаления:");
        basket.printBasket();

        removedProducts = basket.removeByName("Неизвестный продукт");
        if (removedProducts == null) {
            System.out.println("Список пуст");
        }

        System.out.println("Корзина после попытки удаления несуществующего продукта:");
        basket.printBasket();

        String searchTerm = "Молоко";
        Map<String, Searchable> searchResults = searchEngine.search(searchTerm);
        System.out.println("Результаты поиска для: " + searchTerm);
        SearchEngine.printSearchResults(searchResults);
    }
}



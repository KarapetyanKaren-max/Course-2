package org.skypro;

import org.skypro.model.*;
import org.skypro.servis.SearchEngine;

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
        }
    }
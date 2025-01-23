package org.skypro;

    public class App {
        public static void main(String[] args) {

            ProductBasket basket = new ProductBasket();
            basket.addProduct(new Product(150, "Молоко"));
            basket.addProduct(new Product(450, "Рыба"));
            basket.addProduct(new Product(25, "Хрен"));
            basket.addProduct(new Product(120, "Масло"));
            basket.addProduct(new Product(650, "Торт"));
            System.out.println();
            System.out.println("Добавить продукт в корзину");
            basket.printBasket();
            System.out.println("Стоимость корзины: " + basket.priceBasket());

        }
    }
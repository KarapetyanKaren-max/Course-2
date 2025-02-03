package org.skypro.servis;

import org.skypro.model.Article;
import org.skypro.model.Searchable;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class SearchEngine {
    private static Searchable[] items;
    private static int currentIndex;
    private static SearchEngine engine;

    public SearchEngine(int capacity) {
        items = new Searchable[capacity];
        currentIndex = 0;
    }

    public static void add(Searchable item) {
        if (currentIndex < items.length) {
            items[currentIndex++] = item;
        } else {
            System.out.println("массив всех элементов, по которым можно искать");
        }

        SearchEngine.add(new Article("Самое вкусное молоко", "Зачем нужен Хрен."));
        SearchEngine.add(new Article("Дохлая рыба", "Что купить масло или торт."));

        System.out.println("Результаты поиска для 'Молоко':");
        Searchable[] results1 = engine.search("Молоко");
        printSearchResults(results1);

        System.out.println("Результаты поиска для 'Рыба':");
        Searchable[] results2 = engine.search("Рыба");
        printSearchResults(results2);

        System.out.println("Результаты поиска для 'Самое вкусное молоко':");
        Searchable[] results3 = engine.search("Самое вкусное молоко");
        printSearchResults(results3);
    }

    private Searchable[] search(String рыба) {
        return null;
    }


    @Override
    public String toString() {
        return "SearchEngine{}";
    }
    private static void printSearchResults(Searchable[] results) {
        for (Searchable result : results) {
            if (result != null) {
                System.out.println(result.getSearchTerm());
            }

        }
    }
}


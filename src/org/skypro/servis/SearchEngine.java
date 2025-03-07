package org.skypro.servis;

import org.skypro.exception.BestResultNotFound;
import org.skypro.model.Searchable;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SearchEngine {
    private final List<Searchable> items;

    private SearchEngine() {
        items = new ArrayList<>();
    }

    private static class LazyHolder {
        private static final SearchEngine INSTANCE = new SearchEngine();
    }

    public static SearchEngine getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void add(Searchable item) {
        items.add(item);
    }

    public Map<String, Searchable> search(String term) {
        return items.stream()
                .filter(item -> item != null && item.getSearchTerm() != null &&
                        item.getSearchTerm().toLowerCase().contains(term.toLowerCase()))
                .collect(Collectors.toMap(Searchable::getSearchTerm, item -> item, (existing, replacement) -> existing,
                        () -> new TreeMap<>(String::compareTo)));
    }

    public static void printSearchResults(Map<String, Searchable> results) {
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено.");
        } else {
            for (Map.Entry<String, Searchable> entry : results.entrySet()) {
                System.out.println("Продукт: " + entry.getKey() + ", Информация: " + entry.getValue());
            }
        }
    }

    public Searchable findBestMatch(String searchTerm) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable item : items) {
            if (item != null && item.getSearchTerm() != null) {
                int count = countOccurrences(item.getSearchTerm().toLowerCase(), searchTerm.toLowerCase());
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = item;
                }
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound(searchTerm);
        }

        return bestMatch;
    }

    private int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }

        return count;
    }

    @Override
    public String toString() {
        return "SearchEngine{" +
                "items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchEngine that = (SearchEngine) o;
        return Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(items);
    }
}
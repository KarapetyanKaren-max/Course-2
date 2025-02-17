package org.skypro.servis;

import org.skypro.exception.BestResultNotFound;
import org.skypro.model.Searchable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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

    public List<Searchable> search(String searchTerm) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable item : items) {
            if (item != null && item.getSearchTerm() != null &&
                    item.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(item);
            }
        }
        return results;
    }

    public static void printSearchResults(List<Searchable> results) {
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено.");
        } else {
            for (Searchable result : results) {
                System.out.println(result.getSearchTerm());
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
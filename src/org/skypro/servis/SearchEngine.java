package org.skypro.servis;

import org.skypro.exception.BestResultNotFound;
import org.skypro.model.Searchable;
import org.skypro.model.SearchableComparator;


import java.util.*;

public class SearchEngine {
    private final Set<Searchable> items;

    private SearchEngine() {
        items = new HashSet<>();
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

    public Set<Searchable> search(String term) {
        Set<Searchable> searchResults = new TreeSet<>(new SearchableComparator());
        for (Searchable item : items) {
            if (item != null && item.getSearchTerm() != null &&
                    item.getSearchTerm().toLowerCase().contains(term.toLowerCase())) {
                searchResults.add(item);
            }
        }
        return searchResults;
    }

    public static void printSearchResults(Set<Searchable> results) {
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено.");
        } else {
            for (Searchable result : results) {
                System.out.println("Продукт: " + result);
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
}
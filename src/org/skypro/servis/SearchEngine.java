package org.skypro.servis;

import org.skypro.model.Article;
import org.skypro.model.Searchable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchEngine {
    private List<Searchable> items;



    private SearchEngine() {
        items = new ArrayList<>();
    }


    public static SearchEngine getInstance() {
        SearchEngine engine = null;
        if (engine == null) {
            engine = new SearchEngine();
        }
        return engine;
    }


    public void add(Searchable item) {
        items.add(item);
    }


    public List<Searchable> search(String searchTerm) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable item : items) {
            if (item.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase())) {
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
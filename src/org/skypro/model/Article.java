package org.skypro.model;

public class Article implements Searchable {
    // Немодифицируемые поля
    private final String title;
    private final String content;

    // Конструктор для инициализации полей
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Геттеры для получения значений полей
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
    public String getSearchTerm() {
        return title.toLowerCase();
    }
    // Переопределение метода toString
    @Override
    public String toString() {
        return title + "\n" + content;
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String getType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return title;
    }

    }

package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private String title;
    private String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String toString() {
        return title + "\n" + text;
    }

    // Реализация интерфейса Searchable
    @Override
    public String getSearchTerm() {
        return toString(); // название + текст
    }

    @Override
    public String getType() {
        return "ARTICLE";
    }

    @Override
    public String getObjectName() {
        return title;
    }
}

package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;
import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return title.equals(article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }
}

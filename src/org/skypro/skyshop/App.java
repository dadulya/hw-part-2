package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.BestResultNotFound;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        try {
            new SimpleProduct("   ", 50);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            new SimpleProduct("Хлеб", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            new DiscountedProduct("Сок", 100, 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        SearchEngine engine = new SearchEngine(10);

        // Добавляем товары
        engine.add(new SimpleProduct("Молоко", 60));
        engine.add(new DiscountedProduct("Яблоко", 50, 20));
        engine.add(new FixPriceProduct("Апельсин"));

        // Добавляем статьи
        engine.add(new Article("Польза яблок", "Яблоки полезны для здоровья"));
        engine.add(new Article("Как выбрать молоко", "Советы по выбору молока в магазине"));
        engine.add(new Article("Апельсины зимой", "Почему апельсины лучше покупать зимой"));

        // Проверка поиска
        String[] queries = {"яблоко", "молоко", "апельсин", "банан"};

        for (String q : queries) {
            Searchable[] results = engine.search(q);
            System.out.println("Результаты поиска для " + q + ":");
            System.out.println(Arrays.toString(results));
        }

        try {
            Searchable best = engine.findBest("молоко");
            System.out.println("Лучший результат: " + best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Searchable best = engine.findBest("киви");
            System.out.println("Лучший результат: " + best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

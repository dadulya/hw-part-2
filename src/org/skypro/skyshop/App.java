package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.*;

import java.util.List;

public class App {
    public static void main(String[] args) {

        // Проверки создания продуктов
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

        SearchEngine engine = new SearchEngine();

        engine.add(new SimpleProduct("Молоко", 60));
        engine.add(new DiscountedProduct("Яблоко", 50, 20));
        engine.add(new FixPriceProduct("Апельсин"));

        engine.add(new Article("Польза яблок", "Яблоки полезны для здоровья"));
        engine.add(new Article("Как выбрать молоко", "Советы по выбору молока в магазине"));
        engine.add(new Article("Апельсины зимой", "Почему апельсины лучше покупать зимой"));

        String[] queries = {"яблоко", "молоко", "апельсин", "банан"};

        for (String q : queries) {
            List<Searchable> results = engine.search(q);
            System.out.println("Результаты поиска для " + q + ":");
            System.out.println(results);
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


        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Молоко", 60));
        basket.addProduct(new SimpleProduct("Хлеб", 30));
        basket.addProduct(new SimpleProduct("Молоко", 60));
        basket.addProduct(new FixPriceProduct("Апельсин"));

        System.out.println("Корзина:");
        basket.printBasket();

        // Удаляем Молоко
        System.out.println("Удаляем 'Молоко':");
        List<Product> removed = basket.removeByName("Молоко");
        System.out.println("Удалено:");
        System.out.println(removed);

        System.out.println("Корзина после удаления:");
        basket.printBasket();

        // Пытаемся удалить несуществующий продукт
        System.out.println("Удаляем 'Банан':");
        List<Product> removed2 = basket.removeByName("Банан");

        if (removed2.isEmpty()) {
            System.out.println("Список пуст");
        }

        System.out.println("Корзина после удаления:");
        basket.printBasket();
    }
}


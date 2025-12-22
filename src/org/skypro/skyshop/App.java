package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.*;

import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {

        SearchEngine engine = new SearchEngine();

        engine.add(new SimpleProduct("Молоко", 60));
        engine.add(new DiscountedProduct("Яблоко", 50, 20));
        engine.add(new FixPriceProduct("Апельсин"));

        engine.add(new Article("Польза яблок", "Яблоки полезны для здоровья"));
        engine.add(new Article("Как выбрать молоко", "Советы по выбору молока в магазине"));
        engine.add(new Article("Апельсины зимой", "Почему апельсины лучше покупать зимой"));

        String[] queries = {"яблоко", "молоко", "апельсин", "банан"};

        for (String q : queries) {
            Set<Searchable> results = engine.search(q);
            System.out.println("Результаты поиска для " + q + ":");

            if (results.isEmpty()) {
                System.out.println("Ничего не найдено");
            }

            for (Searchable item : results) {
                System.out.println(item.getStringRepresentation());
            }
        }

        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Молоко", 60));
        basket.addProduct(new SimpleProduct("Хлеб", 30));
        basket.addProduct(new SimpleProduct("Молоко", 60));
        basket.addProduct(new FixPriceProduct("Апельсин"));

        System.out.println("Корзина:");
        basket.printBasket();

        System.out.println("Удаляем 'Молоко':");
        System.out.println(basket.removeByName("Молоко"));

        System.out.println("Корзина после удаления:");
        basket.printBasket();
    }
}

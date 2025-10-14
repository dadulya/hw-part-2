package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {

        Product apple = new Product("Яблоко", 50);
        Product milk = new Product("Молоко", 60);
        Product bread = new Product("Хлеб", 40);
        Product orange = new Product("Апельсин", 60);
        Product butter = new Product("Масло", 45);
        Product banana = new Product("Банан", 50); //"Невозможно добавить продукт"

        ProductBasket basket = new ProductBasket();

        basket.addProduct(apple);
        basket.addProduct(milk);
        basket.addProduct(bread);
        basket.addProduct(orange);
        basket.addProduct(butter);
        basket.addProduct(banana);

        System.out.println("Содержимое корзины: ");
        basket.printBasket();

        int totalPrice = basket.getTotalPrice();
        System.out.println("Общая стоимость корзины: " + totalPrice);

        System.out.println("Есть ли в корзине 'Молоко'? " + basket.containsProductByName("МОЛОКО"));
        System.out.println("Есть ли в корзине 'Банан'? " + basket.containsProductByName("Банан"));

        basket.clear();

        System.out.println("После очистки корзины: ");
        basket.printBasket();

        System.out.println("Общая стоимость корзины после очистки: " + basket.getTotalPrice());
        System.out.println("Есть ли в корзине 'Яблоко' после очистки? " + basket.containsProductByName("Яблоко"));
    }
}
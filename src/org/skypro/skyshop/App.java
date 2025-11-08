package org.skypro.skyshop;

import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {

        DiscountedProduct apple = new DiscountedProduct("Яблоко", 50, 20);
        SimpleProduct milk = new SimpleProduct("Молоко", 60);
        DiscountedProduct bread = new DiscountedProduct("Хлеб", 40, 30);
        FixPriceProduct orange = new FixPriceProduct("Апельсин");
        SimpleProduct butter = new SimpleProduct("Масло", 45);
        SimpleProduct banana = new SimpleProduct("Банан", 50); //"Невозможно добавить продукт"

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
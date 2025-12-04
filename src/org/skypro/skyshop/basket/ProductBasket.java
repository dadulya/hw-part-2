package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products = new Product[5];

    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printBasket() {
        boolean empty = true;
        int specialCount = 0;

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product);
            if (product.isSpecial()) {
                specialCount++;
            }
            empty = false;
        }
    }
    if (empty) {
        System.out.println("В корзине пусто");
    } else {
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialCount);
    }
}


    public boolean containsProductByName(String name) {
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null && product.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < products.length; i++){
            products[i] = null;
        }
    }
}

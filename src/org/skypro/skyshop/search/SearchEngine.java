package org.skypro.skyshop.search;

public class SearchEngine {
    private Searchable[] items;
    private int count = 0;

    public SearchEngine(int capacity) {
        items = new Searchable[capacity];
    }

    public void add(Searchable s) {
        if (count < items.length) {
            items[count++] = s;
        } else {
            System.out.println("Невозможно добавить элемент, массив заполнен");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int index = 0;
        for (int i = 0; i < count; i++) {
            if (items[i].getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[index++] = items[i];
                if (index == 5) break;
            }
        }
        return results;
    }
}

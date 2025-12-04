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

    private int countOccurrences(String text, String sub) {
        int count = 0;
        int index = 0;
        text = text.toLowerCase();
        sub = sub.toLowerCase();


        int pos = text.toLowerCase().indexOf(sub.toLowerCase(), index);
        while (pos != -1) {
            count++;
            index = pos + sub.length();
            pos = text.toLowerCase().indexOf(sub.toLowerCase(), index);
        }
        return count;
    }

    public Searchable findBest(String search) throws BestResultNotFound {
        int max = 0;
        Searchable best = null;

        for (int i = 0; i < count; i++) {
            int occurrences = countOccurrences(items[i].getSearchTerm(), search);
            if (occurrences > max) {
                max = occurrences;
                best = items[i];
            }
        }

        if (best == null) {
            throw new BestResultNotFound("Не найден объект для запроса: " + search);
        }
        return best;
    }
}


package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> items = new ArrayList<>();


    public void add(Searchable s) {
        items.add(s);
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();

        for (Searchable item : items) {
            if (item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results.add(item);
            }
        }
        return results;
    }

    private int countOccurrences(String text, String sub) {
        int count = 0;
        int index = 0;
        text = text.toLowerCase();
        sub = sub.toLowerCase();


        int pos = text.indexOf(sub, index);
        while (pos != -1) {
            count++;
            index = pos + sub.length();
            pos = text.indexOf(sub, index);
        }
        return count;
    }

    public Searchable findBest(String search) throws BestResultNotFound {
        int max = 0;
        Searchable best = null;

        for (Searchable item : items) {
            int occurrences = countOccurrences(item.getSearchTerm(), search);
            if (occurrences > max) {
                max = occurrences;
                best = item;
            }
        }

        if (best == null) {
            throw new BestResultNotFound("Не найден объект для запроса: " + search);
        }
        return best;
    }
}


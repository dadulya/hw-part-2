package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
        int lengthCompare = Integer.compare(
                o2.getObjectName().length(),
                o1.getObjectName().length()
        );

        if (lengthCompare != 0) {
            return lengthCompare;
        }

        return o1.getObjectName().compareTo(o2.getObjectName());
    }
}


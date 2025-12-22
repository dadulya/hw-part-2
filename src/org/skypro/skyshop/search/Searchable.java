package org.skypro.skyshop.search;

public interface Searchable {
    String getSearchTerm();
    String getType();
    String getObjectName();

    default String getStringRepresentation() {
        return getObjectName() + " - " + getType();
    }
}


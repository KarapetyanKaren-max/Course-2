package org.skypro.model;

public interface Searchable {
    public String  searchTerm();
    public String getType();
    public String getName();

    default String getStringRepresentation(){
            return getType() + "\n" + getName();
    }

    String getSearchTerm();
}

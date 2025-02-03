package org.skypro.model;

import java.util.Objects;

public abstract class  Product implements Searchable {

    protected String name;


    public Product(String name) {

        this.name = name;
    }

    @Override
    public String searchTerm() {
        return name;
    }

    @Override
    public String getType() {
        return "PRODUCT";
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public abstract double getPrice();

        @Override
        public boolean equals (Object o){
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Product product = (Product) o;
            return Objects.equals(name, product.name);
        }

        @Override
        public int hashCode () {
            return Objects.hashCode(name);
        }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }
}
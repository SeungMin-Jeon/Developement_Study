package com.greglturnquist.hackingspringbootch1reactive.shop;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Item {
    private @Id String id; // MongoDB에서 id필드로 사용하기 위해 @Id 지정
    private String name;
    private double price;

    private Item() {}

    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0 && Objects.equals(id, item.id) && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}

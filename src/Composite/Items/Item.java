package Composite.Items;

import Composite.HasPrice;

public abstract class Item implements HasPrice {
    private String info;
    private double price;

    public Item(String info, double price) {
        this.info = info;
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Item info: \"%s\" Item price \"%.2f$\"", info, price);
    }
}

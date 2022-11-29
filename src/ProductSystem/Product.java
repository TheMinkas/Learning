package ProductSystem;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private double weight;

    public Product(int id, String name, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ID: " + this.id +
                " | " + this.name +
                " | Количество товара: " + this.quantity +
                " | Вес товара: " + this.weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

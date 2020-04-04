package ru.gb.lesson1;

public abstract class Fruit {
    private float weight;
    private int quantity;

    public Fruit(float weight, int quantity) {
        this.weight = weight;
        this.quantity = quantity;
    }

    public float getWeight() {
        return weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

package ru.gb.lesson1;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private T fruit;
    private List<T> list = new ArrayList<T>();

    public Box(T fruit) {
        this.fruit = fruit;
        list.add(fruit);
    }

    public List<T> getList() {
        return list;
    }

    public int getQuantity() {
        if (list.isEmpty()) {
            return 0;
        }
        return list.get(0).getQuantity();
    }

    public float getWeight() {
        return list.get(0).getQuantity() * list.get(0).getWeight();
    }

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    public void transferFruitsTo(Box<T> box) {
        box.getList().addAll(list);
        list.clear();
    }

    public void addFruitsInBox(int quantity) {
        list.get(0).setQuantity((quantity + list.get(0).getQuantity()));
    }
}

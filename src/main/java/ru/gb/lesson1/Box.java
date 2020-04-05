package ru.gb.lesson1;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> list = new ArrayList<T>();

    public List<T> getList() {
        return list;
    }

    public int getQuantity() {
        return list.size();
    }

    public float getWeight() {
        float sum = 0.0f;
        for (int i = 0; i < getList().size(); i++) {
            sum += getList().get(i).getWeight();
        }
        return sum;
    }

    public boolean compare(Box box) {
        return Math.abs(getWeight() - box.getWeight()) < 0.00001f;
    }

    public void transferFruitsTo(Box<T> box) {
        box.getList().addAll(list);
        list.clear();
    }

    public void addFruitInBox(T fruit) {
        list.add(fruit);
    }
}

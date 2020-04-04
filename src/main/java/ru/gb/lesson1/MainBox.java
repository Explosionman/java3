package ru.gb.lesson1;

public class MainBox {

    public static void main(String[] args) {
        Apple apple = new Apple(1.0f, 150);
        Orange orange = new Orange(1.5f, 100);
        Box<Apple> box1 = new Box<Apple>(apple);
        Box<Orange> box2 = new Box<Orange>(orange);
        Box<Orange> box3 = new Box<Orange>(orange);

        System.out.println("Вес box1 с " + box1.getQuantity() + " яблоками: " + box1.getWeight());
        System.out.println("Вес box2 с " + box2.getQuantity() + " апельсинами: " + box2.getWeight());
        System.out.println("Короба box1 и box2 весят одинаково? - Ответ: " + box1.compare(box2));

        box2.transferFruitsTo(box3);

        System.out.println("Количество в box3 после пересыпания из box2: " + box3.getQuantity());
        System.out.println("Оставшееся кол-во в box2 после пересыпания в box3: " + box2.getQuantity());

        box3.addFruitsInBox(500);
        System.out.println("Количество в box3 после добавления 500 шт.: " + box3.getQuantity());
    }
}

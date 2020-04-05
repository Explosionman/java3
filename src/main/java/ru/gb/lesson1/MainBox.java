package ru.gb.lesson1;

public class MainBox {

    public static void main(String[] args) {
        Box<Apple> box1 = new Box<Apple>();
        Box<Orange> box2 = new Box<Orange>();
        Box<Orange> box3 = new Box<Orange>();

        System.out.println("Добавляем по 5 шт. фруктов в box1 и box3");
        for (int i = 0; i < 5; i++) {
            box1.addFruitInBox(new Apple(0.15f));
            box2.addFruitInBox(new Orange(0.15f));
        }

        System.out.printf("Вес box1 с %d яблоками: %.2f\n", box1.getQuantity(), box1.getWeight());
        System.out.printf("Вес box2 с %d апельсинами: %.2f\n", box2.getQuantity(), box2.getWeight());
        System.out.println("Короба box1 и box2 весят одинаково? - Ответ: " + box1.compare(box2));
        System.out.println("_______________________________________________________________________");

        box2.transferFruitsTo(box3);

        System.out.println("Количество в box3 после пересыпания из box2: " + box3.getQuantity());
        System.out.println("Оставшееся кол-во в box2 после пересыпания в box3: " + box2.getQuantity());
        System.out.printf("Обновленный вес box2 с %d апельсинами: %.2f\n", box2.getQuantity(), box2.getWeight());
        System.out.println("_______________________________________________________________________");
        System.out.println("Добавляем по 3 шт. фруктов в box1 и box3");

        for (int i = 0; i < 3; i++) {
            box1.addFruitInBox(new Apple(0.15f));
            box3.addFruitInBox(new Orange(0.2f));
        }

        System.out.println("_______________________________________________________________________");
        System.out.printf("Обновленный вес box3 с %d апельсинами: %.2f\n", box3.getQuantity(), box3.getWeight());
        System.out.println("Количество в box3 после добавления: " + box3.getQuantity());
        System.out.printf("Обновленный вес box1 с %d яблоками: %.2f\n", box1.getQuantity(), box1.getWeight());
        System.out.println("Количество в box1 после добавления: " + box1.getQuantity());
        System.out.println("Короба box1 и box3 весят одинаково? - Ответ: " + box1.compare(box3));
    }
}

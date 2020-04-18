package ru.gb.lesson5;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


public class MainClass {
    public static final int CARS_COUNT = 4;

    public static final CountDownLatch CDL = new CountDownLatch(CARS_COUNT + 1);
    public static final Semaphore SEMAPHORE = new Semaphore(2);
    public static AtomicInteger ai = new AtomicInteger(0);


    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
    }
}
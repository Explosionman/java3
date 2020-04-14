package ru.gb.lesson4;

//1. Создать три потока, каждый из которых выводит определенную букву (A, B и C) 5 раз (порядок – ABСABСABС).
//        Используйте wait/notify/notifyAll.

public class Main {
    private static volatile int streamNumber = 1;

    public static void main(String[] args) {
        Object obj = new Object();

        new Thread(() -> {
            synchronized (obj) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (streamNumber != 1) {
                            obj.wait();
                        }
                        System.out.print("A");
                        streamNumber = 2;
                        obj.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (obj) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (streamNumber != 2) {
                            obj.wait();
                        }
                        System.out.print("B");
                        streamNumber = 3;
                        obj.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (obj) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (streamNumber != 3) {
                            obj.wait();
                        }
                        System.out.print("C");
                        streamNumber = 1;
                        obj.notifyAll();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

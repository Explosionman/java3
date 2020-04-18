package ru.gb.lesson5;

import java.util.concurrent.BrokenBarrierException;

public class Car implements Runnable {
    private static int CARS_COUNT;


    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            MainClass.CDL.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (MainClass.CDL.getCount() == 1) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            MainClass.CDL.countDown();
        }

        try {
            MainClass.CDL.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {

            if (race.getStages().get(i).getClass().equals(Tunnel.class)) {
                try {
                    MainClass.SEMAPHORE.acquire();
                    race.getStages().get(i).go(this);
                    MainClass.SEMAPHORE.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else race.getStages().get(i).go(this);
        }
        int result = MainClass.ai.incrementAndGet();
        if (result == 1) {
            System.out.println(name + " - WIN!");
        } else if (result == 4) {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }

    }
}
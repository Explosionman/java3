package ru.gb.lesson3.transfer;

import java.io.Serializable;

public class Student implements Serializable {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void info() {
        System.out.println("ID: " + id + ", name: " + name);
    }
}

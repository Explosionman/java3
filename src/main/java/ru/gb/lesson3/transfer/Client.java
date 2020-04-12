package ru.gb.lesson3.transfer;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String args[]) throws IOException {
        try {
            Socket cs = new Socket("127.0.0.1", 8189);
            ObjectOutputStream serializer = new ObjectOutputStream(cs.getOutputStream());
            System.out.println("Клиент подключился к серверу");
            Student student = new Student(1, "Alex");
            serializer.writeObject(student);
            serializer.flush();
            System.out.println("На сервер отправлены данные:");
            student.info();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

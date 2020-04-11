package ru.gb.lesson3.transfer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    Socket socket;

    Server(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (ObjectInputStream deserializer = new ObjectInputStream(socket.getInputStream());){
                Student student = (Student) deserializer.readObject();
                System.out.println("Данные прочитаны: ");
                student.info();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        try {
            ServerSocket serverSocket = new ServerSocket(8189);
            System.out.println("Серевер успешно запущен.");
            while (true) {
                Socket sock = serverSocket.accept();
                System.out.println("Подлючен " + sock);
                Thread t = new Thread(new Server(sock));
                t.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

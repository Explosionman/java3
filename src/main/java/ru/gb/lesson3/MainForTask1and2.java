package ru.gb.lesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class MainForTask1and2 {
    public static void main(String[] args) throws IOException {
        //task1
        try (FileInputStream in = new FileInputStream("task1.txt")) {
            byte[] arr = new byte[60];
            int x;

            while ((x = in.read(arr)) > 0) {
                System.out.println("Task1:");
                System.out.println(new String(arr, 0, x));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //task2
        ArrayList<InputStream> al = new ArrayList<>();
        al.add(new FileInputStream("task2.1.txt"));
        al.add(new FileInputStream("task2.2.txt"));
        al.add(new FileInputStream("task2.3.txt"));
        al.add(new FileInputStream("task2.4.txt"));
        al.add(new FileInputStream("task2.5.txt"));

        SequenceInputStream in = new SequenceInputStream(Collections.enumeration(al));
        int x;
        System.out.println("Task2:");
        while ((x = in.read()) != -1) {
            System.out.print((char) x);
        }
        in.close();

        //Task3

    }
}

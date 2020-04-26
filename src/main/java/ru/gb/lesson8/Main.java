package ru.gb.lesson8;

public class Main {
    private static final int SIZE = 6;
    private static int[][] arr;
    private static int counter = 1;

    public static void main(String[] args) {
        initMatrix();
        printMatrix();
    }

    public static void initMatrix() {
        arr = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                arr[i][j] = counter;
                counter++;
            }
        }
    }

    public static void printMatrix() {
        for (int i = 0; i < SIZE; i++) {
            if (i % 2 != 0) {
                for (int j = SIZE - 1; j >= 0; j--) {
                    System.out.print(arr[i][j] + "\t");
                }
            } else {
                for (int j = 0; j < SIZE; j++) {
                    System.out.print(arr[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }
}

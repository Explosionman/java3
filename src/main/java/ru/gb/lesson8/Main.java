package ru.gb.lesson8;

public class Main {
    private static final int SIZE = 7;
    private static int[][] arr;
    private static int counter = 1;

    public static void main(String[] args) {
        initMatrix();
        printMatrix();
    }

    public static void initMatrix() {
        arr = new int[SIZE][SIZE];

        //заполняем по периметру
        for (int i = 0; i < arr.length; i++) {
            arr[0][i] = counter;
            counter++;
        }
        for (int j = 1; j < arr.length; j++) {
            arr[j][arr.length - 1] = counter;
            counter++;
        }
        for (int y = arr.length - 2; y >= 0; y--) {
            arr[arr.length - 1][y] = counter;
            counter++;
        }
        for (int x = arr.length - 2; x > 0; x--) {
            arr[x][0] = counter;
            counter++;
        }

        //переменные, для указания следующей начальной точки
        int a = 1;
        int b = 1;

        //заполняем остальные элементы, останется только 1 цифра в центре
        while (counter < SIZE * SIZE) {
            while (arr[a][b + 1] == 0) {
                arr[a][b] = counter;
                counter++;
                b++;
            }
            while (arr[a + 1][b] == 0) {
                arr[a][b] = counter;
                counter++;
                a++;
            }
            while (arr[a][b - 1] == 0) {
                arr[a][b] = counter;
                counter++;
                b--;
            }
            while (arr[a - 1][b] == 0) {
                arr[a][b] = counter;
                counter++;
                a--;
            }
        }

        //находим последний элемент и заполняем его
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = counter;
                }
            }
        }
    }

    public static void printMatrix() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}


package ru.gb.lesson6;

import java.util.Stack;

public class Tasks {
    //task1
    public int[] getModifiedArray(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Мессив не может быть пустым!");
        }
        Stack<Integer> temp = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != 4 && i == 0) {
                throw new RuntimeException("В массиве нет ни одной четверки");
            } else if (arr[i] == 4) {
                break;
            } else if (arr[i] != 4) {
                temp.push(arr[i]);
            }
        }
        int[] result = new int[temp.size()];
        for (int j = 0; j < result.length; j++) {
            result[j] = temp.pop();
        }
        return result;
    }

    //task2
    public boolean checkArray(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Мессив не может быть пустым!");
        }
        int counter1 = 0;
        int counter2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                counter1++;
            } else if (arr[i] == 4) {
                counter2++;
            }
        }
        if (counter1 == 0 || counter2 == 0) return false;
        return (counter1 + counter2) == arr.length;
    }
}

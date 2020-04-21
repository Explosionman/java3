package ru.gb.lesson6;

public class Main {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 3, 3, 5, 7};
        int[] arr2 = {1, 4, 1, 1, 4, 4, 4};

        Tasks task = new Tasks();
        System.out.println("Ответ на первое задание: " + java.util.Arrays.toString(task.getModifiedArray(arr1)));
        System.out.println("Ответ на второе задание при проверке массива " + java.util.Arrays.toString(arr2) + ": " + task.checkArray(arr2));
    }
}

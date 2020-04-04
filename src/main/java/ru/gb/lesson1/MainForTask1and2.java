package ru.gb.lesson1;

import java.util.*;

public class MainForTask1and2 {
    //For test
    //private static String[] arr = {"Первый", "Второй", "Третий", "Четвертый", "Пятый", "Шестой"};
    private static Integer[] arr2 = {1,2,3,4,5};
    private static List<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {
        //task1
        System.out.println("Изначальный массив: " + Arrays.toString(arr2));
        changeElements(arr2,1, 3);
        System.out.println("Массив после изменений: " + Arrays.toString(arr2));

        //task2
      //  convertToArrayList(list, arr);
        convertToArrayList(list, arr2);
        System.out.println(list.getClass() + ": " + list);
    }

    //Метод меняет два элемента массива местами
    private static void changeElements(Object[] arr, int oldIndexValue, int newIndexValue) throws ArrayIndexOutOfBoundsException {
        try {
            Object temp = arr[oldIndexValue];
            arr[oldIndexValue] = arr[newIndexValue];
            arr[newIndexValue] = temp;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Введены некорректные данные");
        }
    }

    //Метод преобразует массив в ArrayList
    private static void convertToArrayList(List<?> list, Object[] arr) {
      Collections.addAll((List<? super Object>) list, arr);
    }
}

package ru.gb.lesson3;

import java.io.FileInputStream;
import java.io.IOException;

public class PageReaderForTask3 {
    //Собираем в стрингбилдер считанные данные из файла
    private static StringBuilder fileData = new StringBuilder();
    //Длина страницы (символов)
    private static final int PAGE_LENGTH = 1800;

    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        try {
            System.out.println(getPageFromFile(1));
            System.out.println(getPageFromFile(2));
            //Проверка работы исключения
            System.out.println(getPageFromFile(33663));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        long e = System.currentTimeMillis();
        System.out.println("Время работы программы: " + (e - s));
    }


    //Метод для считывания файла и сборки его в стрингбилдер
    private static String readFile(String fileName) {
        try (FileInputStream in = new FileInputStream(fileName)) {
            byte[] arr = new byte[512];
            int x;

            while ((x = in.read(arr)) > 0) {
                fileData.append(new String(arr, 0, x));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileData.toString();
    }

    //Метод для получения данных из конкретной страницы
    public static String getPageFromFile(int pageNumber) throws IllegalArgumentException{
        long startReadTime = System.currentTimeMillis();
        int pageSymbolsStart = PAGE_LENGTH * (pageNumber - 1);
        int pageSymbolsEnd = PAGE_LENGTH * (pageNumber);

        if (fileData.length() == 0) {
            readFile("task3.txt");
            System.out.println("Считываем данные из файла");
        } else {
            System.out.println("Берем данные из кэша");
        }

        if (pageNumber < 1 || Math.ceil(fileData.length() / PAGE_LENGTH) < pageNumber) {
            throw new IllegalArgumentException("Страницы " + pageNumber + " не существует");
        }
        long endReadTime = System.currentTimeMillis();
        System.out.println("Время чтения: " + (endReadTime - startReadTime));
        return fileData.substring(pageSymbolsStart, pageSymbolsEnd);
    }
}

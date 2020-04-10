package ru.gb.lesson2;

import java.io.FileNotFoundException;
import java.sql.*;

public class Main {
    private static final String UPDATE_FILE = "update.txt";

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        DataBase dataBase = new DataBase();
        try {
            dataBase.connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("База подключена");

        //Создаём таблицу
        dataBase.create();
        //Заполняем таблицу данными
        dataBase.insert();
        //Вывод таблицы
        dataBase.select();
        //Обновляем данные в таблице
        dataBase.update(2, 63);
        //Вывод таблицы, просмотр изменений
        dataBase.select();
        //Удаление строки по ID
        dataBase.delete(4);
        //Вывод таблицы, просмотр изменений
        dataBase.select();
        //Обновляем данные, считывая их из файла
        dataBase.updateScoresFromTxt(UPDATE_FILE);
        //Вывод таблицы, просмотр изменений
        dataBase.select();

        dataBase.disconnect();
    }
}

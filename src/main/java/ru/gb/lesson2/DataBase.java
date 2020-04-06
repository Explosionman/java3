package ru.gb.lesson2;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

public class DataBase {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;
    private static ResultSet resultSet;
    private List<String> list = new ArrayList<String>();

    private void readFile(String fileName) {
        out.println("Считываем данные из файла");
        try {
            File file = new File(fileName);
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                list.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        out.println("Данные файла считаны в список");
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:studentsDB.db");
        stmt = connection.createStatement();
    }

    public void create() throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS  'students' (id INTEGER PRIMARY KEY AUTOINCREMENT, 'name' String, 'score' INT);");
        out.println("Создана таблица");
    }

    public void insert() throws SQLException {
        for (int i = 1; i < 5; i++) {
            stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob" + i + "', " + (i * 13) + ")");
        }
        out.println("В таблицу добавлены данные");
    }

    public void update(int id, int score) throws SQLException {
        stmt.executeUpdate("UPDATE students SET score=" + score + " WHERE id=" + id + ";");
        out.println("Изменены данные в id: " + id);
    }

    public void select() throws SQLException {
        resultSet = stmt.executeQuery("SELECT id, name, score FROM students");
        out.println("\tid" + "\tname" + "\tscore");
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString("name");
            int score = resultSet.getInt("score");
            out.println("\t" + id + " \t" + name + " \t" + score);
        }
    }

    public void delete(int id) throws SQLException {
        stmt.execute("DELETE FROM students WHERE id=" + id + ";");
        out.println("Удалена строка с ID: " + id);
    }

    /*
     * Перебираем строки из списка, сплитим и используем значения для обнорвления/добавления
     * line[0] = id
     * line[1] = name
     * line[3] = score
     */
    public void updateScoresFromTxt(String fileName) throws NumberFormatException, SQLException {
        readFile(fileName);

        for (int i = 1; i < this.list.size(); i++) {
            String[] line = this.list.get(i).split("\\s+");
            resultSet = stmt.executeQuery("SELECT name from students WHERE id = " + Integer.valueOf(line[0]) + "");

            if (resultSet.next()) {
                stmt.executeUpdate("UPDATE students SET score=" + Integer.valueOf(line[2]) + " " +
                        "WHERE id=" + Integer.valueOf(line[0]) + ";");
                out.println("Обновлено старое значение");
            } else {
                stmt.execute("INSERT INTO students (name, score) " +
                        "VALUES ('" + line[1] + "', " + Integer.valueOf(line[2]) + ")");
                out.println("Записано новое значение");
            }
        }
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println("База отключена");
    }
}

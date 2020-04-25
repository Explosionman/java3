package ru.gb.lesson7.checkDZ;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Checker {
    private final String isNegative = "isNegative";
    private final String isLeapYear = "isLeapYear";
    private final String checkTwoNumbers = "checkTwoNumbers";
    private final String calculateInt = "calculate";
    private final String calculateFloat = "calculate";

    public void check() throws Exception {
        File file = new File("C:/task2");
        String[] str = file.list();

        for (String o : str) {
            String[] mass = o.split("\\.");
            if (!mass[1].equalsIgnoreCase("class")) {
                throw new RuntimeException(o, new Exception());
            }

            Class ch = URLClassLoader.newInstance(new URL[]{file.toURL()}).loadClass(mass[0]);
            Constructor constructor = ch.getConstructor();
            Object obj = constructor.newInstance();

            Method[] methods = ch.getDeclaredMethods();
            for (Method m : methods) {
                if (!m.getGenericReturnType().equals(void.class)) {
                    m.setAccessible(true);

                    if (m.getName().equals(isNegative)) {

                        System.out.println(((m.invoke(obj, -1).equals(true)) ? ch.getName() + " реализовал метод " +
                                m.getName() + " правильно!" : ch.getName() + " реализовал метод " + m.getName() + " неверно!"));

                    } else if (m.getName().equals(isLeapYear)) {

                        System.out.println(((m.invoke(obj, 2020).equals(true)) ? ch.getName() + " реализовал метод " +
                                m.getName() + " правильно!" : ch.getName() + " реализовал метод " + m.getName() + " неверно!"));

                    } else if (m.getName().equals(checkTwoNumbers)) {

                        System.out.println(((m.invoke(obj, 5, 4).equals(false)) ? ch.getName() + " реализовал метод " +
                                m.getName() + " правильно!" : ch.getName() + " реализовал метод " + m.getName() + " неверно!"));

                    } else if (m.getName().equals(calculateFloat) && m.getGenericReturnType().equals(float.class)) {

                        System.out.println(((m.invoke(obj, 1, 2, 3, 4.0f).equals(2.75f)) ? ch.getName() + " реализовал метод " +
                                m.getName() + " c float args правильно!" : ch.getName() + " реализовал метод " + m.getName() + " c float args неверно!"));
                    } else if (m.getName().equals(calculateInt) && m.getGenericReturnType().equals(int.class)) {

                        System.out.println(((m.invoke(obj, 1, 1, 1, 1).equals(2)) ? ch.getName() + " реализовал метод " +
                                m.getName() + " c int args правильно!" : ch.getName() + " реализовал метод " + m.getName() + " c int args неверно!"));
                    }
                }
            }
        }
    }
}

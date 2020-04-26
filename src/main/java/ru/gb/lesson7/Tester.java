package ru.gb.lesson7;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;

public class Tester {

    public void start(String fileName) throws Exception {
        int afterSuiteCounter = 0;
        int beforeSuiteCounter = 0;
        Method first = null;
        Method last = null;
        List<Method> methodsArray = new ArrayList<>();

        Class h = URLClassLoader.newInstance(new URL[]{
                new File("C:/forTest").toURL()
        }).loadClass(fileName);

        Constructor constructor = h.getConstructor(String.class, String.class, int.class, int.class);
        Object obj = constructor.newInstance("Alex", "Fisher", 30, 180);
        LinkedList<String> asd = new LinkedList<>();

        Method[] methods = h.getDeclaredMethods();

        //Перебираем методы, добавляем методы с аннотацией Test в список.
        //Считаем кол-во методов @BeforeSuite и @AfterSuite, присваиваем их значения переменным first и last
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuiteCounter++;
                first = m;
            } else if (m.isAnnotationPresent(AfterSuite.class)) {
                afterSuiteCounter++;
                last = m;
            } else if (m.isAnnotationPresent(Test.class)) {
                methodsArray.add(m);
            }
        }

        //Проверяем условие задачи: Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать
        // в единственном экземпляре
        if (afterSuiteCounter != 1 || beforeSuiteCounter != 1) {
            throw new RuntimeException("Методы BeforeSuite или AfterSuite должны быть по 1 экз., не больше и не меньше");
        }

        //Сортируем список в порядке возрастания по priority(). IDEA сама предложила заметить на лямбду, я был не против)
        methodsArray.sort((o1, o2) -> {
            if (o2.getAnnotation(Test.class).priority() == o1.getAnnotation(Test.class).priority()) {
                return 0;
            } else if ((o1.getAnnotation(Test.class).priority() > o2.getAnnotation(Test.class).priority())) {
                return 1;
            }
            return -1;
        });

        //Выводим "тесты" в консоль
        first.invoke(obj);
        for (int i = 0; i < methodsArray.size(); i++) {
            methodsArray.get(i).invoke(obj);
        }
        last.invoke(obj);
    }
}


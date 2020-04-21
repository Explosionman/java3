package ru.gb.lesson6;

import org.junit.*;

public class TasksTest {
    Tasks awa;

    @Before
    public void init() {
        awa = new Tasks();
    }

    /*
    Testing method getModifiedArray from class Tasks
     */

    @Test(expected = IllegalArgumentException.class)
    public void givenEmptyArray_whenGetModifiedArray_thenIllegalArgumentException() {
        int[] actual = {};
        awa.getModifiedArray(actual);
    }

    @Test(expected = RuntimeException.class)
    public void givenArrayWithout4_whenGetModifiedArray_thenIllegalArgumentException() {
        int[] actual = {1, 3, 6, 5, 8, 7, 1};
        awa.getModifiedArray(actual);
    }

    /*
    Testing method checkArray from class Tasks
     */

    @Test(expected = IllegalArgumentException.class)
    public void givenEmptyArray_whenCheckArray_thenIllegalArgumentException() {
        int[] actual = {};
        awa.checkArray(actual);
    }
}

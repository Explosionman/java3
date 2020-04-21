package ru.gb.lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TasksGetModifiedArrayMassTest {
    private int[] actual;
    private int[] expected;

    public TasksGetModifiedArrayMassTest(int[] actual, int[] expected) {
        this.actual = actual;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection testCasesForGetModifiedArray() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4, 4, 4, 5, 7, 8}, new int[]{5, 7, 8}},
                {new int[]{1, 4, 3, 1, 2, 3, 5, 7, 8}, new int[]{3, 1, 2, 3, 5, 7, 8}},
                {new int[]{1, 4, 3, 1, 2, 3, 5, 4, 8}, new int[]{8}}
        });
    }

    Tasks task;

    @Before
    public void init() {
        task = new Tasks();
    }

    @Test
    public void massTestGetArrayAfterLastDigitFour() {
        Assert.assertArrayEquals(expected, task.getModifiedArray(actual));
    }
}
